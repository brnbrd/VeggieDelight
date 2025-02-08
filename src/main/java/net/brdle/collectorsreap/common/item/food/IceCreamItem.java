package net.brdle.collectorsreap.common.item.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class IceCreamItem extends CompatConsumable {

	public IceCreamItem(Properties properties) {
		super(properties.craftRemainder(Items.BOWL).stacksTo(1), false, false, "neapolitan");
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		super.affectConsumer(stack, level, consumer);
		consumer.setTicksFrozen(consumer.getTicksFrozen() + 200);
	}
}