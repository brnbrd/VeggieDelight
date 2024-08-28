package net.brdle.collectorsreap.proxy;

import net.brdle.collectorsreap.common.CRParticleTypes;
import net.brdle.collectorsreap.common.CRSoundEvents;
import net.brdle.collectorsreap.common.ForgeEvents;
import net.brdle.collectorsreap.common.ModEvents;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.brdle.collectorsreap.common.fluid.CRFluids;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.common.loot.CRLootItemConditions;
import net.brdle.collectorsreap.common.loot.CRLootModifiers;
import net.brdle.collectorsreap.common.world.CRFeatures;
import net.brdle.collectorsreap.data.gen.Generators;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CommonProxy {

	public void start() {
		final var modBus = FMLJavaModLoadingContext.get().getModEventBus();
		final var forgeBus = MinecraftForge.EVENT_BUS;
		forgeBus.register(new ForgeEvents());
		modBus.register(new ModEvents());
		modBus.register(new Generators());
		CRBlocks.create(modBus);
		CRFluids.create(modBus);
		CRItems.create(modBus);
		CREntities.create(modBus);
		CRParticleTypes.create(modBus);
		CREffects.create(modBus);
		CRFeatures.create(modBus);
		CRLootItemConditions.create(modBus);
		CRLootModifiers.create(modBus);
		CRSoundEvents.create(modBus);
	}
}