package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.WaterAnimal;
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

	public static final RegistryObject<EntityType<TigerPrawn>> TIGER_PRAWN = reg("tiger_prawn",
		TigerPrawn::new, MobCategory.WATER_AMBIENT, 0.8F, 0.4F);
	public static final RegistryObject<EntityType<Urchin>> URCHIN = reg("urchin",
		Urchin::new, MobCategory.WATER_AMBIENT, 0.5F, 0.5F);
	public static final RegistryObject<EntityType<PlatinumBass>> PLATINUM_BASS = reg("platinum_bass",
		PlatinumBass::new, MobCategory.WATER_AMBIENT, 1.2F, 0.5F);
	public static final RegistryObject<EntityType<Clam>> CLAM = reg("clam",
		Clam::new, MobCategory.WATER_AMBIENT, 1.0F, 0.5F);
	public static final RegistryObject<EntityType<ChieftainCrab>> CHIEFTAIN_CRAB = reg("chieftain_crab",
		ChieftainCrab::new, MobCategory.CREATURE, 0.85F, 0.65F);

	private static <T extends Entity> RegistryObject<EntityType<T>> reg(String name, EntityType.EntityFactory<T> fact, MobCategory category, float width, float height) {
		return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(fact, category).sized(width, height).build(CollectorsReap.MODID + "." + name));
	}

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
		event.register(CHIEFTAIN_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ChieftainCrab::checkCrabSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
	}

	public static void create(IEventBus bus) {
		ENTITY_TYPES.register(bus);
	}
}
