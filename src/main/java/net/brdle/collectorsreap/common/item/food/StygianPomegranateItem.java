package net.brdle.collectorsreap.common.item.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class StygianPomegranateItem extends CompatConsumable {
	public StygianPomegranateItem(Properties properties) {
		super(properties, false, true, 1.0F, "mynethersdelight");
	}

	@Override
	public @NotNull Rarity getRarity(@NotNull ItemStack stack) {
		return Rarity.RARE;
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		super.affectConsumer(stack, level, consumer);
		if (this.loaded()) {
			level.explode(
				consumer,
				consumer.getX(),
				consumer.getY(),
				consumer.getZ(),
				3.0F,
				Level.ExplosionInteraction.NONE
			);
		}
	}
}