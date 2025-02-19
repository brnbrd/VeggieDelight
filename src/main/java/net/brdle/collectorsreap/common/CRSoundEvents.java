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

	public static final RegistryObject<SoundEvent> URCHIN_DART_THROW = SOUNDS.register("urchin_dart_throw",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.urchin_dart.throw")));
	public static final RegistryObject<SoundEvent> URCHIN_DART_HIT = SOUNDS.register("urchin_dart_hit",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.urchin_dart.hit")));
	public static final RegistryObject<SoundEvent> SHIMMERING_PEARL_THROW = SOUNDS.register("shimmering_pearl_throw",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.shimmering_pearl.throw")));
	public static final RegistryObject<SoundEvent> SHIMMERING_PEARL_BREAK = SOUNDS.register("shimmering_pearl_break",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.shimmering_pearl.break")));
	public static final RegistryObject<SoundEvent> PLATINUM_BASS_DEATH = SOUNDS.register("platinum_bass_death",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.platinum_bass.death")));
	public static final RegistryObject<SoundEvent> PLATINUM_BASS_HURT = SOUNDS.register("platinum_bass_hurt",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.platinum_bass.hurt")));
	public static final RegistryObject<SoundEvent> PLATINUM_BASS_FLOP = SOUNDS.register("platinum_bass_flop",
		() -> SoundEvent.createVariableRangeEvent(Util.cr("entity.platinum_bass.flop")));

	public static void create(IEventBus bus) {
		SOUNDS.register(bus);
	}
}