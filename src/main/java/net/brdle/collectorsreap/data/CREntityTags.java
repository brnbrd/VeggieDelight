package net.brdle.collectorsreap.data;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class CREntityTags {

	// Forge

	// CR
	public static final TagKey<EntityType<?>> CORROSION_IMMUNE = cr("corrosion_immune");
	public static final TagKey<EntityType<?>> VOLATILITY_IMMUNE = cr("volatility_immune");
	public static final TagKey<EntityType<?>> INVOLATILE = cr("involatile");

	// Let Fish Love
	public static final TagKey<EntityType<?>> BREEDABLE_FISH = tag("letfishlove", "breedable_fish");

	private static TagKey<EntityType<?>> tag(String modid, String name) {
		return TagKey.create(Registries.ENTITY_TYPE, Util.rl(modid, name));
	}

	private static TagKey<EntityType<?>> cr(String name) {
		return tag(CollectorsReap.MODID, name);
	}
}