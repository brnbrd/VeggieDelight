package net.brdle.collectorsreap.common.item;

import net.brdle.collectorsreap.common.block.FruitBushBlock;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

public class FruitSeedsItem extends ItemNameBlockItem {
	public FruitSeedsItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Nullable
	@Override
	protected BlockState getPlacementState(@NotNull BlockPlaceContext context) {
		BlockState state = super.getPlacementState(context);
		if (state == null) return null;
		return state.setValue(FruitBushBlock.AGE, 0);
	}
}