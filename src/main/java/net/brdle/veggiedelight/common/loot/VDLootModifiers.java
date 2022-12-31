package net.brdle.veggiedelight.common.loot;

import com.mojang.serialization.Codec;
import net.brdle.veggiedelight.VeggieDelight;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VDLootModifiers {

	private static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, VeggieDelight.MODID);

	public static final RegistryObject<Codec<AddItemLootModifier>> ADD_ITEM = GLM.register("add_item", () -> AddItemLootModifier.CODEC);

	public static void create(IEventBus bus) {
		GLM.register(bus);
	}

}
