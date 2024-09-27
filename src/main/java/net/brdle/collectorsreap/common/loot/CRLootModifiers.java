package net.brdle.collectorsreap.common.loot;

import com.mojang.serialization.Codec;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CRLootModifiers {

	private static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, CollectorsReap.MODID);

	public static final RegistryObject<Codec<AddItemLootModifier>> ADD_ITEM = GLM.register("add_item", AddItemLootModifier.CODEC);
	public static final RegistryObject<Codec<CRFishingLoot>> FISHING = GLM.register("fishing", CRFishingLoot.CODEC);

	public static void create(IEventBus bus) {
		GLM.register(bus);
	}

	public static LootTableReference getLootTableReference(String resLoc) {
		return (LootTableReference) LootTableReference.lootTableReference(Util.rl(resLoc)).build();
	}

	public static String getString(LootTableReference lootTable) {
		return lootTable.name.toString();
	}
}