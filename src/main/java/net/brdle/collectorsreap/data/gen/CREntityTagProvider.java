package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.brdle.collectorsreap.data.CREntityTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.CompletableFuture;

public class CREntityTagProvider extends EntityTypeTagsProvider {
	public CREntityTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper helper) {
		super(output, provider, CollectorsReap.MODID, helper);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider pProvider) {
		this.tag(CREntityTags.INVOLATILE)
			.add(EntityType.IRON_GOLEM)
			.add(EntityType.WARDEN)
			.add(EntityType.RAVAGER);
		this.tag(CREntityTags.VOLATILITY_IMMUNE).add(EntityType.VILLAGER);
		this.tag(CREntityTags.BREEDABLE_FISH)
			.replace(false)
			.add(CREntities.PLATINUM_BASS.get());
	}
}