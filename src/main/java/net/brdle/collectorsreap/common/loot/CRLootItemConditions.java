package net.brdle.collectorsreap.common.loot;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CRLootItemConditions {

	private static final DeferredRegister<LootItemConditionType> LICT = DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, CollectorsReap.MODID);

	public static final RegistryObject<LootItemConditionType> IS_TAG = LICT.register("is_tag",
		() -> new LootItemConditionType(new LootItemBlockIsTagCondition.Serializer()));
	public static final RegistryObject<LootItemConditionType> ENABLED = LICT.register("enabled",
		() -> new LootItemConditionType(new LootItemEnabledCondition.Serializer()));

	public static void create(IEventBus bus) {
		LICT.register(bus);
	}
}