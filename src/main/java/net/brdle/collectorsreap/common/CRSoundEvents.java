package net.brdle.collectorsreap.common;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CRSoundEvents {
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CollectorsReap.MODID);

	public static final RegistryObject<SoundEvent> SHIMMERING_PEARL_THROW = SOUNDS.register("shimmering_pearl_throw",
			() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.shimmering_pearl.throw")));

	public static void create(IEventBus bus) {
		SOUNDS.register(bus);
	}
}
