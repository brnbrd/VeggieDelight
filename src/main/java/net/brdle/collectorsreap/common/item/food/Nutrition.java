package net.brdle.collectorsreap.common.item.food;

import net.brdle.collectorsreap.common.effect.CREffects;
import net.brdle.collectorsreap.compat.ModCompat;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class Nutrition {
	public static final FoodProperties LIME = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.2F)
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 100, 0), 1.0F).build();
	public static final FoodProperties LIME_SLICE = (new FoodProperties.Builder())
			.nutrition(1).saturationMod(0.2F).fast()
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 60, 0), 1.0F).build();
	public static final FoodProperties LIME_PIE_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2F).build();
	public static final FoodProperties LIME_POPSICLE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2F).fast()
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 900, 0), 1.0F).build();
	public static final FoodProperties LIME_COOKIE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2F)
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 300, 0), 1.0F).build();
	public static final FoodProperties HONEY_LIME_CHICKEN = (new FoodProperties.Builder())
			.nutrition(14).saturationMod(0.78F)
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 400, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties MEDITERRANEAN_SALMON = (new FoodProperties.Builder())
			.nutrition(14).saturationMod(0.78F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties SALMON_TARTARE = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.67F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties POTATO_FRITTERS = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(1.0F)
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 600, 0), 1.0F).build();
	public static final FoodProperties CANDIED_LIME = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(1.0F).fast()
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 200, 0), 1.0F).build();
	public static final FoodProperties COD_CEVICHE = (new FoodProperties.Builder())
			.nutrition(11).saturationMod(0.73F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties POMEGRANATE_SLICE = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.5F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 200, 0), 1.0F).build();
	public static final FoodProperties STYGIAN_POMEGRANATE = (new FoodProperties.Builder())
		.nutrition(10).saturationMod(0.4F)
		.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 400, 4), 1.0F)
		.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1.0F)
		.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0), 1.0F)
		.effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 180, 1), 1.0F)
		.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 180, 1), 1.0F).build();
	public static final FoodProperties POMEGRANATE_SEEDS = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.5F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 100, 0), 1.0F).build();
	public static final FoodProperties BAKED_PORTOBELLO_CAP = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.75F).build();
	public static final FoodProperties STUFFED_PORTOBELLO_CAP = (new FoodProperties.Builder())
			.nutrition(10).saturationMod(0.8F).build();
	public static final FoodProperties PORTOBELLO_RICE_SOUP = (new FoodProperties.Builder())
			.nutrition(14).saturationMod(0.8F)
			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties PORTOBELLO_RISOTTO = (new FoodProperties.Builder())
			.nutrition(12).saturationMod(0.83F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties PORTOBELLO_PASTA = (new FoodProperties.Builder())
			.nutrition(13).saturationMod(0.8F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties PORTOBELLO_WRAP = (new FoodProperties.Builder())
			.nutrition(10).saturationMod(0.8F).build();
	public static final FoodProperties PORTOBELLO_QUICHE_SLICE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.2F).build();
	public static final FoodProperties PORTOBELLO_BURGER = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F)
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0F).build();
	public static final FoodProperties CRIMSON_CARROT_ROAST = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.5F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 400, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties POMEGRANATE_MUTTON = (new FoodProperties.Builder())
			.nutrition(14).saturationMod(0.78F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties POMEGRANATE_PORK = (new FoodProperties.Builder())
			.nutrition(16).saturationMod(0.81F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties POMEGRANATE_CHICKEN = (new FoodProperties.Builder())
			.nutrition(14).saturationMod(0.78F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties POMEGRANATE_CUSTARD = (new FoodProperties.Builder())
			.nutrition(8).saturationMod(0.65F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 400, 0), 1.0F).build();
	public static final FoodProperties GLAZED_STRIDER = (new FoodProperties.Builder())
			.nutrition(10).saturationMod(0.8F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
	public static final FoodProperties SPICY_GRENADINE_JELLY = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(2.33F)
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1800, 0), 1.0F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0), 1.0F).build();
	public static final FoodProperties LIMEADE = (new FoodProperties.Builder())
			.alwaysEat()
			.nutrition(3).saturationMod(0.2F)
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 900, 0), 1.0F)
			.build();
	public static final FoodProperties BERRY_LIMEADE = (new FoodProperties.Builder())
			.alwaysEat()
			.nutrition(5).saturationMod(0.2F)
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 900, 0), 1.0F)
			.build();
	public static final FoodProperties PINK_LIMEADE = (new FoodProperties.Builder())
			.alwaysEat()
			.nutrition(5).saturationMod(1.0F)
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 900, 0), 1.0F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 900, 0), 1.0F)
			.build();
	public static final FoodProperties MINT_LIMEADE = (new FoodProperties.Builder())
			.alwaysEat()
			.nutrition(6).saturationMod(0.33F)
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 900, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModCompat.getBerserking().get(), 900, 0), 1.0F)
			.build();
	public static final FoodProperties LIME_GREEN_TEA = (new FoodProperties.Builder())
			.alwaysEat()
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 1200, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModCompat.getVitality().get(), 1200, 0), 1.0F)
			.build();
	public static final FoodProperties POMEGRANATE_BLACK_TEA = (new FoodProperties.Builder())
			.alwaysEat()
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1200, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModCompat.getMaturity().get(), 1200, 0), 1.0F)
			.build();
	public static final FoodProperties POMEGRANATE_SMOOTHIE = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.166F)
			.alwaysEat()
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 600, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModCompat.getAgility().get(), 600, 0), 1.0F)
			.build();
	public static final FoodProperties DELUXE_SALAD = (new FoodProperties.Builder())
			.nutrition(10).saturationMod(0.75F)
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 600, 0), 1.0F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 600, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 600, 0), 1.0F)
			.build();
	public static final FoodProperties LIME_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.1F)
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 200, 0), 1.0F)
			.build();
	public static final FoodProperties POMEGRANATE_CAKE_SLICE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.1F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 300, 0), 1.0F)
			.build();
	public static final FoodProperties LIME_ICE_CREAM = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.4F)
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 1200, 1), 1.0F)
			.build();
	public static final FoodProperties LIME_MILKSHAKE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(1.5F).alwaysEat()
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 600, 1), 1.0F).build();
	public static final FoodProperties POMEGRANATE_ICE_CREAM = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.4F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 1600, 1), 1.0F)
			.build();
	public static final FoodProperties POMEGRANATE_MILKSHAKE = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(1.5F).alwaysEat()
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 800, 1), 1.0F).build();
	public static final FoodProperties STRAWBERRY_JAM_BUN = (new FoodProperties.Builder())
			.nutrition(6).saturationMod(0.5F)
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 400, 0), 1.0F)
			.build();
	public static final FoodProperties POMEGRANATE_BEAN_SALAD = (new FoodProperties.Builder())
			.nutrition(8).saturationMod(0.375F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 400, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModCompat.getHarmony().get(), 400, 0), 1.0F).build();
	public static final FoodProperties CHOCOLATE_ARILS = (new FoodProperties.Builder())
			.nutrition(4).saturationMod(0.25F)
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 200, 1), 1.0F)
			.effect(() -> new MobEffectInstance(ModCompat.getSugarRush().get(), 200, 1), 1.0F).build();

	// Gummies
	public static final FoodProperties LIME_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(CREffects.CORROSION.get(), 100, 2), 1.0F).build();
	public static final FoodProperties POMEGRANATE_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(CREffects.VOLATILITY.get(), 100, 2), 1.0F).build();
	public static final FoodProperties MELON_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 0), 1.0F).build();
	public static final FoodProperties APPLE_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 200, 0), 1.0F).build();
	public static final FoodProperties GLOW_BERRY_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 600, 0), 1.0F).build();
	public static final FoodProperties BANANA_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getAgility().get(), 200, 0), 1.0F)
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 200, 2), 1.0F).build();
	public static final FoodProperties VANILLA_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getVanillaScent().get(), 100, 0), 1.0F).build();
	public static final FoodProperties CHOCOLATE_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getSugarRush().get(), 200, 4), 1.0F).build();
	public static final FoodProperties STRAWBERRY_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat().build();
	public static final FoodProperties MINT_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getBerserking().get(), 300, 0), 1.0F)
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0), 1.0F).build();
	public static final FoodProperties ADZUKI_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getHarmony().get(), 40, 2), 1.0F).build();
	public static final FoodProperties PUMPKIN_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getStuffed().get(), 600, 0), 1.0F)
			.effect(() -> new MobEffectInstance(MobEffects.SATURATION, 200, 0), 1.0F).build();
	public static final FoodProperties SWEET_BERRY_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getThornResistance().get(), 1200, 0), 1.0F).build();
	public static final FoodProperties BEETROOT_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getRooted().get(), 1200, 0), 1.0F).build();
	public static final FoodProperties ALOE_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getRelief().get(), 200, 3), 1.0F).build();
	public static final FoodProperties PASSION_FRUIT_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getSpitting().get(), 40, 3), 1.0F).build();
	public static final FoodProperties YUCCA_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getPersistence().get(), 200, 3), 1.0F).build();
	public static final FoodProperties GREEN_TEA_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getVitality().get(), 200, 2), 1.0F).build();
	public static final FoodProperties YELLOW_TEA_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getTenacity().get(), 200, 2), 1.0F).build();
	public static final FoodProperties BLACK_TEA_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getMaturity().get(), 200, 2), 1.0F).build();
	public static final FoodProperties COFFEE_GUMMY = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.0F).alwaysEat()
			.effect(() -> new MobEffectInstance(ModCompat.getCaffeinated().get(), 400, 3), 1.0F).build();
	public static final FoodProperties TIGER_PRAWN = (new FoodProperties.Builder())
			.nutrition(2).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.75F).build();
	public static final FoodProperties COOKED_TIGER_PRAWN = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.6F).build();
	public static final FoodProperties PRAWN_ROLL = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.6F).build();
	public static final FoodProperties SALMON_WRAPPED_PRAWN = (new FoodProperties.Builder())
			.nutrition(9).saturationMod(0.95F).build();
	public static final FoodProperties PRAWN_PO_BOY = (new FoodProperties.Builder())
			.nutrition(10).saturationMod(0.85F).build();
	public static final FoodProperties PRAWN_STEW = (new FoodProperties.Builder())
			.nutrition(10).saturationMod(0.85F).build();
	public static final FoodProperties PRAWN_CEVICHE = (new FoodProperties.Builder())
			.nutrition(8).saturationMod(0.85F).build();
	public static final FoodProperties PRAWN_NOODLES = (new FoodProperties.Builder())
			.nutrition(12).saturationMod(0.95F).build();
	public static final FoodProperties UNI = (new FoodProperties.Builder())
			.nutrition(5).saturationMod(0.6F).build();
	public static final FoodProperties UNI_ROLL = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.6F).build();
	public static final FoodProperties PLATINUM_BASS = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).build();
	public static final FoodProperties COOKED_PLATINUM_BASS = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.85F).build();
	public static final FoodProperties PLATINUM_BASS_HEAD = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
	public static final FoodProperties COOKED_PLATINUM_BASS_HEAD = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.85F).build();
	public static final FoodProperties PLATINUM_BASS_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
	public static final FoodProperties COOKED_PLATINUM_BASS_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.85F).build();
	public static final FoodProperties PLATINUM_BASS_STEW = (new FoodProperties.Builder()).nutrition(14).saturationMod(1.25F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F)
			.build();
	public static final FoodProperties FISH_MIX = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.85F).build();
	public static final FoodProperties CHIEFTAIN_CLAW = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final FoodProperties CHIEFTAIN_LEG = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).build();
	public static final FoodProperties CHIEFTAIN_CRAB_MEAT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).build();
	public static final FoodProperties CRAB_MISO = (new FoodProperties.Builder()).nutrition(9).saturationMod(1.0F).build();
	public static final FoodProperties CRAB_NOODLES = (new FoodProperties.Builder()).nutrition(13).saturationMod(0.95F).build();
	public static final FoodProperties CRAB_LASAGNA = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.7F).build();
	public static final FoodProperties BUTTERED_LEGS = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.75F).build();
	public static final FoodProperties BIG_RICE_BALL = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.9F).build();
	public static final FoodProperties LAND_AND_SEA_BURGER = (new FoodProperties.Builder())
			.nutrition(15).saturationMod(0.85F)
			.effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F)
			.effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1.0F)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1.0F).build();
	public static final FoodProperties CLAM_MEAT = (new FoodProperties.Builder())
			.nutrition(3).saturationMod(0.3F).build();
	public static final FoodProperties CLAM_ROLL = (new FoodProperties.Builder())
			.nutrition(7).saturationMod(0.5F).build();
	public static final FoodProperties CLAM_CHOWDER = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.85F).build();
	public static final FoodProperties CLAM_PASTA = (new FoodProperties.Builder()).nutrition(11).saturationMod(0.85F).build();
	public static final FoodProperties CLAM_MEATBALL_STEW = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.85F).build();
	public static final FoodProperties SEA_WRAP = (new FoodProperties.Builder()).nutrition(14).saturationMod(1.0F).build();
	public static final FoodProperties SHIMMERING_APPLE = (new FoodProperties.Builder()).nutrition(8).saturationMod(1.25F).build();
}