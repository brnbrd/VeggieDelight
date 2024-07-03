package net.brdle.collectorsreap.compat;

import com.teamabnormals.atmospheric.core.registry.AtmosphericMobEffects;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class AtmosphericCompat {
	public static Supplier<MobEffect> SPITTING = AtmosphericMobEffects.SPITTING;
	public static Supplier<MobEffect> PERSISTENCE = AtmosphericMobEffects.PERSISTENCE;
	public static Supplier<MobEffect> RELIEF = AtmosphericMobEffects.RELIEF;
}
