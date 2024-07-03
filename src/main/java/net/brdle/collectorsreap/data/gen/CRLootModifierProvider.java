package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.common.loot.AddItemLootModifier;
import net.brdle.collectorsreap.common.loot.CRFishingLoot;
import net.brdle.collectorsreap.common.loot.CRLootModifiers;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class CRLootModifierProvider extends GlobalLootModifierProvider {
	public CRLootModifierProvider(PackOutput output) {
		super(output, CollectorsReap.MODID);
	}

	@Override
	protected void start() {
		add("cr_fishing", new CRFishingLoot(
				new LootItemCondition[]{
						LootTableIdCondition.builder(Util.rl("minecraft", "gameplay/fishing")).build()
				},
				CRLootModifiers.getLootTableReference("collectorsreap:gameplay/fishing/fishing"),
				0.2F
		));
		add("lime_in_abandoned_mineshaft", new AddItemLootModifier(
				new LootItemCondition[]{
						LootTableIdCondition.builder(Util.rl("chests/abandoned_mineshaft")).build()
				},
				CRItems.LIME.get(), 1, 2, 0.3F
		));
		add("lime_seeds_in_dungeon", new AddItemLootModifier(
				new LootItemCondition[]{
						LootTableIdCondition.builder(Util.rl("chests/simple_dungeon")).build()
				},
				CRItems.LIME_SEEDS.get(), 2, 4, 0.4F
		));
		add("pomegranate_slice_in_bastion_hoglin_stable", new AddItemLootModifier(
				new LootItemCondition[]{
						LootTableIdCondition.builder(Util.rl("chests/bastion_hoglin_stable")).build()
				},
				CRItems.POMEGRANATE_SLICE.get(), 4, 12, 0.45F
		));
		add("pomegranate_seeds_in_bastion_other", new AddItemLootModifier(
				new LootItemCondition[]{
						LootTableIdCondition.builder(Util.rl("chests/bastion_other")).build()
				},
				CRItems.POMEGRANATE_SEEDS.get(), 6, 16, 0.3F
		));
	}
}