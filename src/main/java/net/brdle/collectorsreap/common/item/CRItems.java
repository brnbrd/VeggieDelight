package net.brdle.collectorsreap.common.item;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.brdle.collectorsreap.common.item.food.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.MushroomColonyItem;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Supplier;

public class CRItems extends ModItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CollectorsReap.MODID);

	public static final RegistryObject<Item> PORTOBELLO_COLONY = registerItem("portobello_colony",
			() -> new MushroomColonyItem(CRBlocks.PORTOBELLO_COLONY.get(),
					(new Item.Properties())));
	public static final RegistryObject<Item> PORTOBELLO = registerBlock(CRBlocks.PORTOBELLO);
	public static final RegistryObject<Item> BAKED_PORTOBELLO_CAP = registerFood("baked_portobello_cap",
			Nutrition.BAKED_PORTOBELLO_CAP);
	public static final RegistryObject<Item> STUFFED_PORTOBELLO_CAP = registerFood("stuffed_portobello_cap",
			Nutrition.STUFFED_PORTOBELLO_CAP);
	public static final RegistryObject<Item> PORTOBELLO_BURGER = registerFood("portobello_burger",
			Nutrition.PORTOBELLO_BURGER);
	public static final RegistryObject<Item> PORTOBELLO_WRAP = registerFood("portobello_wrap",
			Nutrition.PORTOBELLO_WRAP);
	public static final RegistryObject<Item> PORTOBELLO_RICE_SOUP = registerItem("portobello_rice_soup",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.PORTOBELLO_RICE_SOUP), true));
	public static final RegistryObject<Item> PORTOBELLO_RISOTTO = registerItem("portobello_risotto",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.PORTOBELLO_RISOTTO), true));
	public static final RegistryObject<Item> PORTOBELLO_PASTA = registerItem("portobello_pasta",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.PORTOBELLO_PASTA), true));
	public static final RegistryObject<Item> PORTOBELLO_QUICHE = registerBlock(CRBlocks.PORTOBELLO_QUICHE);
	public static final RegistryObject<Item> PORTOBELLO_QUICHE_SLICE = registerFood("portobello_quiche_slice",
			Nutrition.PORTOBELLO_QUICHE_SLICE);
	public static final RegistryObject<Item> POMEGRANATE = registerItem("pomegranate",
			() -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> POMEGRANATE_SLICE = registerFood("pomegranate_slice",
			Nutrition.POMEGRANATE_SLICE);
	public static final RegistryObject<Item> POMEGRANATE_SEEDS = registerItem("pomegranate_seeds",
			() -> new FruitSeedsItem(
					CRBlocks.POMEGRANATE_BUSH.get(), (new Item.Properties()).food(Nutrition.POMEGRANATE_SEEDS)
			));
	public static final RegistryObject<Item> LIME_SEEDS = registerItem("lime_seeds",
			() -> new FruitSeedsItem(
					CRBlocks.LIME_BUSH.get(), (new Item.Properties())
			));
	public static final RegistryObject<Item> LIME = registerFood("lime",
			Nutrition.LIME);
	public static final RegistryObject<Item> LIME_SLICE = registerFood("lime_slice",
			Nutrition.LIME_SLICE);
	public static final RegistryObject<Item> CANDIED_LIME = registerItem("candied_lime",
			() -> new ConsumableItem((new Item.Properties()).food(
					Nutrition.CANDIED_LIME), true));
	public static final RegistryObject<Item> LIME_PIE = registerBlock(CRBlocks.LIME_PIE);
	public static final RegistryObject<Item> LIME_PIE_SLICE = registerFood("lime_pie_slice",
			Nutrition.LIME_PIE_SLICE);
	public static final RegistryObject<Item> LIME_POPSICLE = registerItem("lime_popsicle",
			() -> new ConsumableItem((new Item.Properties()).food(
					Nutrition.LIME_POPSICLE), true));
	public static final RegistryObject<Item> LIME_COOKIE = registerItem("lime_cookie",
			() -> new ConsumableItem((new Item.Properties()).food(
					Nutrition.LIME_COOKIE), true));
	public static final RegistryObject<Item> HONEY_LIME_CHICKEN = registerItem("honey_lime_chicken",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.HONEY_LIME_CHICKEN), true));
	public static final RegistryObject<Item> MEDITERRANEAN_SALMON = registerItem("mediterranean_salmon",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.MEDITERRANEAN_SALMON), true));
	public static final RegistryObject<Item> SALMON_TARTARE = registerItem("salmon_tartare",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.SALMON_TARTARE), true));
	public static final RegistryObject<Item> POTATO_FRITTERS = registerItem("potato_fritters",
			() -> new ConsumableItem((new Item.Properties()).food(
					Nutrition.POTATO_FRITTERS), true));
	public static final RegistryObject<Item> COD_CEVICHE = registerItem("cod_ceviche",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.COD_CEVICHE), true));
	public static final RegistryObject<Item> CRIMSON_CARROT_ROAST = registerItem("crimson_carrot_roast",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.CRIMSON_CARROT_ROAST), true));
	public static final RegistryObject<Item> POMEGRANATE_MUTTON = registerItem("pomegranate_mutton",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.POMEGRANATE_MUTTON), true));
	public static final RegistryObject<Item> POMEGRANATE_PORK = registerItem("pomegranate_pork",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.POMEGRANATE_PORK), true));
	public static final RegistryObject<Item> POMEGRANATE_CHICKEN = registerItem("pomegranate_chicken",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.POMEGRANATE_CHICKEN), true));
	public static final RegistryObject<Item> DELUXE_SALAD = registerItem("deluxe_salad",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.DELUXE_SALAD), true));
	public static final RegistryObject<Item> POMEGRANATE_CUSTARD = registerItem("pomegranate_custard", () ->
			new DrinkableItem(drinkItem().food(
					Nutrition.POMEGRANATE_CUSTARD), true));
	public static final RegistryObject<Item> LIMEADE = registerItem("limeade", () ->
			new DrinkableItem(drinkItem().food(
					Nutrition.LIMEADE), true));
	public static final RegistryObject<Item> BERRY_LIMEADE = registerItem("berry_limeade", () ->
			new DrinkableItem(drinkItem().food(
					Nutrition.BERRY_LIMEADE), true));
	public static final RegistryObject<Item> PINK_LIMEADE = registerItem("pink_limeade", () ->
			new DrinkableItem(drinkItem().food(
					Nutrition.PINK_LIMEADE), true));
	public static final RegistryObject<Item> MINT_LIMEADE = registerItem("mint_limeade", () ->
			new CompatDrinkable((new Item.Properties()).food(
					Nutrition.MINT_LIMEADE), true, false, "neapolitan"));
	public static final RegistryObject<Item> LIME_GREEN_TEA = registerItem("lime_green_tea", () ->
			new CompatDrinkable((new Item.Properties()).food(
					Nutrition.LIME_GREEN_TEA), true, false, "farmersrespite"));
	public static final RegistryObject<Item> POMEGRANATE_BLACK_TEA = registerItem("pomegranate_black_tea", () ->
			new CompatDrinkable((new Item.Properties()).food(
					Nutrition.POMEGRANATE_BLACK_TEA), true, false, "farmersrespite"));
	public static final RegistryObject<Item> POMEGRANATE_SMOOTHIE = registerItem("pomegranate_smoothie", () ->
			new CompatDrinkable((new Item.Properties()).food(
					Nutrition.POMEGRANATE_SMOOTHIE), true, false, "neapolitan"));
	public static final RegistryObject<Item> LIME_CAKE_SLICE = registerFood("lime_cake_slice",
			Nutrition.LIME_CAKE_SLICE);
	public static final RegistryObject<Item> POMEGRANATE_CAKE_SLICE = registerFood("pomegranate_cake_slice",
			Nutrition.POMEGRANATE_CAKE_SLICE);
	public static final RegistryObject<Item> LIME_CAKE = registerItem("lime_cake", () -> new BlockItem(CRBlocks.LIME_CAKE.get(), ((new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> POMEGRANATE_CAKE = registerItem("pomegranate_cake", () -> new BlockItem(CRBlocks.POMEGRANATE_CAKE.get(), ((new Item.Properties()).stacksTo(1))));
	public static final RegistryObject<Item> LIME_CRATE = registerBlock(CRBlocks.LIME_CRATE);
	public static final RegistryObject<Item> POMEGRANATE_CRATE = registerBlock(CRBlocks.POMEGRANATE_CRATE);

	// Tiger Prawn
	public static final RegistryObject<Item> TIGER_PRAWN_SPAWN_EGG = registerItem("tiger_prawn_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.TIGER_PRAWN, 0x7c7248, 0x613432, new Item.Properties()));
	public static final RegistryObject<Item> TIGER_PRAWN_BUCKET = registerItem("tiger_prawn_bucket",
			() -> new MobBucketItem(CREntities.TIGER_PRAWN, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_TADPOLE, (new Item.Properties()).stacksTo(1)));
	public static final RegistryObject<Item> TIGER_PRAWN = registerFood("tiger_prawn", Nutrition.TIGER_PRAWN);
	public static final RegistryObject<Item> COOKED_TIGER_PRAWN = registerFood("cooked_tiger_prawn", Nutrition.COOKED_TIGER_PRAWN);
	public static final RegistryObject<Item> PRAWN_ROLL = registerFood("prawn_roll", Nutrition.PRAWN_ROLL);
	public static final RegistryObject<Item> SALMON_WRAPPED_PRAWN = registerItem("salmon_wrapped_prawn",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.SALMON_WRAPPED_PRAWN), false));
	public static final RegistryObject<Item> PRAWN_PO_BOY = registerFood("prawn_po_boy", Nutrition.PRAWN_PO_BOY);
	public static final RegistryObject<Item> PRAWN_STEW = registerItem("prawn_stew",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.PRAWN_STEW), false));
	public static final RegistryObject<Item> PRAWN_CEVICHE = registerItem("prawn_ceviche",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.PRAWN_CEVICHE), false));
	public static final RegistryObject<Item> PRAWN_NOODLES = registerItem("prawn_noodles",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.PRAWN_NOODLES), false));

	// Urchin
	public static final RegistryObject<Item> URCHIN_SPAWN_EGG = registerItem("urchin_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.URCHIN, 0x9990d7, 0x21132d, new Item.Properties()));
	public static final RegistryObject<Item> URCHIN_BUCKET = registerItem("urchin_bucket",
			() -> new MobBucketItem(CREntities.URCHIN, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_TADPOLE, (new Item.Properties()).stacksTo(1)));
	public static final RegistryObject<Item> URCHIN = registerItem("urchin",
			() -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> URCHIN_TEST = registerItem("urchin_test",
			() -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> URCHIN_NEEDLE = registerItem("urchin_needle",
			() -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> URCHIN_DART = registerItem("urchin_dart",
			() -> new UrchinDartItem((new Item.Properties())));
	public static final RegistryObject<Item> UNI = registerFood("uni", Nutrition.UNI);
	public static final RegistryObject<Item> UNI_ROLL = registerFood("uni_roll", Nutrition.UNI_ROLL);

	// Platinum Bass
	public static final RegistryObject<Item> PLATINUM_BASS_SPAWN_EGG = registerItem("platinum_bass_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.PLATINUM_BASS, 0x091442, 0x7B8698, new Item.Properties()));
	public static final RegistryObject<Item> PLATINUM_BASS_BUCKET = registerItem("platinum_bass_bucket",
			() -> new MobBucketItem(CREntities.PLATINUM_BASS, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1)));
	public static final RegistryObject<Item> PLATINUM_BASS = registerFood("platinum_bass", Nutrition.PLATINUM_BASS);
	public static final RegistryObject<Item> COOKED_PLATINUM_BASS = registerFood("cooked_platinum_bass", Nutrition.COOKED_PLATINUM_BASS);
	public static final RegistryObject<Item> PLATINUM_BASS_HEAD = registerFood("platinum_bass_head", Nutrition.PLATINUM_BASS_HEAD);
	public static final RegistryObject<Item> COOKED_PLATINUM_BASS_HEAD = registerFood("cooked_platinum_bass_head", Nutrition.COOKED_PLATINUM_BASS_HEAD);
	public static final RegistryObject<Item> PLATINUM_BASS_SLICE = registerFood("platinum_bass_slice", Nutrition.PLATINUM_BASS_SLICE);
	public static final RegistryObject<Item> COOKED_PLATINUM_BASS_SLICE = registerFood("cooked_platinum_bass_slice", Nutrition.COOKED_PLATINUM_BASS_SLICE);
	public static final RegistryObject<Item> PLATINUM_BASS_STEW = registerItem("platinum_bass_stew",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.PLATINUM_BASS_STEW), false));
	public static final RegistryObject<Item> FISH_MIX = registerItem("fish_mix",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.FISH_MIX), false));

	// Chieftain Crab
	public static final RegistryObject<Item> CHIEFTAIN_CRAB_SPAWN_EGG = registerItem("chieftain_crab_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.CHIEFTAIN_CRAB, 0xB13125, 0xE1B865, new Item.Properties()));
	public static final RegistryObject<Item> CHIEFTAIN_CRAB_BUCKET = registerItem("chieftain_crab_bucket",
			() -> new MobBucketItem(CREntities.CHIEFTAIN_CRAB, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_AXOLOTL, (new Item.Properties()).stacksTo(1).craftRemainder(Items.BUCKET)));
	public static final RegistryObject<Item> CHIEFTAIN_CRAB = registerItem("chieftain_crab", () -> new Item((new Item.Properties()).stacksTo(1).craftRemainder(Items.BOWL)));
	public static final RegistryObject<Item> CHIEFTAIN_CLAW = registerFood("chieftain_claw", Nutrition.CHIEFTAIN_CLAW);
	public static final RegistryObject<Item> CHIEFTAIN_LEG = registerFood("chieftain_leg", Nutrition.CHIEFTAIN_LEG);
	public static final RegistryObject<Item> CHIEFTAIN_CRAB_MEAT = registerFood("chieftain_crab_meat", Nutrition.CHIEFTAIN_CRAB_MEAT);
	public static final RegistryObject<Item> CRAB_MISO = registerItem("crab_miso",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.CRAB_MISO), false));
	public static final RegistryObject<Item> CRAB_NOODLES = registerItem("crab_noodles",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.CRAB_NOODLES), false));
	public static final RegistryObject<Item> CRAB_LASAGNA = registerFood("crab_lasagna", Nutrition.CRAB_LASAGNA);
	public static final RegistryObject<Item> BUTTERED_LEGS = registerItem("buttered_legs",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.BUTTERED_LEGS), false));
	public static final RegistryObject<Item> BIG_RICE_BALL = registerFood("big_rice_ball", Nutrition.BIG_RICE_BALL);
	public static final RegistryObject<Item> LAND_AND_SEA_BURGER = registerFood("land_and_sea_burger", Nutrition.LAND_AND_SEA_BURGER);

	// Clam
	public static final RegistryObject<Item> CLAM_SPAWN_EGG = registerItem("clam_spawn_egg", () -> new ForgeSpawnEggItem(CREntities.CLAM, 0x775745, 0xC5A877, new Item.Properties()));
	public static final RegistryObject<Item> CLAM_BUCKET = registerItem("clam_bucket",
			() -> new MobBucketItem(CREntities.CLAM, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_TADPOLE, (new Item.Properties()).stacksTo(1)));
	public static final RegistryObject<Item> CLAM = registerItem("clam",
			() -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> LUNAR_PEARL = registerItem("lunar_pearl",
			() -> new Item((new Item.Properties())));
	public static final RegistryObject<Item> CLAM_MEAT = registerFood("clam_meat", Nutrition.CLAM_MEAT);
	public static final RegistryObject<Item> CLAM_ROLL = registerFood("clam_roll", Nutrition.CLAM_ROLL);
	public static final RegistryObject<Item> CLAM_CHOWDER = registerItem("clam_chowder",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.CLAM_CHOWDER), false));
	public static final RegistryObject<Item> CLAM_PASTA = registerItem("clam_pasta",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.CLAM_PASTA), false));
	public static final RegistryObject<Item> CLAM_MEATBALL_STEW = registerItem("clam_meatball_stew",
			() -> new ConsumableItem(bowlFoodItem(
					Nutrition.CLAM_MEATBALL_STEW), false));

	public static final RegistryObject<Item> SEA_WRAP = registerFood("sea_wrap", Nutrition.SEA_WRAP);

	// Nether's Delight Compat
	public static final RegistryObject<Item> GLAZED_STRIDER = registerItem("glazed_strider",
			() -> new CompatConsumable((new Item.Properties()).food(
					Nutrition.GLAZED_STRIDER).craftRemainder(Items.BOWL).stacksTo(16),
					true, false, "mynethersdelight", "nethersdelight"));
	public static final RegistryObject<Item> SPICY_GRENADINE_JELLY = registerItem("spicy_grenadine_jelly",
			() -> new CompatConsumable((new Item.Properties()).food(
					Nutrition.SPICY_GRENADINE_JELLY).craftRemainder(Items.BOWL).stacksTo(16),
					true, false, "mynethersdelight", "nethersdelight"));

	// Neapolitan Compat
	public static final RegistryObject<Item> STRAWBERRY_JAM_BUN = registerItem("strawberry_jam_bun",
			() -> new CompatConsumable((new Item.Properties()).food(
					Nutrition.STRAWBERRY_JAM_BUN), true, false, 1.0F, "neapolitan"));
	public static final RegistryObject<Item> POMEGRANATE_BEAN_SALAD = registerItem("pomegranate_bean_salad",
			() -> new CompatConsumable((new Item.Properties()).food(
					Nutrition.POMEGRANATE_BEAN_SALAD).craftRemainder(Items.BOWL).stacksTo(16), true, false, "neapolitan"));
	public static final RegistryObject<Item> CHOCOLATE_ARILS = registerItem("chocolate_arils",
			() -> new CompatConsumable((new Item.Properties()).food(
					Nutrition.CHOCOLATE_ARILS), true, false, "neapolitan"));
	public static final RegistryObject<Item> LIME_MILKSHAKE = registerItem("lime_milkshake",
			() -> new ShakeItem(new Item.Properties().food(Nutrition.LIME_MILKSHAKE)));
	public static final RegistryObject<Item> POMEGRANATE_MILKSHAKE = registerItem("pomegranate_milkshake",
			() -> new ShakeItem(new Item.Properties().food(Nutrition.POMEGRANATE_MILKSHAKE)));
	public static final RegistryObject<Item> LIME_ICE_CREAM = registerItem("lime_ice_cream",
			() -> new IceCreamItem((new Item.Properties()).food(Nutrition.LIME_ICE_CREAM)));
	public static final RegistryObject<Item> POMEGRANATE_ICE_CREAM = registerItem("pomegranate_ice_cream",
			() -> new IceCreamItem((new Item.Properties()).food(Nutrition.POMEGRANATE_ICE_CREAM)));
	public static final RegistryObject<Item> LIME_ICE_CREAM_BLOCK = registerItem("lime_ice_cream_block",
			() -> new BlockItem(CRBlocks.LIME_ICE_CREAM_BLOCK.get(), (new Item.Properties())));
	public static final RegistryObject<Item> POMEGRANATE_ICE_CREAM_BLOCK = registerItem("pomegranate_ice_cream_block",
			() -> new BlockItem(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get(), (new Item.Properties())));

	// Gummies
	public static final RegistryObject<Item> LIME_GUMMY = registerGummy("lime", Nutrition.LIME_GUMMY, FarmersDelight.MODID);
	public static final RegistryObject<Item> POMEGRANATE_GUMMY = registerGummy("pomegranate", Nutrition.POMEGRANATE_GUMMY, FarmersDelight.MODID);
	public static final RegistryObject<Item> MELON_GUMMY = registerGummy("melon", Nutrition.MELON_GUMMY, FarmersDelight.MODID);
	public static final RegistryObject<Item> APPLE_GUMMY = registerGummy("apple", Nutrition.APPLE_GUMMY, FarmersDelight.MODID);
	public static final RegistryObject<Item> GLOW_BERRY_GUMMY = registerGummy("glow_berry", Nutrition.GLOW_BERRY_GUMMY, FarmersDelight.MODID);
	public static final RegistryObject<Item> BANANA_GUMMY = registerGummy("banana", Nutrition.BANANA_GUMMY, "neapolitan");
	public static final RegistryObject<Item> VANILLA_GUMMY = registerGummy("vanilla", Nutrition.VANILLA_GUMMY, "neapolitan");
	public static final RegistryObject<Item> CHOCOLATE_GUMMY = registerGummy("chocolate", Nutrition.CHOCOLATE_GUMMY, "neapolitan");
	public static final RegistryObject<Item> STRAWBERRY_GUMMY = registerGummy("strawberry", Nutrition.STRAWBERRY_GUMMY, "neapolitan");
	public static final RegistryObject<Item> MINT_GUMMY = registerGummy("mint", Nutrition.MINT_GUMMY, "neapolitan");
	public static final RegistryObject<Item> ADZUKI_GUMMY = registerGummy("adzuki", Nutrition.ADZUKI_GUMMY, "neapolitan");
	public static final RegistryObject<Item> PUMPKIN_GUMMY = registerGummy("pumpkin", Nutrition.PUMPKIN_GUMMY, "seasonals");
	public static final RegistryObject<Item> SWEET_BERRY_GUMMY = registerGummy("sweet_berry", Nutrition.SWEET_BERRY_GUMMY, "seasonals");
	public static final RegistryObject<Item> BEETROOT_GUMMY = registerGummy("beetroot", Nutrition.BEETROOT_GUMMY, "seasonals");
	public static final RegistryObject<Item> ALOE_GUMMY = registerGummy("aloe", Nutrition.ALOE_GUMMY, "atmospheric");
	public static final RegistryObject<Item> PASSION_FRUIT_GUMMY = registerGummy("passion_fruit", Nutrition.PASSION_FRUIT_GUMMY, "atmospheric");
	public static final RegistryObject<Item> YUCCA_GUMMY = registerGummy("yucca", Nutrition.YUCCA_GUMMY, "atmospheric");
	public static final RegistryObject<Item> GREEN_TEA_GUMMY = registerGummy("green_tea", Nutrition.GREEN_TEA_GUMMY, "farmersrespite");
	public static final RegistryObject<Item> YELLOW_TEA_GUMMY = registerGummy("yellow_tea", Nutrition.YELLOW_TEA_GUMMY, "farmersrespite");
	public static final RegistryObject<Item> BLACK_TEA_GUMMY = registerGummy("black_tea", Nutrition.BLACK_TEA_GUMMY, "farmersrespite");
	public static final RegistryObject<Item> COFFEE_GUMMY = registerGummy("coffee", Nutrition.COFFEE_GUMMY, "farmersrespite");

	public static final RegistryObject<Item> URCHIN_TEST_BLOCK = registerBlock("urchin_test_block", CRBlocks.URCHIN_TEST_BLOCK);
	public static final RegistryObject<Item> URCHIN_TEST_BRICKS = registerBlock("urchin_test_bricks", CRBlocks.URCHIN_TEST_BRICKS);
	public static final RegistryObject<Item> URCHIN_TEST_BRICK_SLAB = registerBlock("urchin_test_brick_slab", CRBlocks.URCHIN_TEST_BRICK_SLAB);
	public static final RegistryObject<Item> URCHIN_TEST_BRICK_STAIRS = registerBlock("urchin_test_brick_stairs", CRBlocks.URCHIN_TEST_BRICK_STAIRS);
	public static final RegistryObject<Item> URCHIN_TEST_BRICK_WALL = registerBlock("urchin_test_brick_wall", CRBlocks.URCHIN_TEST_BRICK_WALL);
	public static final RegistryObject<Item> CHISELED_URCHIN_TEST_BRICKS = registerBlock("chiseled_urchin_test_bricks", CRBlocks.CHISELED_URCHIN_TEST_BRICKS);
	public static final RegistryObject<Item> URCHIN_TEST_TILES = registerBlock("urchin_test_tiles", CRBlocks.URCHIN_TEST_TILES);
	public static final RegistryObject<Item> URCHIN_TEST_TILE_SLAB = registerBlock("urchin_test_tile_slab", CRBlocks.URCHIN_TEST_TILE_SLAB);
	public static final RegistryObject<Item> URCHIN_TEST_TILE_STAIRS = registerBlock("urchin_test_tile_stairs", CRBlocks.URCHIN_TEST_TILE_STAIRS);
	public static final RegistryObject<Item> URCHIN_TEST_TILE_WALL = registerBlock("urchin_test_tile_wall", CRBlocks.URCHIN_TEST_TILE_WALL);

	public static RegistryObject<Item> registerBlock(RegistryObject<Block> block) {
		return registerBlock(Util.name(block), block);
	}

	public static RegistryObject<Item> registerBlock(String name, RegistryObject<Block> block) {
		return registerItem(name, () -> new BlockItem(block.get(), (new Item.Properties())));
	}

	public static RegistryObject<Item> registerGummy(String name, FoodProperties properties, @Nullable String modid) {
		return registerItem(name + "_gummy", () ->
				new GummyItem((new Item.Properties())
						.food(properties), modid));
	}

	public static RegistryObject<Item> registerFood(String name, FoodProperties properties) {
		return registerItem(name, () -> new Item((new Item.Properties()
				.food(properties))));
	}

	public static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
		return ITEMS.register(name, item);
	}

	public static void create(IEventBus bus) {
		ITEMS.register(bus);
	}
}