package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class CRLanguageProvider extends LanguageProvider {
    public CRLanguageProvider(PackOutput output) {
        super(output, CollectorsReap.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addEntities();
        addText();
        addEffects();
        addBlocks();
        addItems();
    }

    private void addEntities() {
        addEntityType(CREntities.TIGER_PRAWN, "Tiger Prawn");
        addEntityType(CREntities.URCHIN, "Urchin");
        addEntityType(CREntities.PLATINUM_BASS, "Platinum Bass");
        addEntityType(CREntities.CHIEFTAIN_CRAB, "Chieftain Crab");
        addEntityType(CREntities.CLAM, "Tide Clam");
    }

    private void addText() {
        add("tooltip.requires_modid", "Requires modid:");
        add("desc." + CollectorsReap.MODID + "." + Util.name(CRItems.PORTOBELLO), "Found in Meadows.");
        add("desc." + CollectorsReap.MODID + "." + Util.name(CRItems.LIME), "Found in Flower Forests.");
        add("desc." + CollectorsReap.MODID + "." + Util.name(CRItems.POMEGRANATE), "Found in Warped Forests.");
    }

    private void addEffects() {
        addEffect(CREffects.CORROSION, "Corrosion");
        add(CREffects.CORROSION.get().getDescriptionId() + ".description", "Provides the user a defensive acid shield, corroding projectiles and damaging attack weapons.");
        addEffect(CREffects.VOLATILITY, "Volatility");
        add(CREffects.VOLATILITY.get().getDescriptionId() + ".description", "Each hit the user inflicts on an entity creates a shockwave of splash damage.");
    }

    private void addBlocks() {
        addBlock(CRBlocks.PORTOBELLO, "Portobello");
        addBlock(CRBlocks.PORTOBELLO_COLONY, "Portobello Colony");
        addBlock(CRBlocks.PORTOBELLO_QUICHE, "Portobello Quiche");
        addBlock(CRBlocks.LIME_PIE, "Key Lime Pie");
        addBlock(CRBlocks.SMALL_LIME_BUSH, "Lime Seeds");
        addBlock(CRBlocks.LIME_BUSH, "Lime Bush");
        addBlock(CRBlocks.LIME_CRATE, "Lime Crate");
        addBlock(CRBlocks.SMALL_POMEGRANATE_BUSH, "Pomegranate Seeds");
        addBlock(CRBlocks.POMEGRANATE_BUSH, "Pomegranate Bush");
        addBlock(CRBlocks.POMEGRANATE_CRATE, "Pomegranate Crate");
        addBlock(CRBlocks.LIME_CAKE, "Lime Cake");
        addBlock(CRBlocks.CANDLE_LIME_CAKE, "Lime Cake with Candle");
        addBlock(CRBlocks.WHITE_CANDLE_LIME_CAKE, "Lime Cake with White Candle");
        addBlock(CRBlocks.ORANGE_CANDLE_LIME_CAKE, "Lime Cake with Orange Candle");
        addBlock(CRBlocks.MAGENTA_CANDLE_LIME_CAKE, "Lime Cake with Magenta Candle");
        addBlock(CRBlocks.LIME_CANDLE_LIME_CAKE, "Lime Cake with Lime Candle");
        addBlock(CRBlocks.PINK_CANDLE_LIME_CAKE, "Lime Cake with Pink Candle");
        addBlock(CRBlocks.GRAY_CANDLE_LIME_CAKE, "Lime Cake with Gray Candle");
        addBlock(CRBlocks.LIGHT_GRAY_CANDLE_LIME_CAKE, "Lime Cake with Light Gray Candle");
        addBlock(CRBlocks.CYAN_CANDLE_LIME_CAKE, "Lime Cake with Cyan Candle");
        addBlock(CRBlocks.PURPLE_CANDLE_LIME_CAKE, "Lime Cake with Purple Candle");
        addBlock(CRBlocks.BLUE_CANDLE_LIME_CAKE, "Lime Cake with Blue Candle");
        addBlock(CRBlocks.BROWN_CANDLE_LIME_CAKE, "Lime Cake with Brown Candle");
        addBlock(CRBlocks.GREEN_CANDLE_LIME_CAKE, "Lime Cake with Green Candle");
        addBlock(CRBlocks.RED_CANDLE_LIME_CAKE, "Lime Cake with Red Candle");
        addBlock(CRBlocks.BLACK_CANDLE_LIME_CAKE, "Lime Cake with Black Candle");
        addBlock(CRBlocks.POMEGRANATE_CAKE, "Pomegranate Cake");
        addBlock(CRBlocks.CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Candle");
        addBlock(CRBlocks.WHITE_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with White Candle");
        addBlock(CRBlocks.ORANGE_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Orange Candle");
        addBlock(CRBlocks.MAGENTA_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Magenta Candle");
        addBlock(CRBlocks.LIME_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Lime Candle");
        addBlock(CRBlocks.PINK_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Pink Candle");
        addBlock(CRBlocks.GRAY_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Gray Candle");
        addBlock(CRBlocks.LIGHT_GRAY_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Light Gray Candle");
        addBlock(CRBlocks.CYAN_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Cyan Candle");
        addBlock(CRBlocks.PURPLE_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Purple Candle");
        addBlock(CRBlocks.BLUE_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Blue Candle");
        addBlock(CRBlocks.BROWN_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Brown Candle");
        addBlock(CRBlocks.GREEN_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Green Candle");
        addBlock(CRBlocks.RED_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Red Candle");
        addBlock(CRBlocks.BLACK_CANDLE_POMEGRANATE_CAKE, "Pomegranate Cake with Black Candle");
        addBlock(CRBlocks.LIME_ICE_CREAM_BLOCK, "Lime Ice Cream Block");
        addBlock(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK, "Pomegranate Ice Cream Block");
        addBlock(CRBlocks.LIME_MILKSHAKE_CAULDRON, "Lime Milkshake Cauldron");
        addBlock(CRBlocks.POMEGRANATE_MILKSHAKE_CAULDRON, "Pomegranate Milkshake Cauldron");
        addBlock(CRBlocks.URCHIN_TEST_BLOCK, "Urchin Test Block");
        addBlock(CRBlocks.URCHIN_TEST_BRICKS, "Urchin Test Bricks");
        addBlock(CRBlocks.URCHIN_TEST_BRICK_SLAB, "Urchin Test Brick Slab");
        addBlock(CRBlocks.URCHIN_TEST_BRICK_STAIRS, "Urchin Test Brick Stairs");
        addBlock(CRBlocks.URCHIN_TEST_BRICK_WALL, "Urchin Test Brick Wall");
        addBlock(CRBlocks.CHISELED_URCHIN_TEST_BRICKS, "Chiseled Urchin Test Bricks");
        addBlock(CRBlocks.URCHIN_TEST_TILES, "Urchin Test Tiles");
        addBlock(CRBlocks.URCHIN_TEST_TILE_SLAB, "Urchin Test Tile Slab");
        addBlock(CRBlocks.URCHIN_TEST_TILE_STAIRS, "Urchin Test Tile Stairs");
        addBlock(CRBlocks.URCHIN_TEST_TILE_WALL, "Urchin Test Tile Wall");
    }

    private void addItems() {
        addItem(CRItems.BAKED_PORTOBELLO_CAP, "Baked Portobello Cap");
        addItem(CRItems.STUFFED_PORTOBELLO_CAP, "Stuffed Portobello");
        addItem(CRItems.PORTOBELLO_BURGER, "Portoburger");
        addItem(CRItems.PORTOBELLO_PASTA, "Pasta with Mushroom");
        addItem(CRItems.PORTOBELLO_RISOTTO, "Portobello Risotto");
        addItem(CRItems.PORTOBELLO_WRAP, "Veggie Wrap");
        addItem(CRItems.PORTOBELLO_RICE_SOUP, "Wild Rice Soup");
        addItem(CRItems.PORTOBELLO_QUICHE_SLICE, "Slice of Portobello Quiche");
        addItem(CRItems.LIME_PIE_SLICE, "Slice of Key Lime Pie");
        addItem(CRItems.LIME, "Lime");
        addItem(CRItems.LIME_SLICE, "Lime Slice");
        addItem(CRItems.LIME_POPSICLE, "Lime Popsicle");
        addItem(CRItems.LIME_COOKIE, "Lime Cookie");
        addItem(CRItems.CANDIED_LIME, "Candied Lime");
        addItem(CRItems.HONEY_LIME_CHICKEN, "Honey Lime Chicken");
        addItem(CRItems.COD_CEVICHE, "Cod Ceviche");
        addItem(CRItems.MEDITERRANEAN_SALMON, "Mediterranean Salmon");
        addItem(CRItems.SALMON_TARTARE, "Salmon Tartare");
        addItem(CRItems.POTATO_FRITTERS, "Potato Fritters");
        addItem(CRItems.LIMEADE, "Limeade");
        addItem(CRItems.BERRY_LIMEADE, "Berry Limeade");
        addItem(CRItems.MINT_LIMEADE, "Mint Limeade");
        addItem(CRItems.LIME_GREEN_TEA, "Lime Green Tea");
        addItem(CRItems.POMEGRANATE_BLACK_TEA, "Pomegranate Black Tea");
        addItem(CRItems.POMEGRANATE_SMOOTHIE, "Pomegranate Smoothie");
        addItem(CRItems.POMEGRANATE, "Pomegranate");
        addItem(CRItems.POMEGRANATE_SLICE, "Pomegranate Slice");
        addItem(CRItems.POMEGRANATE_MUTTON, "Pomegranate Mutton");
        addItem(CRItems.POMEGRANATE_CHICKEN, "Pomegranate Chicken");
        addItem(CRItems.POMEGRANATE_PORK, "Pomegranate Pork");
        addItem(CRItems.POMEGRANATE_CUSTARD, "Pomegranate Custard");
        addItem(CRItems.PINK_LIMEADE, "Pink Limeade");
        addItem(CRItems.SPICY_GRENADINE_JELLY, "Spicy Grenadine Jelly");
        addItem(CRItems.GLAZED_STRIDER, "Glazed Strider");
        addItem(CRItems.CRIMSON_CARROT_ROAST, "Crimson Carrot Roast");
        addItem(CRItems.DELUXE_SALAD, "Deluxe Salad");
        addItem(CRItems.LIME_CAKE_SLICE, "Slice of Lime Cake");
        addItem(CRItems.POMEGRANATE_CAKE_SLICE, "Slice of Pomegranate Cake");
        addItem(CRItems.LIME_ICE_CREAM, "Lime Ice Cream");
        addItem(CRItems.POMEGRANATE_ICE_CREAM, "Pomegranate Ice Cream");
        addItem(CRItems.LIME_MILKSHAKE, "Lime Milkshake");
        addItem(CRItems.POMEGRANATE_MILKSHAKE, "Pomegranate Milkshake");
        addItem(CRItems.CHOCOLATE_ARILS, "Chocolate Arils");
        addItem(CRItems.POMEGRANATE_BEAN_SALAD, "Pomegranate Bean Salad");
        addItem(CRItems.STRAWBERRY_JAM_BUN, "Strawberry Jam Bun");
        addItem(CRItems.LIME_GUMMY, "Lime Gummy");
        addItem(CRItems.POMEGRANATE_GUMMY, "Pomegranate Gummy");
        addItem(CRItems.MELON_GUMMY, "Melon Gummy");
        addItem(CRItems.APPLE_GUMMY, "Apple Gummy");
        addItem(CRItems.GLOW_BERRY_GUMMY, "Glow Berry Gummy");
        addItem(CRItems.BANANA_GUMMY, "Banana Gummy");
        addItem(CRItems.VANILLA_GUMMY, "Vanilla Gummy");
        addItem(CRItems.CHOCOLATE_GUMMY, "Chocolate Gummy");
        addItem(CRItems.STRAWBERRY_GUMMY, "Strawberry Gummy");
        addItem(CRItems.MINT_GUMMY, "Mint Gummy");
        addItem(CRItems.ADZUKI_GUMMY, "Adzuki Gummy");
        addItem(CRItems.PUMPKIN_GUMMY, "Pumpkin Gummy");
        addItem(CRItems.SWEET_BERRY_GUMMY, "Sweet Berry Gummy");
        addItem(CRItems.BEETROOT_GUMMY, "Beetroot Gummy");
        addItem(CRItems.ALOE_GUMMY, "Aloe Gummy");
        addItem(CRItems.PASSION_FRUIT_GUMMY, "Passion Fruit Gummy");
        addItem(CRItems.YUCCA_GUMMY, "Yucca Gummy");
        addItem(CRItems.GREEN_TEA_GUMMY, "Green Tea Gummy");
        addItem(CRItems.YELLOW_TEA_GUMMY, "Yellow Tea Gummy");
        addItem(CRItems.BLACK_TEA_GUMMY, "Black Tea Gummy");
        addItem(CRItems.COFFEE_GUMMY, "Coffee Gummy");
        addItem(CRItems.TIGER_PRAWN_SPAWN_EGG, "Spawn Tiger Prawn");
        addItem(CRItems.TIGER_PRAWN_BUCKET, "Bucket of Tiger Prawn");
        addItem(CRItems.TIGER_PRAWN, "Raw Tiger Prawn");
        addItem(CRItems.COOKED_TIGER_PRAWN, "Cooked Tiger Prawn");
        addItem(CRItems.PRAWN_ROLL, "Prawn Roll");
        addItem(CRItems.PRAWN_PO_BOY, "Prawn Po' Boy");
        addItem(CRItems.PRAWN_STEW, "Prawn Stew");
        addItem(CRItems.PRAWN_CEVICHE, "Prawn Ceviche");
        addItem(CRItems.PRAWN_NOODLES, "Prawn Noodles");
        addItem(CRItems.SALMON_WRAPPED_PRAWN, "Salmon Wrapped Prawn");
        addItem(CRItems.URCHIN_SPAWN_EGG, "Spawn Urchin");
        addItem(CRItems.URCHIN_BUCKET, "Bucket of Urchin");
        addItem(CRItems.URCHIN, "Urchin");
        addItem(CRItems.URCHIN_TEST, "Urchin Test");
        addItem(CRItems.URCHIN_NEEDLE, "Urchin Needle");
        addItem(CRItems.UNI, "Uni");
        addItem(CRItems.UNI_ROLL, "Uni Roll");
        addItem(CRItems.PLATINUM_BASS_SPAWN_EGG, "Spawn Platinum Bass");
        addItem(CRItems.PLATINUM_BASS_BUCKET, "Bucket of Platinum Bass");
        addItem(CRItems.PLATINUM_BASS, "Raw Platinum Bass");
        addItem(CRItems.COOKED_PLATINUM_BASS, "Cooked Platinum Bass");
        addItem(CRItems.PLATINUM_BASS_HEAD, "Platinum Bass Head");
        addItem(CRItems.COOKED_PLATINUM_BASS_HEAD, "Cooked Platinum Bass Head");
        addItem(CRItems.PLATINUM_BASS_SLICE, "Raw Platinum Bass Slice");
        addItem(CRItems.COOKED_PLATINUM_BASS_SLICE, "Cooked Platinum Bass Slice");
        addItem(CRItems.PLATINUM_BASS_STEW, "Platinum Bass Stew");
        addItem(CRItems.FISH_MIX, "Fish Mix");
        addItem(CRItems.CHIEFTAIN_CRAB_SPAWN_EGG, "Spawn Chieftain Crab");
        addItem(CRItems.CHIEFTAIN_CRAB_BUCKET, "Bucket of Chieftain Crab");
        addItem(CRItems.CHIEFTAIN_CRAB, "Chieftain Crab");
        addItem(CRItems.CHIEFTAIN_CLAW, "Chieftain Crab Claw");
        addItem(CRItems.CHIEFTAIN_LEG, "Chieftain Crab Leg");
        addItem(CRItems.CHIEFTAIN_CRAB_MEAT, "Chieftain Crab Meat");
        addItem(CRItems.CRAB_MISO, "Crab Miso");
        addItem(CRItems.LAND_AND_SEA_BURGER, "Land and Sea Burger");
        addItem(CRItems.CRAB_NOODLES, "Crab Noodles");
        addItem(CRItems.CRAB_LASAGNA, "Crab Lasagna");
        addItem(CRItems.BUTTERED_LEGS, "Buttered Legs");
        addItem(CRItems.BIG_RICE_BALL, "Big Rice Ball");
        addItem(CRItems.LUNAR_PEARL, "Lunar Pearl");
        addItem(CRItems.CLAM_SPAWN_EGG, "Spawn Tide Clam");
        addItem(CRItems.CLAM_BUCKET, "Bucket of Tide Clam");
        addItem(CRItems.CLAM, "Tide Clam");
        addItem(CRItems.CLAM_MEAT, "Tide Clam Meat");
        addItem(CRItems.CLAM_ROLL, "Clam Roll");
        addItem(CRItems.CLAM_CHOWDER, "Clam Chowder");
        addItem(CRItems.CLAM_PASTA, "Pasta with Clams");
        addItem(CRItems.CLAM_MEATBALL_STEW, "Clam and Meatball Stew");
        addItem(CRItems.SEA_WRAP, "Sea Wrap");
    }
}
