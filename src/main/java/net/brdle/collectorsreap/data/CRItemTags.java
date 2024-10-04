package net.brdle.collectorsreap.data;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CRItemTags {

	// Forge
	public static final TagKey<Item> FRUITS = forge("fruits");
	public static final TagKey<Item> FRUITS_CITRUS = forge("fruits/citrus");
	public static final TagKey<Item> FRUITS_POMEGRANATE = forge("fruits/pomegranate");
	public static final TagKey<Item> SEEDS_POMEGRANATE = forge("seeds/pomegranate");
	public static final TagKey<Item> FRUITS_LIME = forge("fruits/lime");
	public static final TagKey<Item> SEEDS_LIME = forge("seeds/lime");
	public static final TagKey<Item> MUSHROOMS_PORTOBELLO = forge("mushrooms/portobello");
	public static final TagKey<Item> TORTILLA = forge("tortilla");
	public static final TagKey<Item> ICE_CUBES = forge("ice_cubes");
	public static final TagKey<Item> TEA_LEAVES_GREEN = forge("tea_leaves/green");
	public static final TagKey<Item> TEA_LEAVES_YELLOW = forge("tea_leaves/yellow");
	public static final TagKey<Item> TEA_LEAVES_BLACK = forge("tea_leaves/black");
	public static final TagKey<Item> COFFEE_BEANS = forge("coffee_beans");
	public static final TagKey<Item> CRAB_LEGS = forge("crab_legs");
	public static final TagKey<Item> CRAB_MEAT = forge("crab_meat");
	public static final TagKey<Item> RAW_CLAM = forge("raw_clam");
	public static final TagKey<Item> RAW_PRAWN = forge("raw_prawn");
	public static final TagKey<Item> COOKED_PRAWN = forge("cooked_prawn");
	public static final TagKey<Item> RAW_FISHES_BASS = forge("raw_fishes/bass");
	public static final TagKey<Item> COOKED_FISHES_BASS = forge("cooked_fishes/bass");
	public static final TagKey<Item> RAW_HOGLIN = forge("raw_hoglin");
	public static final TagKey<Item> RAW_STRIDER = forge("raw_strider");
	public static final TagKey<Item> COOKIES = forge("cookies");
	public static final TagKey<Item> EGGS_BIRD = forge("eggs/bird");

	// CR
	public static final TagKey<Item> GUMMIES = cr("gummies");
	public static final TagKey<Item> LIME_OR_SLICE = cr("lime_or_slice");
	public static final TagKey<Item> HOT_NETHER_FRUIT = cr("hot_nether_fruit");
	public static final TagKey<Item> DART_SHOOTERS = cr("dart_shooters");

	// Diet
	public static final TagKey<Item> DIET_FRUITS = Util.it("diet", "fruits");
	public static final TagKey<Item> DIET_VEGETABLES = Util.it("diet", "vegetables");
	public static final TagKey<Item> DIET_PROTEINS = Util.it("diet", "proteins");
	public static final TagKey<Item> SPECIAL_FOOD = Util.it("diet", "special_food");

	// Neapolitan
	public static final TagKey<Item> ICE_CREAM = Util.it("neapolitan", "ice_cream");
	public static final TagKey<Item> BANANA = Util.it("neapolitan", "banana");
	public static final TagKey<Item> DRIED_VANILLA_PODS = Util.it("neapolitan", "dried_vanilla_pods");
	public static final TagKey<Item> CHOCOLATE_BAR = Util.it("neapolitan", "chocolate_bar");
	public static final TagKey<Item> RED_STRAWBERRIES = Util.it("neapolitan", "red_strawberries");
	public static final TagKey<Item> MINT_LEAVES = Util.it("neapolitan", "mint_leaves");
	public static final TagKey<Item> ROASTED_ADZUKI_BEANS = Util.it("neapolitan", "roasted_adzuki_beans");

	// Atmospheric
	public static final TagKey<Item> ALOE_LEAVES = Util.it("atmospheric", "aloe_leaves");
	public static final TagKey<Item> PASSION_FRUIT = Util.it("atmospheric", "passion_fruit");
	public static final TagKey<Item> YUCCA_FRUIT = Util.it("atmospheric", "yucca_fruit");

	// Seasonals
	public static final TagKey<Item> PUMPKIN_PUREE = Util.it("seasonals", "pumpkin_puree");

	// Serene Seasons
	public static final TagKey<Item> WINTER_CROPS = Util.it("sereneseasons", "winter_crops");
	public static final TagKey<Item> SUMMER_CROPS = Util.it("sereneseasons", "summer_crops");
	public static final TagKey<Item> AUTUMN_CROPS = Util.it("sereneseasons", "autumn_crops");
	public static final TagKey<Item> SPRING_CROPS = Util.it("sereneseasons", "spring_crops");

	// SAS
	public static final TagKey<Item> BURGER_BUN = Util.it("some_assembly_required", "burger_bun");

	// Supplementaries
	public static final TagKey<Item> FLOWER_BOX_PLANTABLE = Util.it("supplementaries", "flower_box_plantable");
	public static final TagKey<Item> SUPP_COOKIES = Util.it("supplementaries", "cookies");

	private static TagKey<Item> cr(String name) {
		return Util.it(CollectorsReap.MODID, name);
	}

	private static TagKey<Item> forge(String name) {
		return Util.it("forge", name);
	}
}