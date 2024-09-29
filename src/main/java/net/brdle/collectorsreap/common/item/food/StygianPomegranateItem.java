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
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
		if (this.loaded() && !level.isClientSide()) {
			level.explode(entity, entity.getX(), entity.getY(), entity.getZ(), 3.0F, Level.ExplosionInteraction.NONE);
		}
		return super.finishUsingItem(stack, level, entity);
	}
}