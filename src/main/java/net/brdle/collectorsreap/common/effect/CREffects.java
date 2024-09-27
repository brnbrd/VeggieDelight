package net.brdle.collectorsreap.common.effect;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CREffects {
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CollectorsReap.MODID);

	public static final RegistryObject<MobEffect> CORROSION = EFFECTS.register("corrosion", CorrosionEffect::new);
	public static final RegistryObject<MobEffect> VOLATILITY = EFFECTS.register("volatility", VolatilityEffect::new);

	public static void create(IEventBus bus) {
		EFFECTS.register(bus);
	}
}