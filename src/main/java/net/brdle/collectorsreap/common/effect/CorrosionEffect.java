package net.brdle.collectorsreap.common.effect;

import net.brdle.collectorsreap.common.CRParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class CorrosionEffect extends MobEffect {

	/**
	 * The player will emit acid particles that destroy incoming projectiles
	 * Used weapon will take extra durability damage
	 */
	protected CorrosionEffect() {
		super(MobEffectCategory.BENEFICIAL, 0x4EFF35);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amp) {
		entity.level().addParticle(CRParticleTypes.ACID.get(), entity.getRandomX(0.75D), entity.getRandomY() + 0.4D, entity.getRandomZ(0.75D), 0.0D, -0.02D, 0.0D);
	}

	/**
	 * Checks whether the effect is ready to be applied this tick.
	 */
	@Override
	public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
		return false;
	}
}