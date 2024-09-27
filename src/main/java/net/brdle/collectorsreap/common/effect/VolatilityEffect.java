package net.brdle.collectorsreap.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class VolatilityEffect extends MobEffect {

	/**
	 * The player will emit acid particles that destroy incoming projectiles
	 * Used weapon will take extra durability damage
	 */
	protected VolatilityEffect() {
		super(MobEffectCategory.BENEFICIAL, 0xFF0040);
	}

	/**
	 * Checks whether the effect is ready to be applied this tick.
	 */
	@Override
	public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
		return false;
	}
}