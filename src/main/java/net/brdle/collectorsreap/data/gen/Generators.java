package net.brdle.collectorsreap.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Generators {

    @SubscribeEvent
    public void gatherData(GatherDataEvent e) {
        DataGenerator gen = e.getGenerator();
        ExistingFileHelper helper = e.getExistingFileHelper();

        CRBlockTagProvider blockTags = new CRBlockTagProvider(gen, helper);
        gen.addProvider(e.includeServer(), blockTags);
        gen.addProvider(e.includeServer(), new CRItemTagProvider(gen, blockTags, helper));
        gen.addProvider(e.includeServer(), new CREntityTagProvider(gen, helper));
        gen.addProvider(e.includeServer(), new CRBiomeTagProvider(gen, helper));
        gen.addProvider(e.includeServer(), new CRRecipeProvider(gen));
        gen.addProvider(e.includeServer(), new CRLootTableProvider(gen));
        gen.addProvider(e.includeServer(), new CRLootModifierProvider(gen));

        gen.addProvider(e.includeClient(), new CRBlockStateProvider(gen, helper));
        gen.addProvider(e.includeClient(), new CRItemModelProvider(gen, helper));
        gen.addProvider(e.includeClient(), new CRLanguageProvider(gen));
    }
}
