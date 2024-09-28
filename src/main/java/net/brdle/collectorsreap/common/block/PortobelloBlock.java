package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.tag.ModTags;

public class PortobelloBlock extends MushroomBlock {
	private static final float AABB_OFFSET = 2.0F;
	private static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 7.0D, 12.0D);

	public PortobelloBlock(Properties pProperties) {
		super(pProperties, TreeFeatures.HUGE_BROWN_MUSHROOM);
	}

	// Grow into colony on Rich Soil
	@Override
	public void randomTick(@NotNull BlockState state, ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource rand) {
		if (
			!level.isClientSide() &&
				level.getBlockState(pos.below()).is(ModTags.MUSHROOM_COLONY_GROWABLE_ON)
		) {
			level.setBlockAndUpdate(pos, CRBlocks.PORTOBELLO_COLONY.get().defaultBlockState());
		} else {
			super.randomTick(state, level, pos, rand);
		}
	}

	@Override
	public boolean canSurvive(@NotNull BlockState pState, LevelReader level, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState blockstate = level.getBlockState(blockpos);
		return (
			(blockstate.is(CRBlockTags.PORTOBELLO_SPAWNABLE_ON)) ||
				(blockstate.canSustainPlant(level, blockpos, Direction.UP, this))
		);
	}

	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return SHAPE;
	}

	@Override
	public float getMaxHorizontalOffset() {
		return AABB_OFFSET;
	}

	@Override
	public boolean growMushroom(@NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @NotNull RandomSource pRandom) {
		return false;
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
	public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
		level.setBlock(pos, CRBlocks.PORTOBELLO_COLONY.get().defaultBlockState(), 2);
	}
}