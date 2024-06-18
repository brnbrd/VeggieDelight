package net.brdle.collectorsreap.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public interface IFruiting {

	default int getNumFruit(Level level) {
		return 2 + level.getRandom().nextInt(2);
	}

	Item getFruit();

	default void dropFruit(Level level, BlockPos pos) {
		Block.popResource(level, pos, new ItemStack(getFruit(), getNumFruit(level)));
	}

	default void preventCreativeDropFromBottomPart(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
		DoubleBlockHalf doubleblockhalf = pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF);
		if (doubleblockhalf == DoubleBlockHalf.UPPER) {
			BlockPos blockpos = pPos.below();
			BlockState blockstate = pLevel.getBlockState(blockpos);
			if (blockstate.is(pState.getBlock()) && blockstate.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
				pLevel.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
				pLevel.levelEvent(pPlayer, 2001, blockpos, Block.getId(blockstate));
			}
		}
	}
}
