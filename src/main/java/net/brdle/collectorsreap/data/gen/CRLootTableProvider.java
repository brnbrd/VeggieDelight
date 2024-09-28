package net.brdle.collectorsreap.data.gen;

import com.google.common.collect.ImmutableList;
import net.brdle.collectorsreap.common.loot.CRBlockLoot;
import net.brdle.collectorsreap.common.loot.CREntityLoot;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import java.util.Collections;

public class CRLootTableProvider extends LootTableProvider {

	public CRLootTableProvider(PackOutput output) {
		super(output, Collections.emptySet(), ImmutableList.of(
			new LootTableProvider.SubProviderEntry(CRBlockLoot::new, LootContextParamSets.BLOCK),
			new LootTableProvider.SubProviderEntry(CREntityLoot::new, LootContextParamSets.ENTITY)
		));
	}
}