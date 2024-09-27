package net.brdle.collectorsreap.common.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import java.util.Map;

public class EffectCandleCakeBlock extends AbstractCandleBlock {

	protected static final VoxelShape CAKE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
	protected static final VoxelShape CANDLE_SHAPE = Block.box(7.0D, 8.0D, 7.0D, 9.0D, 14.0D, 9.0D);
	protected static final VoxelShape SHAPE = Shapes.or(CAKE_SHAPE, CANDLE_SHAPE);
	private static final Iterable<Vec3> PARTICLE_OFFSETS = ImmutableList.of(new Vec3(0.5D, 1.0D, 0.5D));
	private static final Map<Pair<Block, Block>, Block> BY_CAKE_CANDLE = Maps.newHashMap();
	private final EffectCakeBlock cake;

	public EffectCandleCakeBlock(Block cake, Block candle, Properties prop) {
		super(prop);
		this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.FALSE));
		BY_CAKE_CANDLE.put(Pair.of(cake, candle), this);
		this.cake = (EffectCakeBlock) cake;
	}

	public EffectCakeBlock getCake() {
		return cake;
	}

	@Override
	protected @NotNull Iterable<Vec3> getParticleOffsets(@NotNull BlockState pState) {
		return PARTICLE_OFFSETS;
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return SHAPE;
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (!itemstack.is(Items.FLINT_AND_STEEL) && !itemstack.is(Items.FIRE_CHARGE)) {
			if (candleHit(result) && player.getItemInHand(hand).isEmpty() && state.getValue(LIT)) {
				extinguish(player, state, level, pos);
				return InteractionResult.sidedSuccess(level.isClientSide());
			}
			if (itemstack.is(ForgeTags.TOOLS_KNIVES)) {
				return cutSlice(level, pos, state, player);
			}
			return eatSlice(level, pos, state, player);
		}
		return InteractionResult.PASS;
	}

	/**
	 * Eats a slice from the pie, feeding the player.
	 */
	public InteractionResult eatSlice(Level level, BlockPos pos, BlockState state, Player player) {
		if (!player.canEat(false)) {
			return InteractionResult.PASS;
		}
		player.awardStat(Stats.EAT_CAKE_SLICE);
		Item slice = this.getCake().getSlice();
		ItemStack sliceStack = slice.getDefaultInstance();
		player.getFoodData().eat(slice, sliceStack, player);
		EffectCakeBlock.addEatEffect(sliceStack, level, player);
		level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
		level.setBlock(pos, this.getCake().defaultBlockState().setValue(EffectCakeBlock.BITES, 1), 3);
		Block.dropResources(state, level, pos);
		return InteractionResult.SUCCESS;
	}

	/**
	 * Cuts off a bite and drops a slice item, without feeding the player.
	 */
	public InteractionResult cutSlice(Level level, BlockPos pos, BlockState state, Player player) {
		level.setBlock(pos, this.getCake().defaultBlockState().setValue(EffectCakeBlock.BITES, 1), 3);
		Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), this.getCake().getSlice().getDefaultInstance());
		Block.dropResources(state, level, pos);
		level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
		return InteractionResult.SUCCESS;
	}

	private static boolean candleHit(BlockHitResult pHit) {
		return pHit.getLocation().y - pHit.getBlockPos().getY() > 0.5D;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(LIT);
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull ItemStack getCloneItemStack(@NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState) {
		return this.getCake().getSlice().getDefaultInstance();
	}

	public static boolean exists(CakeBlock cake, CandleBlock candle) {
		return BY_CAKE_CANDLE.containsKey(Pair.of(cake, candle));
	}

	public static @NotNull BlockState byCakeCandle(CakeBlock cake, CandleBlock candle) {
		return exists(cake, candle) ?
			BY_CAKE_CANDLE.get(Pair.of(cake, candle)).defaultBlockState() :
			cake.defaultBlockState();
	}

	/**
	 * Update the provided state given the provided neighbor direction and neighbor state, returning a new state.
	 * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
	 * returns its solidified counterpart.
	 * Note that this method should ideally consider only the specific direction passed in.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public @NotNull BlockState updateShape(@NotNull BlockState pState, @NotNull Direction pDirection, @NotNull BlockState pNeighborState, @NotNull LevelAccessor pLevel, @NotNull BlockPos pCurrentPos, @NotNull BlockPos pNeighborPos) {
		return pDirection == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean canSurvive(@NotNull BlockState state, LevelReader level, BlockPos pos) {
		return level.getBlockState(pos.below()).isSolidRender(level, pos);
	}

	/**
	 * @deprecated call via {@link
	 * net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase#getAnalogOutputSignal} whenever possible.
	 * Implementing/overriding is fine.
	 */
	@SuppressWarnings("deprecation")
	@Deprecated
	@Override
	public int getAnalogOutputSignal(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos) {
		return CakeBlock.FULL_CAKE_SIGNAL;
	}

	/**
	 * @deprecated call via {@link
	 * net.minecraft.world.level.block.state.BlockBehaviour.BlockStateBase#hasAnalogOutputSignal} whenever possible.
	 * Implementing/overriding is fine.
	 */
	@SuppressWarnings("deprecation")
	@Deprecated
	@Override
	public boolean hasAnalogOutputSignal(@NotNull BlockState pState) {
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isPathfindable(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull PathComputationType pType) {
		return false;
	}

	@Override
	protected boolean canBeLit(final @NotNull BlockState state) {
		return state.is(BlockTags.CANDLE_CAKES, (s) -> s.hasProperty(LIT) && !state.getValue(LIT)) && super.canBeLit(state);
	}
}
