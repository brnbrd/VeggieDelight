package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.concurrent.CompletableFuture;

public class CRItemTagProvider extends ItemTagsProvider {

	public CRItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, provider, blockTagProvider, CollectorsReap.MODID, existingFileHelper);
	}

	@Override
	public void addTags(HolderLookup.@NotNull Provider provider) {
		// Minecraft
		this.tag(ItemTags.WALLS)
				.add(CRItems.URCHIN_TEST_BRICK_WALL.get())
				.add(CRItems.URCHIN_TEST_TILE_WALL.get());
		this.tag(ItemTags.SLABS)
				.add(CRItems.URCHIN_TEST_BRICK_SLAB.get())
				.add(CRItems.URCHIN_TEST_TILE_SLAB.get());
		this.tag(ItemTags.STAIRS)
				.add(CRItems.URCHIN_TEST_BRICK_STAIRS.get())
				.add(CRItems.URCHIN_TEST_TILE_STAIRS.get());

		// Forge
		this.tag(CRItemTags.FRUITS_POMEGRANATE)
				.add(CRItems.POMEGRANATE_SLICE.get());
		this.tag(CRItemTags.FRUITS_LIME)
				.add(CRItems.LIME.get());
		this.tag(CRItemTags.LIME_OR_SLICE)
				.addTag(CRItemTags.FRUITS_LIME)
				.add(CRItems.LIME_SLICE.get());
		this.tag(CRItemTags.FRUITS_CITRUS)
				.addTag(CRItemTags.FRUITS_LIME)
				.addOptionalTag(Util.rl("forge", "fruits/lemon"));
		this.tag(CRItemTags.FRUITS)
				.addTag(CRItemTags.FRUITS_POMEGRANATE)
				.addTag(CRItemTags.FRUITS_LIME);
		this.tag(CRItemTags.SEEDS_LIME)
				.add(CRItems.LIME_SEEDS.get());
		this.tag(CRItemTags.SEEDS_POMEGRANATE)
				.add(CRItems.POMEGRANATE_SEEDS.get());
		this.tag(Tags.Items.SEEDS)
				.addTag(CRItemTags.SEEDS_LIME)
				.addTag(CRItemTags.SEEDS_POMEGRANATE);
		this.tag(CRItemTags.MUSHROOMS_PORTOBELLO)
				.add(CRItems.PORTOBELLO.get());
		this.tag(Tags.Items.MUSHROOMS)
				.addTag(CRItemTags.MUSHROOMS_PORTOBELLO);
		this.tag(CRItemTags.TORTILLA)
				.addOptional(Util.rl("culturaldelights", "tortilla"));
		this.tag(CRItemTags.ICE_CREAM)
				.add(CRItems.LIME_ICE_CREAM.get())
				.add(CRItems.POMEGRANATE_ICE_CREAM.get());
		this.tag(CRItemTags.GUMMIES)
				.add(CRItems.LIME_GUMMY.get())
				.add(CRItems.POMEGRANATE_GUMMY.get())
				.add(CRItems.MELON_GUMMY.get())
				.add(CRItems.APPLE_GUMMY.get())
				.add(CRItems.GLOW_BERRY_GUMMY.get())
				.add(CRItems.BANANA_GUMMY.get())
				.add(CRItems.VANILLA_GUMMY.get())
				.add(CRItems.CHOCOLATE_GUMMY.get())
				.add(CRItems.STRAWBERRY_GUMMY.get())
				.add(CRItems.MINT_GUMMY.get())
				.add(CRItems.ADZUKI_GUMMY.get())
				.add(CRItems.PUMPKIN_GUMMY.get())
				.add(CRItems.SWEET_BERRY_GUMMY.get())
				.add(CRItems.BEETROOT_GUMMY.get())
				.add(CRItems.ALOE_GUMMY.get())
				.add(CRItems.PASSION_FRUIT_GUMMY.get())
				.add(CRItems.YUCCA_GUMMY.get());
		this.tag(CRItemTags.CRAB_LEGS)
				.add(CRItems.CHIEFTAIN_LEG.get())
				.addOptional(Util.rl("quark", "cooked_crab_leg"))
				.addOptional(Util.rl("crabbersdelight", "crab_legs"));
		this.tag(CRItemTags.CRAB_MEAT)
				.addTag(CRItemTags.CRAB_LEGS)
				.add(CRItems.CHIEFTAIN_CRAB_MEAT.get())
				.addOptional(Util.rl("ecologics", "crab_meat"));
		this.tag(CRItemTags.RAW_CLAM)
				.add(CRItems.CLAM_MEAT.get())
				.addOptional(Util.rl("crabbersdelight", "raw_clam_meat"));
		this.tag(CRItemTags.RAW_PRAWN)
				.add(CRItems.TIGER_PRAWN.get());
		this.tag(CRItemTags.COOKED_PRAWN)
				.add(CRItems.COOKED_TIGER_PRAWN.get());
		this.tag(CRItemTags.RAW_FISHES_BASS)
				.add(CRItems.PLATINUM_BASS.get())
				.add(CRItems.PLATINUM_BASS_SLICE.get());
		this.tag(CRItemTags.COOKED_FISHES_BASS)
				.add(CRItems.COOKED_PLATINUM_BASS.get())
				.add(CRItems.COOKED_PLATINUM_BASS_SLICE.get());
		this.tag(CRItemTags.HOT_NETHER_FRUIT)
				.addOptionalTag(Util.rl("mynethersdelight", "bullet_pepper"))
				.addOptional(Util.rl("nethersdelight", "propelpearl"));
		this.tag(CRItemTags.RAW_HOGLIN)
				.addOptionalTag(Util.rl("forge", "hoglin_loin"))
				.addOptionalTag(Util.rl("mynethersdelight", "raw_hoglin"))
				.addOptional(Util.rl("nethersdelight", "hoglin_loin"));
		this.tag(CRItemTags.RAW_STRIDER)
				.addOptionalTag(Util.rl("mynethersdelight", "strider_meats"))
				.addOptional(Util.rl("nethersdelight", "raw_strider"));
		this.tag(CRItemTags.COOKIES)
				.add(Items.COOKIE)
				.add(ModItems.HONEY_COOKIE.get())
				.add(ModItems.SWEET_BERRY_COOKIE.get())
				.add(CRItems.LIME_COOKIE.get());
		this.tag(CRItemTags.SUPP_COOKIES)
				.addTag(CRItemTags.COOKIES);
		this.tag(CRItemTags.EGGS_BIRD)
				.add(Items.EGG)
				.addOptional(Util.rl("naturalist", "duck_egg"))
				.addOptional(Util.rl("autumnity", "turkey_egg"))
				.addOptional(Util.rl("deep_aether", "quail_egg"));
		this.tag(ForgeTags.EGGS)
				.addTag(CRItemTags.EGGS_BIRD);

		// Neapolitan
		this.addSelf(CRItemTags.BANANA);
		this.addSelf(CRItemTags.DRIED_VANILLA_PODS);
		this.addSelf(CRItemTags.CHOCOLATE_BAR);
		this.addSelf(CRItemTags.MINT_LEAVES);
		this.addSelf(CRItemTags.ROASTED_ADZUKI_BEANS);
		this.tag(CRItemTags.RED_STRAWBERRIES).addOptional(Util.rl("neapolitan", "strawberries"));
		this.tag(Util.it("neapolitan", "ice_cream"))
				.add(CRItems.LIME_ICE_CREAM.get())
				.add(CRItems.POMEGRANATE_ICE_CREAM.get());

		// Atmospheric
		this.addSelf(CRItemTags.ALOE_LEAVES);
		this.addSelf(CRItemTags.YUCCA_FRUIT);
		this.addSelf(CRItemTags.PASSION_FRUIT);

		// Seasonals
		this.addSelf(CRItemTags.PUMPKIN_PUREE);

		// Serene Seasons
		this.tag(CRItemTags.WINTER_CROPS);
		this.tag(CRItemTags.SUMMER_CROPS)
				.add(CRItems.POMEGRANATE_SEEDS.get());
		this.tag(CRItemTags.AUTUMN_CROPS)
				.add(CRItems.POMEGRANATE_SEEDS.get());
		this.tag(CRItemTags.SPRING_CROPS)
				.add(CRItems.LIME_SEEDS.get());

		// Tea and Coffee
		this.tag(CRItemTags.TEA_LEAVES_GREEN)
				.addOptional(Util.rl("farmersrespite", "green_tea_leaves"));
		this.tag(CRItemTags.TEA_LEAVES_YELLOW)
				.addOptional(Util.rl("farmersrespite", "yellow_tea_leaves"));
		this.tag(CRItemTags.TEA_LEAVES_BLACK)
				.addOptional(Util.rl("farmersrespite", "black_tea_leaves"));
		this.tag(CRItemTags.COFFEE_BEANS)
				.addOptional(Util.rl("farmersrespite", "coffee_beans"));

		// SAS
		this.addSelf(CRItemTags.BURGER_BUN);

		// Supplementaries
		this.tag(CRItemTags.FLOWER_BOX_PLANTABLE)
				.add(CRItems.PORTOBELLO_COLONY.get())
				.addOptional(Util.rl("mynethersdelight", "warped_fungus_colony"))
				.addOptional(Util.rl("mynethersdelight", "crimson_fungus_colony"));
	}

	private TagsProvider.TagAppender<Item> addSelf(TagKey<Item> item) {
		return this.tag(item).addOptional(item.location());
	}
}
