package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CREntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CollectorsReap.MODID);

	public static final RegistryObject<EntityType<TigerPrawn>> TIGER_PRAWN = reg("tiger_prawn",
		EntityType.Builder.of(TigerPrawn::new, MobCategory.WATER_AMBIENT).sized(0.8F, 0.4F));
	public static final RegistryObject<EntityType<Urchin>> URCHIN = reg("urchin",
		EntityType.Builder.of(Urchin::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F));
	public static final RegistryObject<EntityType<PlatinumBass>> PLATINUM_BASS = reg("platinum_bass",
		EntityType.Builder.of(PlatinumBass::new, MobCategory.WATER_AMBIENT).sized(1.2F, 0.5F));
	public static final RegistryObject<EntityType<ChieftainCrab>> CHIEFTAIN_CRAB = reg("chieftain_crab",
		EntityType.Builder.of(ChieftainCrab::new, MobCategory.WATER_AMBIENT).sized(0.85F, 0.65F));
	public static final RegistryObject<EntityType<Clam>> CLAM = reg("clam",
		EntityType.Builder.of(Clam::new, MobCategory.WATER_AMBIENT).sized(1.0F, 0.5F));

	private static <T extends Entity> RegistryObject<EntityType<T>> reg(String name, EntityType.Builder<T> builder) {
		return ENTITY_TYPES.register(name, () -> builder.build(CollectorsReap.MODID + "." + name));
	}

	public static void create(IEventBus bus) {
		ENTITY_TYPES.register(bus);
	}
}
