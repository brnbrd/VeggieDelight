package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.compat.ModCompat;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GummyItem extends CompatConsumable {
	private static final int MAX_NEARBY = 3;

	public GummyItem(Properties prop) {
		super(prop, true, false);
	}

	public GummyItem(Properties prop, String modid) {
		super(prop, true, false, modid);
	}

	public GummyItem(Properties prop, float heal) {
		super(prop, true, true, heal);
	}

	public GummyItem(Properties prop, float heal, String modid) {
		super(prop, true, true, heal, modid);
	}

	@Override
	public int getUseDuration(@NotNull ItemStack stack) {
		return 14;
	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		super.affectConsumer(stack, level, consumer);
		if (loaded()) {
			if (stack.is(CRItems.ALOE_GUMMY.get())) {
				consumer.clearFire();
			} else if (stack.is(CRItems.ADZUKI_GUMMY.get())) {
				MobEffect vanilla = ModCompat.getVanillaScent().get();
				level.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT.selector(near ->
					near != consumer &&
					(
						near.getEffect(vanilla) == null ||
						!near.hasEffect(ModCompat.getVanillaScent().get())
					)
				), consumer, consumer.getBoundingBox().inflate(6.0D, 2.0D, 6.0D))
				.stream().limit(MAX_NEARBY)
				.forEach(n -> n.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 3)));
			}
		}
	}
}