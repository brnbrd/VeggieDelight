package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.NotNull;

public class SmallPomegranateBushBlock extends BushBlock implements BonemealableBlock {
	public static final int MAX_AGE = 1;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_1;
	private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 5.0D, 13.0D);
	private static final VoxelShape MID_GROWTH_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D);

	public SmallPomegranateBushBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
		return Util.gs(CRItems.POMEGRANATE_SEEDS);
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return pState.getValue(AGE) == MAX_AGE ? MID_GROWTH_SHAPE : SAPLING_SHAPE;
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getCollisionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return getShape(pState, pLevel, pPos, pContext);
	}

	/**
	 * @return whether this block needs random ticking.
	 */
	@Override
	public boolean isRandomlyTicking(@NotNull BlockState pState) {
		return true;
	}

	// Can grow in overworld and nether (with boost). Receives boost from block below.
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(@NotNull BlockState pState, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
		int growthRate = 13;
		if (pLevel.getBlockState(pPos.below()).is(CRBlockTags.POMEGRANATE_FAST_ON)) {
			growthRate -= 3;
		}
		if (pLevel.dimension() == Level.NETHER) {
			growthRate -= 4;
		}
		if (ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt(growthRate) == 0)){
			this.performBonemeal(pLevel, pRandom, pPos, pState);
			ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
		}
	}

	@Override
	protected boolean mayPlaceOn(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
		return pState.is(BlockTags.DIRT) || pState.is(CRBlockTags.POMEGRANATE_FAST_ON);
	}

	@Override
	public boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, BlockPos pos) {
		BlockPos below = pos.below();
		return this.mayPlaceOn(level.getBlockState(below), level, below);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(AGE);
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, boolean pIsClient) {
		return false;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, @NotNull BlockState pState) {
		return false;
	}

	@Override
	public void performBonemeal(@NotNull ServerLevel world, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, BlockState pState) {
		int i = pState.getValue(AGE);
		if (i < MAX_AGE) {
			BlockState newState = pState.setValue(AGE, Math.min(MAX_AGE, pState.getValue(AGE) + 1));
			world.setBlock(pPos, newState, 2);
		} else if (i == MAX_AGE && world.isEmptyBlock(pPos.above())) {
			world.setBlock(pPos, CRBlocks.POMEGRANATE_BUSH.get().defaultBlockState().setValue(PomegranateBushBlock.HALF, DoubleBlockHalf.LOWER), 2);
			world.setBlock(pPos.above(), CRBlocks.POMEGRANATE_BUSH.get().defaultBlockState().setValue(PomegranateBushBlock.HALF, DoubleBlockHalf.UPPER), 2);
		}
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 0;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 0;
	}
}
