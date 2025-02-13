package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = CollectorsReap.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CREntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CollectorsReap.MODID);

	public static final RegistryObject<EntityType<TigerPrawn>> TIGER_PRAWN = ENTITY_TYPES.register("tiger_prawn",
		() -> EntityType.Builder.of(TigerPrawn::new, MobCategory.WATER_AMBIENT)
			.sized(0.8F, 0.4F)
			.clientTrackingRange(4)
			.build(CollectorsReap.MODID + ".tiger_prawn"));
	public static final RegistryObject<EntityType<Urchin>> URCHIN = ENTITY_TYPES.register("urchin",
		() -> EntityType.Builder.of(Urchin::new, MobCategory.WATER_AMBIENT)
			.sized(0.5F, 0.5F)
			.clientTrackingRange(4)
			.build(CollectorsReap.MODID + ".urchin"));
	public static final RegistryObject<EntityType<PlatinumBass>> PLATINUM_BASS = ENTITY_TYPES.register("platinum_bass",
		() -> EntityType.Builder.of(PlatinumBass::new, MobCategory.WATER_AMBIENT)
			.sized(1.2F, 0.5F)
			.clientTrackingRange(4)
			.build(CollectorsReap.MODID + ".platinum_bass"));
	public static final RegistryObject<EntityType<Clam>> CLAM = ENTITY_TYPES.register("clam",
		() -> EntityType.Builder.of(Clam::new, MobCategory.WATER_AMBIENT)
			.sized(1F, 0.5F)
			.clientTrackingRange(8)
			.build(CollectorsReap.MODID + ".clam"));
	public static final RegistryObject<EntityType<ChieftainCrab>> CHIEFTAIN_CRAB = ENTITY_TYPES.register("chieftain_crab",
	 	() -> EntityType.Builder.of(ChieftainCrab::new, MobCategory.CREATURE)
			.sized(0.85F, 0.65F)
			.clientTrackingRange(10)
			.build(CollectorsReap.MODID + ".chieftain_crab"));
	public static final RegistryObject<EntityType<UrchinDart>> URCHIN_DART = ENTITY_TYPES.register("urchin_dart",
		() -> EntityType.Builder.<UrchinDart>of(UrchinDart::new, MobCategory.MISC)
			.sized(0.5F, 0.5F)
			.clientTrackingRange(4)
			.updateInterval(20)
			.build(CollectorsReap.MODID + ".urchin_dart"));
	public static final RegistryObject<EntityType<ThrownShimmeringPearl>> SHIMMERING_PEARL = ENTITY_TYPES.register("shimmering_pearl",
		() -> EntityType.Builder.<ThrownShimmeringPearl>of(ThrownShimmeringPearl::new, MobCategory.MISC)
			.sized(0.25F, 0.25F)
			.clientTrackingRange(4)
			.updateInterval(10)
			.build(CollectorsReap.MODID + ".shimmering_pearl"));

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TIGER_PRAWN.get(), TigerPrawn.createAttributes().build());
		event.put(URCHIN.get(), Urchin.createAttributes().build());
		event.put(PLATINUM_BASS.get(), PlatinumBass.createAttributes().build());
		event.put(CLAM.get(), Clam.createAttributes().build());
		event.put(CHIEFTAIN_CRAB.get(), ChieftainCrab.createAttributes().build());
	}

	@SubscribeEvent
	public static void registerEntitySpawnPlacements(SpawnPlacementRegisterEvent event) {
		event.register(PLATINUM_BASS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PlatinumBass::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(TIGER_PRAWN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TigerPrawn::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(URCHIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Urchin::checkWaterGroundSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(CLAM.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Clam::checkWaterGroundSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(CHIEFTAIN_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, ChieftainCrab::checkCrabSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
	}

	public static void create(IEventBus bus) {
		ENTITY_TYPES.register(bus);
	}
}