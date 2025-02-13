package net.brdle.collectorsreap.data;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CRBlockTags {
	// Collector's Reap
	public static final TagKey<Block> PORTOBELLO_SPAWNABLE_ON = bind(CollectorsReap.MODID, "portobello_spawnable_on");
	public static final TagKey<Block> POMEGRANATE_FAST_ON = bind(CollectorsReap.MODID, "pomegranate_fast_on");
	public static final TagKey<Block> STYGIAN_POMEGRANATE_GROWABLE_ON = bind(CollectorsReap.MODID, "stygian_pomegranate_growable_on");
	public static final TagKey<Block> CRAB_SPAWNABLE_ON = bind(CollectorsReap.MODID, "crab_spawnable_on");

	// Serene Seasons
	public static final TagKey<Block> WINTER_CROPS = bind("sereneseasons", "winter_crops");
	public static final TagKey<Block> SUMMER_CROPS = bind("sereneseasons", "summer_crops");
	public static final TagKey<Block> AUTUMN_CROPS = bind("sereneseasons", "autumn_crops");
	public static final TagKey<Block> SPRING_CROPS = bind("sereneseasons", "spring_crops");

	// My Nether's Delight
	public static final TagKey<Block> SHOWCASE_ACTIVATORS = bind("mynethersdelight", "showcase_activators");
	public static final TagKey<Block> NOT_PROPAGATE_PLANT = bind("mynethersdelight", "not_propagate_plant");

	private static TagKey<Block> bind(String modid, String name) {
		return BlockTags.create(Util.rl(modid, name));
	}
}