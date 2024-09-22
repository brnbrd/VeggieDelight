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

	private static TagKey<EntityType<?>> cr(String name) {
		return TagKey.create(Registries.ENTITY_TYPE, Util.rl(CollectorsReap.MODID, name));
	}
}