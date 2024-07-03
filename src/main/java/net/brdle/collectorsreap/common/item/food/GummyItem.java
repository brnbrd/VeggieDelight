package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.compat.ModCompat;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.FarmersDelight;

public class GummyItem extends Item {
	String modid;
	private static final int MAX_NEARBY = 3;

	public GummyItem(Properties prop, @Nullable String modid) {
		super(prop);
		if (modid == null) {
			this.modid = FarmersDelight.MODID;
		} else {
			this.modid = modid;
		}
	}

	public String getModid() {
		return this.modid;
	}

	@Override
	public int getUseDuration(@NotNull ItemStack stack) {
		return 14;
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level worldIn, @NotNull LivingEntity entity) {
		if (stack.is(CRItems.ADZUKI_GUMMY.get())) {
			worldIn.getNearbyEntities(LivingEntity.class, TargetingConditions.DEFAULT.selector((living) -> {
						return (living != entity && living.getEffect(ModCompat.getVanillaScent().get()) == null);
					}), entity, entity.getBoundingBox().inflate(6.0D, 2.0D, 6.0D))
					.stream().limit(MAX_NEARBY)
					.forEach(n -> n.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 3)));
		} else if (stack.is(CRItems.STRAWBERRY_GUMMY.get())) {
			entity.heal(3.0F);
		} else if (stack.is(CRItems.ALOE_GUMMY.get())) {
			entity.clearFire();
		}
		return super.finishUsingItem(stack, worldIn, entity);
	}
}
