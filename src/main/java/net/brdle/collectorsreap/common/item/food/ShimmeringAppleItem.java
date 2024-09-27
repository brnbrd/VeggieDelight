package net.brdle.collectorsreap.common.item.food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.brdle.collectorsreap.common.item.PearlItem;
import org.jetbrains.annotations.NotNull;

public class ShimmeringAppleItem extends PearlItem {
	public ShimmeringAppleItem(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull Rarity getRarity(@NotNull ItemStack stack) {
		return Rarity.UNCOMMON;
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
		if (!level.isClientSide()) {
			Map<MobEffect, MobEffectInstance> active = new HashMap<>(entity.getActiveEffectsMap());
			if (active.isEmpty()) {
				entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1));
			} else {
				List<MobEffect> buffs = new ArrayList<>();
				List<MobEffect> debuffs = new ArrayList<>();
				ForgeRegistries.MOB_EFFECTS.getValues().forEach(mobEffect -> {
					if (!mobEffect.isInstantenous()) {
						if (mobEffect.getCategory() == MobEffectCategory.BENEFICIAL) {
							buffs.add(mobEffect);
						} else if (mobEffect.getCategory() == MobEffectCategory.HARMFUL) {
							debuffs.add(mobEffect);
						}
					}
				});
				RandomSource rand = level.getRandom();
				active.forEach((mobEffect, instance) -> {
					if (
						!instance.isAmbient() &&
						!instance.isInfiniteDuration() &&
						instance.getDuration() > 200 &&
						instance.isVisible() &&
						instance.showIcon() &&
						!mobEffect.isInstantenous()
					) {
						List<MobEffect> effectList;
						if (mobEffect.getCategory() == MobEffectCategory.BENEFICIAL) {
							effectList = buffs;
						} else if (mobEffect.getCategory() == MobEffectCategory.HARMFUL) {
							effectList = debuffs;
						} else {
							return;
						}
						if (effectList.contains(mobEffect) && effectList.size() > 1) {
							entity.removeEffect(mobEffect);
							effectList.remove(mobEffect);
							entity.forceAddEffect(new MobEffectInstance(
								effectList.remove(rand.nextInt(effectList.size())),
								Math.min(instance.getDuration(), rand.nextIntBetweenInclusive(800, 2400)),
								Math.min(instance.getAmplifier(), 2)
							), entity);
						}
					}
				});
			}
		}
		return super.finishUsingItem(stack, level, entity);
	}
}