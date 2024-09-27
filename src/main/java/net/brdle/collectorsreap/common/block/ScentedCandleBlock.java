package net.brdle.collectorsreap.common.block;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AbstractCandleBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import java.util.function.ToIntFunction;

@SuppressWarnings("deprecation")
public class ScentedCandleBlock extends AbstractCandleBlock implements SimpleWaterloggedBlock {
	public static final BooleanProperty LIT = AbstractCandleBlock.LIT;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final ToIntFunction<BlockState> LIGHT_EMISSION = (c) -> c.getValue(LIT) ? 3 : 0;
	private static final VoxelShape SHAPE = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 6.0D, 9.0D);

	public ScentedCandleBlock(BlockBehaviour.Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(LIT, false).setValue(WATERLOGGED, false));
	}

	@Override
	public @NotNull InteractionResult use(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
		if (pPlayer.getAbilities().mayBuild && pPlayer.getItemInHand(pHand).isEmpty() && pState.getValue(LIT)) {
			extinguish(pPlayer, pState, pLevel, pPos);
			return InteractionResult.sidedSuccess(pLevel.isClientSide);
		} else {
			return InteractionResult.PASS;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		BlockState blockstate = pContext.getLevel().getBlockState(pContext.getClickedPos());
		if (blockstate.is(this)) {
			return blockstate;
		} else {
			FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
			return super.getStateForPlacement(pContext).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
		}
	}

	/**
	 * Update the provided state given the provided neighbor direction and neighbor state, returning a new state.
	 * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
	 * returns its solidified counterpart.
	 * Note that this method should ideally consider only the specific direction passed in.
	 */
	@Override
	public @NotNull BlockState updateShape(BlockState pState, @NotNull Direction pDirection, @NotNull BlockState pNeighborState, @NotNull LevelAccessor pLevel, @NotNull BlockPos pCurrentPos, @NotNull BlockPos pNeighborPos) {
		if (pState.getValue(WATERLOGGED)) {
			pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
		}

		return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}

	@Override
	public @NotNull FluidState getFluidState(BlockState pState) {
		return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
	}

	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return SHAPE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(LIT, WATERLOGGED);
	}

	@Override
	public boolean placeLiquid(@NotNull LevelAccessor pLevel, @NotNull BlockPos pPos, BlockState pState, @NotNull FluidState pFluidState) {
		if (!pState.getValue(WATERLOGGED) && pFluidState.getType() == Fluids.WATER) {
			BlockState blockstate = pState.setValue(WATERLOGGED, true);
			if (pState.getValue(LIT)) {
				extinguish(null, blockstate, pLevel, pPos);
			} else {
				pLevel.setBlock(pPos, blockstate, 3);
			}
			pLevel.scheduleTick(pPos, pFluidState.getType(), pFluidState.getType().getTickDelay(pLevel));
			return true;
		} else {
			return false;
		}
	}

	public static boolean canLight(BlockState pState) {
		return pState.is(BlockTags.CANDLES, (c) -> {
			return c.hasProperty(LIT) && c.hasProperty(WATERLOGGED);
		}) && !pState.getValue(LIT) && !pState.getValue(WATERLOGGED);
	}

	@Override
	protected @NotNull Iterable<Vec3> getParticleOffsets(@NotNull BlockState pState) {
		return ImmutableList.of(new Vec3(0.5D, 0.5D, 0.5D));
	}

	@Override
	protected boolean canBeLit(BlockState pState) {
		return !pState.getValue(WATERLOGGED) && super.canBeLit(pState);
	}

	@Override
	public boolean canSurvive(@NotNull BlockState pState, @NotNull LevelReader pLevel, BlockPos pPos) {
		return Block.canSupportCenter(pLevel, pPos.below(), Direction.UP);
	}
}