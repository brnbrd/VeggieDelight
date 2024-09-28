package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;
import java.util.function.Supplier;

public class PortobelloColonyBlock extends MushroomColonyBlock {
	public PortobelloColonyBlock(Properties properties, Supplier<Item> mushroomType) {
		super(properties, mushroomType);
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
	public boolean isValidBonemealTarget(@NotNull LevelReader pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, boolean pIsClient) {
		return false;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
		return false;
	}
}