package net.brdle.collectorsreap.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;

public abstract class FruitBushBlock extends DoublePlantBlock implements BonemealableBlock {

	public static final int MAX_AGE = 4;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
	public static BooleanProperty STUNTED = BooleanProperty.create("stunted");

	public FruitBushBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState()
			.setValue(AGE, 0)
			.setValue(HALF, DoubleBlockHalf.LOWER)
			.setValue(STUNTED, false)
		);
	}

	public static void placeAt(LevelAccessor level, BlockState state, BlockPos pos, int flags) {
		BlockState belowState = state.setValue(HALF, DoubleBlockHalf.LOWER).setValue(STUNTED, false);
		if (!belowState.hasProperty(AGE)) {
			belowState.setValue(AGE, MAX_AGE);
		}
		if (belowState.getValue(AGE) <= 1) {
			level.setBlock(pos, copyWaterloggedFrom(level, pos, belowState), flags);
		} else if (
			belowState.getValue(AGE) > 1 &&
				belowState.getBlock() instanceof FruitBushBlock fruit &&
				fruit.canSurvive(state, level, pos)
		) {
			DoublePlantBlock.placeAt(level, belowState, pos, flags);
		}
	}

	@Override
	public PlantType getPlantType(BlockGetter level, BlockPos pos) {
		return PlantType.PLAINS;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE, STUNTED, HALF);
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos blockpos = context.getClickedPos();
		Level level = context.getLevel();
		return (
			blockpos.getY() < level.getMaxBuildHeight() &&
				level.getBlockState(blockpos.above()).canBeReplaced(context) ?
				this.defaultBlockState() : null
		);

	}

	@Override
	public void setPlacedBy(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @NotNull LivingEntity pPlacer, @NotNull ItemStack pStack) {
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return state.getValue(AGE) < MAX_AGE && state.getValue(HALF) == DoubleBlockHalf.LOWER && !state.getValue(STUNTED);
	}

	public abstract Item getFruit();

	public abstract Item getSeeds();

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
		return new ItemStack(this.getSeeds());
	}

	public ItemStack getSpecialFruit() {
		return ItemStack.EMPTY;
	}

	public int getSpecialChance() {
		return 0;
	}

	public boolean isSpecial(Level level, BlockPos pos) {
		int chance = this.getSpecialChance();
		return (
			!this.getSpecialFruit().isEmpty() &&
			chance != 0 &&
			level.getRandom().nextInt(chance) == 0
		);
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull InteractionResult use(BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
		if (state.getValue(AGE) != MAX_AGE && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
			return InteractionResult.PASS;
		}
		if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
			state = level.getBlockState(pos.below());
			pos = pos.below();
		}
		if (state.getValue(AGE) == MAX_AGE) {
			if (state.getBlock() instanceof PomegranateBushBlock && !player.getItemInHand(hand).is(Tags.Items.SHEARS)) {
				player.hurt(player.damageSources().sweetBerryBush(), 1.0F);
			}
			dropFruit(level, pos);
			level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
			BlockState picked = state.setValue(AGE, MAX_AGE - 2);
			level.setBlock(pos, picked, 2); // Revert to pre-flowering
			level.setBlock(pos.above(), picked.setValue(HALF, DoubleBlockHalf.UPPER), 2); // Revert upper to pre-flowering
			level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, picked));
			return InteractionResult.sidedSuccess(level.isClientSide());
		} else if (player.getItemInHand(hand).getItem() instanceof AxeItem && !state.hasProperty(STUNTED)) {
			BlockState stunted = state.setValue(STUNTED, true);
			level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
			level.setBlockAndUpdate(pos, stunted);
			level.setBlockAndUpdate(pos.above(), stunted.setValue(HALF, DoubleBlockHalf.UPPER));
			level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, stunted));
			player.getItemInHand(hand).hurtAndBreak(1, player, (b) -> b.broadcastBreakEvent(b.getUsedItemHand()));
			return InteractionResult.sidedSuccess(level.isClientSide());
		} else {
			return super.use(state, level, pos, player, hand, hit);
		}
	}

	@Override
	public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, BlockState state) {
		if (state.hasProperty(HALF) && state.getValue(HALF) == DoubleBlockHalf.UPPER) {
			pos = pos.below();
			state = level.getBlockState(pos);
		}
		state = state.setValue(AGE, Math.min(MAX_AGE, state.getValue(AGE) + 1));
		level.setBlockAndUpdate(pos, state);
		if (state.getValue(AGE) > 1) {
			level.setBlockAndUpdate(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER));
		}
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource randomSource, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
		return true;
	}

	public int getNumFruit(int add) {
		return 1 + add;
	}

	public void dropFruit(Level level, BlockPos pos) {
		ItemStack stack;
		if (this.isSpecial(level, pos)) { // Empty-checks getSpecialFruit
			stack = this.getSpecialFruit().copy();
		} else {
			int additional = level.getRandom().nextIntBetweenInclusive(1, 2);
			stack = new ItemStack(this.getFruit(), this.getNumFruit(additional));
		}
		Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), stack);
	}
}