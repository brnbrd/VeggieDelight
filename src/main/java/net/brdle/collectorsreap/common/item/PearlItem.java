package net.brdle.collectorsreap.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PearlItem extends Item {
	public PearlItem(Properties properties) {
		super(properties);
	}

	@Override
	public boolean isFoil(@NotNull ItemStack stack) {
		return true;
	}
}