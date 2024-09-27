package net.brdle.collectorsreap.proxy;

import net.brdle.collectorsreap.client.model.*;
import net.brdle.collectorsreap.client.particle.AcidParticle;
import net.brdle.collectorsreap.client.particle.ShockwaveParticle;
import net.brdle.collectorsreap.client.renderer.*;
import net.brdle.collectorsreap.common.CRParticleTypes;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientProxy extends CommonProxy {

	@Override
	public void start() {
		super.start();
		final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		//final IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		modBus.register(this);
	}

    /*@SubscribeEvent
    public void setupClient(FMLClientSetupEvent e){
    }*/

	@SubscribeEvent
	public void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions e) {
		e.registerLayerDefinition(TigerPrawnRenderer.LAYER_LOCATION, TigerPrawnModel::createBodyLayer);
		e.registerLayerDefinition(UrchinRenderer.LAYER_LOCATION, UrchinModel::createBodyLayer);
		e.registerLayerDefinition(PlatinumBassRenderer.LAYER_LOCATION, PlatinumBassModel::createBodyLayer);
		e.registerLayerDefinition(ChieftainCrabRenderer.LAYER_LOCATION, ChieftainCrabModel::createBodyLayer);
		e.registerLayerDefinition(ClamRenderer.LAYER_LOCATION, ClamModel::createBodyLayer);
	}


	@SubscribeEvent
	public void registerEntityRenders(EntityRenderersEvent.RegisterRenderers e) {
		e.registerEntityRenderer(CREntities.TIGER_PRAWN.get(), TigerPrawnRenderer::new);
		e.registerEntityRenderer(CREntities.URCHIN.get(), UrchinRenderer::new);
		e.registerEntityRenderer(CREntities.PLATINUM_BASS.get(), PlatinumBassRenderer::new);
		e.registerEntityRenderer(CREntities.CHIEFTAIN_CRAB.get(), ChieftainCrabRenderer::new);
		e.registerEntityRenderer(CREntities.CLAM.get(), ClamRenderer::new);
		e.registerEntityRenderer(CREntities.URCHIN_DART.get(), UrchinDartRenderer::new);
		e.registerEntityRenderer(CREntities.SHIMMERING_PEARL.get(), ThrownItemRenderer::new);
	}

	@SubscribeEvent
	public void registerParticles(RegisterParticleProvidersEvent e) {
		e.registerSpriteSet(CRParticleTypes.ACID.get(), AcidParticle.Provider::new);
		e.registerSpriteSet(CRParticleTypes.SHOCKWAVE.get(), ShockwaveParticle.Provider::new);
	}
}