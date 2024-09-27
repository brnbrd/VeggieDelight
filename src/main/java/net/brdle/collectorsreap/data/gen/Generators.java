package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.data.CRRegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.concurrent.CompletableFuture;

public class Generators {

	@SubscribeEvent
	public void gatherData(GatherDataEvent e) {
		DataGenerator gen = e.getGenerator();
		PackOutput output = gen.getPackOutput();
		ExistingFileHelper helper = e.getExistingFileHelper();

		DatapackBuiltinEntriesProvider datapackProvider = new CRRegistries(output, e.getLookupProvider());
		CompletableFuture<HolderLookup.Provider> lookup = datapackProvider.getRegistryProvider();
		gen.addProvider(e.includeServer(), datapackProvider);
		CRBlockTagProvider blockTags = new CRBlockTagProvider(output, lookup, helper);
		gen.addProvider(e.includeServer(), blockTags);
		gen.addProvider(e.includeServer(), new CRItemTagProvider(output, lookup, blockTags.contentsGetter(), helper));
		gen.addProvider(e.includeServer(), new CREntityTagProvider(output, lookup, helper));
		gen.addProvider(e.includeServer(), new CRBiomeTagProvider(output, lookup, helper));
		gen.addProvider(e.includeServer(), new CRRecipeProvider(output));
		gen.addProvider(e.includeServer(), new CRLootTableProvider(output));
		gen.addProvider(e.includeServer(), new CRLootModifierProvider(output));

		gen.addProvider(e.includeClient(), new CRBlockStateProvider(output, helper));
		gen.addProvider(e.includeClient(), new CRItemModelProvider(output, helper));
		gen.addProvider(e.includeClient(), new CRLanguageProvider(output));
	}
}