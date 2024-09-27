package net.brdle.collectorsreap.common;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CRParticleTypes {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, CollectorsReap.MODID);

	public static final RegistryObject<SimpleParticleType> ACID = PARTICLE_TYPES.register("acid", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SHOCKWAVE = PARTICLE_TYPES.register("shockwave", () -> new SimpleParticleType(true));

	public static void create(IEventBus bus) {
		PARTICLE_TYPES.register(bus);
	}
}