package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.data.CREntityTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class CREntityTagProvider extends EntityTypeTagsProvider {
	public CREntityTagProvider(DataGenerator gen, ExistingFileHelper existingFileHelper) {
		super(gen, CollectorsReap.MODID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(CREntityTags.INVOLATILE)
			.add(EntityType.IRON_GOLEM)
			.add(EntityType.WARDEN)
			.add(EntityType.RAVAGER);
		this.tag(CREntityTags.VOLATILITY_IMMUNE)
			.add(EntityType.VILLAGER);
	}

	@Override
	public @NotNull String getName() {
		return CollectorsReap.MODID;
	}
}