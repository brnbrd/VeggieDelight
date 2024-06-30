package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.data.CRBiomeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class CRBiomeTagProvider extends BiomeTagsProvider {
	public CRBiomeTagProvider(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
		super(gen, CollectorsReap.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(CRBiomeTags.PORTOBELLO_SPAWNS).add(Biomes.MEADOW);
		this.tag(CRBiomeTags.LIME_SPAWNS).add(Biomes.FLOWER_FOREST);
		this.tag(CRBiomeTags.POMEGRANATE_SPAWNS).add(Biomes.WARPED_FOREST);
		this.tag(CRBiomeTags.PLATINUM_BASS_SPAWNS)
			.addTag(BiomeTags.IS_RIVER);
		this.tag(CRBiomeTags.TIGER_PRAWN_SPAWNS)
			.addTag(BiomeTags.IS_RIVER)
			.add(Biomes.SWAMP)
			.add(Biomes.MANGROVE_SWAMP);
		this.tag(CRBiomeTags.URCHIN_SPAWNS)
			.addTag(BiomeTags.IS_OCEAN)
			.addTag(BiomeTags.IS_DEEP_OCEAN);
		this.tag(CRBiomeTags.CLAM_SPAWNS)
			.addTag(BiomeTags.IS_OCEAN)
			.addTag(BiomeTags.IS_DEEP_OCEAN);
		this.tag(CRBiomeTags.CHIEFTAIN_CRAB_SPAWNS)
			.addTag(BiomeTags.IS_BEACH)
			.add(Biomes.WARM_OCEAN)
			.add(Biomes.LUKEWARM_OCEAN)
			.add(Biomes.DEEP_LUKEWARM_OCEAN);

	}
}
