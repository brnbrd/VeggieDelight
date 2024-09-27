package net.brdle.collectorsreap.compat;

import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.world.effect.MobEffect;
import java.util.function.Supplier;

public class NeapolitanCompat {
	public static Supplier<MobEffect> AGILITY = NeapolitanMobEffects.AGILITY;
	public static Supplier<MobEffect> VANILLA_SCENT = NeapolitanMobEffects.VANILLA_SCENT;
	public static Supplier<MobEffect> HARMONY = NeapolitanMobEffects.HARMONY;
	public static Supplier<MobEffect> BERSERKING = NeapolitanMobEffects.BERSERKING;
	public static Supplier<MobEffect> SUGAR_RUSH = NeapolitanMobEffects.SUGAR_RUSH;
}