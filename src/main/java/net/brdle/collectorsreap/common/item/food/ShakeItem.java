package net.brdle.collectorsreap.common.item.food;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ShakeItem extends CompatDrinkable {

	public ShakeItem(Properties properties) {
		super(properties, false, false, "neapolitan");
	}

	@Override
	public int getUseDuration(@NotNull ItemStack stack) {
		return 40;
	}

	@Override
	public @NotNull SoundEvent getDrinkingSound() {
		return SoundEvents.HONEY_DRINK;
	}

	@Override
	public @NotNull SoundEvent getEatingSound() {
		return SoundEvents.HONEY_DRINK;
	}
}