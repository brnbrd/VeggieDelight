package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nullable;

public class LimeBushBlock extends CropBlock implements IFruiting {
	public static final int MAX_AGE = 2;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
	public static final BooleanProperty STUNTED = BooleanProperty.create("stunted");
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	private static final VoxelShape SHAPE_LOWER = Shapes.or(Block.box(0.0D, 11.0D, 0.0D, 16.0D, 24.0D, 16.0D), Block.box(6.0D, 0.0D, 6.0D, 10.0D, 11.0D, 10.0D));
	private static final VoxelShape SHAPE_UPPER = Shapes.or(Block.box(0.0D, -5.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(6.0D, -16.0D, 6.0D, 10.0D, -5.0D, 10.0D));

	public LimeBushBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any()
			.setValue(AGE, 0)
			.setValue(STUNTED, false)
			.setValue(HALF, DoubleBlockHalf.LOWER)
		);
	}

	@Override
	public @NotNull IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public int getMaxAge() {
		return MAX_AGE;
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getCollisionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		if (pContext instanceof EntityCollisionContext ent && ent.getEntity() instanceof Bee && CRConfig.LIME_POLLINATION.get()) {
			return pState.getValue(HALF) == DoubleBlockHalf.LOWER ?
				Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D) : Shapes.empty();
		}
		return getShape(pState, pLevel, pPos, pContext);
	}

	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return state.getValue(HALF) == DoubleBlockHalf.UPPER ? SHAPE_UPPER : SHAPE_LOWER;
	}

	@Override
	public @NotNull BlockState updateShape(@NotNull BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor world, @NotNull BlockPos pos, @NotNull BlockPos facingPos) {
		BlockState AIR = Blocks.AIR.defaultBlockState();
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER && !state.canSurvive(world, pos)) {
			return AIR;
		}
		if (
			(state.getValue(HALF) == DoubleBlockHalf.UPPER && facing == Direction.DOWN) ||
			(state.getValue(HALF) == DoubleBlockHalf.LOWER && facing == Direction.UP)
		) {
			if (!(facingState.getBlock() instanceof LimeBushBlock) || facingState.getValue(HALF) == state.getValue(HALF)) {
				return AIR;
			}
			return state.setValue(AGE, facingState.getValue(AGE)).setValue(STUNTED, facingState.getValue(STUNTED));
		}
		return super.updateShape(state, facing, facingState, world, pos, facingPos);
	}

	@Override
	protected boolean mayPlaceOn(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
		return pState.is(BlockTags.DIRT) || pState.is(Blocks.FARMLAND);
	}

	@Override
	public boolean canSurvive(BlockState state, @NotNull LevelReader level, BlockPos pos) {
		BlockPos belowPos = pos.below();
		BlockState below = level.getBlockState(belowPos);
		return (
			state.getValue(HALF) == DoubleBlockHalf.LOWER ?
				this.mayPlaceOn(below, level, belowPos) :
				below.getBlock() instanceof LimeBushBlock && (level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos))
		);
	}

	@Override
	protected @NotNull ItemLike getBaseSeedId() {
		return CRItems.LIME_SEEDS.get();
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
		return new ItemStack(state.getValue(AGE) == this.getMaxAge() ? CRItems.LIME.get() : this.getBaseSeedId());
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE, STUNTED, HALF);
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return state.getValue(AGE) < this.getMaxAge() && state.getValue(HALF) == DoubleBlockHalf.LOWER && !state.getValue(STUNTED);
	}

	@Override
	public void randomTick(BlockState state, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
		int age = state.getValue(AGE);
		if (
			(
				(age < (this.getMaxAge() - 1) && CRConfig.LIME_POLLINATION.get()) ||
				(age < (this.getMaxAge()) && !CRConfig.LIME_POLLINATION.get())
			) &&
			state.getValue(HALF) == DoubleBlockHalf.LOWER && !state.getValue(STUNTED) &&
			ForgeHooks.onCropsGrowPre(pLevel, pPos, state, pRandom.nextInt(12) == 0)
		) {
			this.performBonemeal(pLevel, pRandom, pPos, state);
			ForgeHooks.onCropsGrowPost(pLevel, pPos, state);
		}
	}

	@Override
	public Item getFruit() {
		return CRItems.LIME.get();
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull InteractionResult use(BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
		if (pState.getValue(AGE) == this.getMaxAge()) {
			dropFruit(pLevel, pPos);
			pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
			BlockState picked = pState.setValue(AGE, 0);
			pLevel.setBlock(pPos, picked, 2); // Revert to pre-flowering
			pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, picked));
			return InteractionResult.sidedSuccess(pLevel.isClientSide());
		} else if (pPlayer.getItemInHand(pHand).getItem() instanceof AxeItem && !pState.hasProperty(STUNTED)) {
			BlockState stunted = pState.setValue(STUNTED, true);
			pLevel.playSound(pPlayer, pPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
			pLevel.setBlockAndUpdate(pPos, stunted);
			pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, stunted));
			pPlayer.getItemInHand(pHand).hurtAndBreak(1, pPlayer, (b) -> b.broadcastBreakEvent(b.getUsedItemHand()));
			return InteractionResult.sidedSuccess(pLevel.isClientSide());
		} else if (pPlayer.getItemInHand(pHand).is(Items.BONE_MEAL)) {
			return InteractionResult.PASS;
		} else {
			return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
		}
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader pLevel, @NotNull BlockPos pPos, BlockState pState, boolean pIsClient) {
		return pState.getValue(AGE) < (this.getMaxAge() - 1);
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, @NotNull BlockState pState) {
		return true;
	}

	@Override
	protected int getBonemealAgeIncrease(@NotNull Level pLevel) {
		return 1;
	}

	@Override
	public void performBonemeal(ServerLevel pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, BlockState pState) {
		pLevel.setBlockAndUpdate(pPos, pState.setValue(AGE, Math.min(this.getMaxAge(), pState.getValue(AGE) + 1)));
	}

	@Override
	@Nullable public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		BlockPos blockpos = pContext.getClickedPos();
		Level level = pContext.getLevel();
		return (
			blockpos.getY() < level.getMaxBuildHeight() - 1 &&
			level.getBlockState(blockpos.above()).canBeReplaced(pContext) ?
				this.defaultBlockState().setValue(AGE, 0).setValue(STUNTED, false).setValue(HALF, DoubleBlockHalf.LOWER) :
				null
		);
	}

	@Override
	public void setPlacedBy(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, LivingEntity pPlacer, @NotNull ItemStack pStack) {
		super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
		if (!pLevel.isClientSide()) {
			pLevel.setBlock(pPos.above(), pState.setValue(HALF, DoubleBlockHalf.UPPER), 3);
		}
	}

	public static void placeAt(LevelAccessor level, BlockState state, BlockPos pos, int flags) {
		BlockState belowState = state.setValue(HALF, DoubleBlockHalf.LOWER).setValue(STUNTED, false);
		if (!belowState.hasProperty(AGE)) {
			belowState.setValue(AGE, MAX_AGE);
		}
		if (belowState.getBlock() instanceof LimeBushBlock lime && lime.canSurvive(belowState, level, pos)) {
			level.setBlock(pos, belowState, flags);
			level.setBlock(pos.above(), belowState.setValue(HALF, DoubleBlockHalf.UPPER), flags);
		}
	}

	@Override
	public void entityInside(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Entity e) {
		if (!pLevel.isClientSide() &&
			CRConfig.LIME_POLLINATION.get() &&
			CRConfig.FAST_POLLINATE.get() &&
			e instanceof Bee &&
			pState.getValue(AGE) == this.getMaxAge() - 1 &&
			pLevel.getRandom().nextInt(150) == 0) {
			this.performBonemeal((ServerLevel) pLevel, pLevel.getRandom(), pPos, pState);
		}
	}

	@Override
	public void playerWillDestroy(Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @NotNull Player pPlayer) {
		if (!pLevel.isClientSide()) {
			if (pPlayer.isCreative()) {
				preventCreativeDropFromBottomPart(pLevel, pPos, pState, pPlayer);
			} else {
				dropResources(pState, pLevel, pPos, null, pPlayer, pPlayer.getMainHandItem());
			}
		}
		super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
	}

	@Override
	public void playerDestroy(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull BlockPos pPos, @NotNull BlockState pState, @Nullable BlockEntity pTe, @NotNull ItemStack pStack) {
		super.playerDestroy(pLevel, pPlayer, pPos, Blocks.AIR.defaultBlockState(), pTe, pStack);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 60;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 30;
	}
}
