package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.crafting.EnabledCondition;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRItemTags;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import java.util.function.Consumer;

public class CRRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public CRRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> finished) {
        // Smelting
        foodSmeltingRecipes("baked_portobello_cap", CRItems.PORTOBELLO.get(), CRItems.BAKED_PORTOBELLO_CAP.get(), 0.35F, finished);
        foodSmeltingRecipes("platinum_bass", CRItems.PLATINUM_BASS.get(), CRItems.COOKED_PLATINUM_BASS.get(), 0.35F, finished);
        foodSmeltingRecipes("platinum_bass_head", CRItems.PLATINUM_BASS_HEAD.get(), CRItems.COOKED_PLATINUM_BASS_HEAD.get(), 0.35F, finished);
        foodSmeltingRecipes("platinum_bass_slice", CRItems.PLATINUM_BASS_SLICE.get(), CRItems.COOKED_PLATINUM_BASS_SLICE.get(), 0.35F, finished);
        foodSmeltingRecipes("tiger_prawn", CRItems.TIGER_PRAWN.get(), CRItems.COOKED_TIGER_PRAWN.get(), 0.35F, finished);

        // Cutting
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.PORTOBELLO_QUICHE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.PORTOBELLO_QUICHE_SLICE.get(), 4),
            "cutting/portobello_quiche", finished, enabled(CRItems.PORTOBELLO), enabled(CRItems.PORTOBELLO_QUICHE));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.PORTOBELLO_COLONY.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.PORTOBELLO.get(), 5),
            "cutting/portobello_colony", finished, enabled(CRItems.PORTOBELLO));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.LIME.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.LIME_SLICE.get(), 2)
            .addResultWithChance(Items.LIME_DYE, 0.5f),
            "cutting/lime", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_SLICE));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.LIME_SLICE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            Items.LIME_DYE, 1),
            "cutting/lime_slice", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_SLICE));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.LIME_PIE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.LIME_PIE_SLICE.get(), 4),
            "cutting/lime_pie", finished, enabled(CRItems.LIME_PIE), enabled(CRItems.LIME_PIE_SLICE));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.POMEGRANATE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.POMEGRANATE_SLICE.get(), 4)
            .addResultWithChance(Items.RED_DYE, 0.5f),
            "cutting/pomegranate", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_SEEDS));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.LIME_CAKE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.LIME_CAKE_SLICE.get(), 7),
            "cutting/lime_cake", finished, enabled(CRItems.LIME_CAKE), enabled(CRItems.LIME_CAKE_SLICE));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.POMEGRANATE_CAKE.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.POMEGRANATE_CAKE_SLICE.get(), 7),
            "cutting/pomegranate_cake", finished, enabled(CRItems.POMEGRANATE_CAKE), enabled(CRItems.POMEGRANATE_CAKE_SLICE));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.URCHIN.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.UNI.get(), 2)
            .addResult(CRItems.URCHIN_TEST.get())
            .addResult(CRItems.URCHIN_NEEDLE.get(), 6),
            "cutting/urchin", finished, enabled(CRItems.URCHIN), enabled(CRItems.UNI));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.PLATINUM_BASS.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.PLATINUM_BASS_SLICE.get(), 3)
            .addResult(CRItems.PLATINUM_BASS_HEAD.get()),
            "cutting/platinum_bass", finished, enabled(CRItems.PLATINUM_BASS), enabled(CRItems.PLATINUM_BASS_SLICE));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.CHIEFTAIN_CRAB.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.CHIEFTAIN_CLAW.get(), 1)
            .addResult(CRItems.CHIEFTAIN_LEG.get(), 4)
            .addResult(CRItems.CHIEFTAIN_CRAB_MEAT.get(), 2)
            .addResult(CRItems.CRAB_MISO.get()),
            "cutting/chieftain_crab", finished, enabled(CRItems.CHIEFTAIN_CRAB));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.CHIEFTAIN_CLAW.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.CHIEFTAIN_CRAB_MEAT.get(), 3),
            "cutting/chieftain_claw", finished, enabled(CRItems.CHIEFTAIN_CLAW), enabled(CRItems.CHIEFTAIN_CRAB_MEAT));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.CHIEFTAIN_LEG.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.CHIEFTAIN_CRAB_MEAT.get(), 2),
            "cutting/chieftain_legs", finished, enabled(CRItems.CHIEFTAIN_LEG), enabled(CRItems.CHIEFTAIN_CRAB_MEAT));
        wrap(CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CRItems.CLAM.get()), Ingredient.of(ForgeTags.TOOLS_KNIVES),
            CRItems.CLAM_MEAT.get(), 2)
            .addResultWithChance(CRItems.CLAM_MEAT.get(), 0.5f)
            .addResultWithChance(CRItems.LUNAR_PEARL.get(), 0.1f),
            "cutting/clam", finished, enabled(CRItems.CLAM), enabled(CRItems.CLAM_MEAT));

        // Cooking Pot
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PORTOBELLO_RISOTTO.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItems.BAKED_PORTOBELLO_CAP.get())
                .addIngredient(ForgeTags.CROPS_RICE)
                .addIngredient(ForgeTags.MILK)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_risotto", finished, enabled("portobello_risotto"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PORTOBELLO_RICE_SOUP.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItems.BAKED_PORTOBELLO_CAP.get())
                .addIngredient(ForgeTags.CROPS_RICE)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.VEGETABLES_CARROT)
                .addIngredient(Items.DRIED_KELP)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_rice_soup", finished, enabled("portobello_rice_soup"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.STUFFED_PORTOBELLO_CAP.get(), 1, 200, 1.0F, CRItems.BAKED_PORTOBELLO_CAP.get())
                .addIngredient(Items.BROWN_MUSHROOM)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/stuffed_portobello_cap", finished, enabled("stuffed_portobello_cap"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PORTOBELLO_PASTA.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItems.BAKED_PORTOBELLO_CAP.get())
                .addIngredient(ForgeTags.PASTA)
                .addIngredient(Items.BROWN_MUSHROOM)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.MILK)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_pasta", finished, enabled("portobello_pasta"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.HONEY_LIME_CHICKEN.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(ForgeTags.RAW_CHICKEN)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(CRItemTags.LIME_OR_SLICE)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.CROPS_RICE)
                .unlockedBy("has_lime_or_slice", has(CRItemTags.LIME_OR_SLICE)),
            "food/honey_lime_chicken", finished, enabled("honey_lime_chicken"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.MEDITERRANEAN_SALMON.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(ForgeTags.RAW_FISHES_SALMON)
                .addIngredient(CRItemTags.LIME_OR_SLICE)
                .addIngredient(Tags.Items.CROPS_POTATO)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedBy("has_lime_or_slice", has(CRItemTags.LIME_OR_SLICE)),
            "food/mediterranean_salmon", finished, enabled("mediterranean_salmon"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POTATO_FRITTERS.get(), 1, 200, 1.0F)
                .addIngredient(Items.BAKED_POTATO)
                .addIngredient(Ingredient.of(CRItemTags.LIME_OR_SLICE), 2)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedBy("has_lime_or_slice", has(CRItemTags.LIME_OR_SLICE)),
            "food/potato_fritters", finished, enabled("potato_fritters"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CANDIED_LIME.get(), 3, 200, 1.0F)
                .addIngredient(CRItems.LIME_SLICE.get(), 3)
                .addIngredient(Items.HONEY_BOTTLE)
                .unlockedBy("has_lime_slice", has(CRItems.LIME_SLICE.get())),
            "food/candied_lime", finished, enabled("candied_lime"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CRIMSON_CARROT_ROAST.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(Items.CARROT)
                .addIngredient(CRItemTags.FRUITS_POMEGRANATE)
                .addIngredient(Items.CRIMSON_FUNGUS)
                .addIngredient(Items.WARPED_ROOTS)
                .unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
            "food/crimson_carrot_roast", finished, enabled(CRItems.CRIMSON_CARROT_ROAST));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POMEGRANATE_MUTTON.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(ForgeTags.RAW_MUTTON)
                .addIngredient(CRItemTags.FRUITS_POMEGRANATE)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(Items.WARPED_FUNGUS)
                .unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
            "food/pomegranate_mutton", finished, enabled(CRItems.POMEGRANATE_MUTTON));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POMEGRANATE_PORK.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(ForgeTags.RAW_PORK)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(CRItemTags.FRUITS_POMEGRANATE)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(Items.CARROT)
                .unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
            "food/pomegranate_pork", finished, enabled(CRItems.POMEGRANATE_PORK));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POMEGRANATE_PORK.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItemTags.HOGLIN_LOIN)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(CRItemTags.FRUITS_POMEGRANATE)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(Items.CARROT)
                .unlockedBy("has_hoglin_loin", has(CRItemTags.HOGLIN_LOIN)),
            "food/pomegranate_pork_from_hoglin", finished, enabled(CRItems.POMEGRANATE_PORK), not(tagEmpty(CRItemTags.HOGLIN_LOIN)));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POMEGRANATE_CHICKEN.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(ForgeTags.RAW_CHICKEN)
                .addIngredient(CRItemTags.FRUITS_POMEGRANATE)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(Items.CRIMSON_FUNGUS)
                .addIngredient(Items.WARPED_FUNGUS)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
            "food/pomegranate_chicken", finished, enabled(CRItems.POMEGRANATE_CHICKEN));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POMEGRANATE_CUSTARD.get(), 1, 200, 1.0F, Items.GLASS_BOTTLE)
                .addIngredient(CRItemTags.FRUITS_POMEGRANATE)
                .addIngredient(ForgeTags.MILK)
                .addIngredient(ForgeTags.EGGS)
                .addIngredient(Items.SUGAR)
                .unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
            "food/pomegranate_custard", finished, enabled(CRItems.POMEGRANATE_CUSTARD));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.GLAZED_STRIDER.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItemTags.RAW_STRIDER)
                .addIngredient(CRItemTags.FRUITS_POMEGRANATE)
                .addIngredient(Items.CRIMSON_FUNGUS)
                .addIngredient(Items.CRIMSON_ROOTS)
                .unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
            "food/glazed_strider", finished, enabled(CRItems.GLAZED_STRIDER), not(tagEmpty(CRItemTags.RAW_STRIDER)));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.SPICY_GRENADINE_JELLY.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(Ingredient.of(CRItemTags.PROPELPEARL), 2)
                .addIngredient(Items.MAGMA_CREAM, 2)
                .addIngredient(CRItemTags.FRUITS_POMEGRANATE)
                .unlockedBy("has_pomegranate_slice", has(CRItemTags.FRUITS_POMEGRANATE)),
            "food/spicy_grenadine_jelly", finished, enabled(CRItems.SPICY_GRENADINE_JELLY), not(tagEmpty(CRItemTags.PROPELPEARL)));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CHIEFTAIN_CRAB.get(), 1, 600, 6.0F, Items.BOWL)
                .addIngredient(CRItems.CHIEFTAIN_CRAB_BUCKET.get())
                .addIngredient(ForgeTags.VEGETABLES_CARROT)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .addIngredient(Items.DRIED_KELP)
                .unlockedBy("has_crab_bucket", has(CRItems.CHIEFTAIN_CRAB_BUCKET.get())),
            "food/chieftain_crab", finished, enabled("chieftain_crab"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CRAB_LASAGNA.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(Ingredient.of(CRItemTags.CRAB_MEAT), 3)
                .addIngredient(ForgeTags.DOUGH)
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .addIngredient(ForgeTags.MILK)
                .unlockedBy("has_crab_meat", has(CRItemTags.CRAB_MEAT)),
            "food/crab_lasagna", finished, enabled(CRItems.CRAB_LASAGNA));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CRAB_NOODLES.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(Ingredient.of(CRItemTags.CRAB_MEAT), 2)
                .addIngredient(ForgeTags.PASTA)
                .addIngredient(ForgeTags.MILK)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedBy("has_crab_meat", has(CRItemTags.CRAB_MEAT)),
            "food/crab_noodles", finished, enabled(CRItems.CRAB_NOODLES));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.BUTTERED_LEGS.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItems.CHIEFTAIN_LEG.get(), 3)
                .addIngredient(ForgeTags.MILK)
                .unlockedBy("has_chieftain_legs", has(CRItems.CHIEFTAIN_LEG.get())),
            "food/buttered_legs", finished, enabled(CRItems.BUTTERED_LEGS));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CLAM_CHOWDER.get(), 1, 200, 1.0F, Items.BREAD)
                .addIngredient(CRItemTags.RAW_CLAM)
                .addIngredient(ForgeTags.MILK)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(Items.DRIED_KELP)
                .unlockedBy("has_clam_meat", has(CRItems.CLAM_MEAT.get())),
            "food/clam_chowder", finished, enabled(CRItems.CLAM_CHOWDER));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CLAM_PASTA.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItemTags.RAW_CLAM)
                .addIngredient(ForgeTags.PASTA)
                .addIngredient(ForgeTags.MILK)
                .addIngredient(ForgeTags.EGGS)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .addIngredient(ForgeTags.CROPS_ONION)
                .unlockedBy("has_clam_meat", has(CRItems.CLAM_MEAT.get())),
            "food/clam_pasta", finished, enabled(CRItems.CLAM_PASTA));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CLAM_MEATBALL_STEW.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItemTags.RAW_CLAM)
                .addIngredient(ModItems.MINCED_BEEF.get())
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .addIngredient(ForgeTags.VEGETABLES_CARROT)
                .addIngredient(ForgeTags.COOKED_EGGS)
                .unlockedBy("has_clam_meat", has(CRItems.CLAM_MEAT.get())),
            "food/clam_meatball_stew", finished, enabled(CRItems.CLAM_MEATBALL_STEW));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PRAWN_NOODLES.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItemTags.COOKED_PRAWN)
                .addIngredient(ForgeTags.PASTA)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(Items.DRIED_KELP)
                .unlockedBy("has_cooked_prawn", has(CRItemTags.COOKED_PRAWN)),
            "food/prawn_noodles", finished, enabled(CRItems.PRAWN_NOODLES));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PRAWN_STEW.get(), 1, 200, 1.0F, Items.BOWL)
                .addIngredient(CRItemTags.COOKED_PRAWN)
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .addIngredient(ForgeTags.MILK)
                .addIngredient(ForgeTags.EGGS)
                .addIngredient(ForgeTags.VEGETABLES_POTATO)
                .unlockedBy("has_cooked_prawn", has(CRItemTags.COOKED_PRAWN)),
            "food/prawn_stew", finished, enabled(CRItems.PRAWN_STEW));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.SALMON_WRAPPED_PRAWN.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.COOKED_PRAWN)
                .addIngredient(ModItems.SALMON_SLICE.get())
                .addIngredient(CRItemTags.LIME_OR_SLICE)
                .addIngredient(Items.HONEY_BOTTLE)
                .unlockedBy("has_cooked_prawn", has(CRItemTags.COOKED_PRAWN)),
            "food/salmon_wrapped_prawn", finished, enabled(CRItems.SALMON_WRAPPED_PRAWN));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PLATINUM_BASS_STEW.get(), 1, 200, 1.0F)
                .addIngredient(CRItems.PLATINUM_BASS_HEAD.get())
                .addIngredient(CRItems.PLATINUM_BASS_SLICE.get())
                .addIngredient(CRItems.COOKED_RICE.get())
                .addIngredient(CRItemTags.LIME_OR_SLICE)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(Items.DRIED_KELP)
                .unlockedBy("has_platinum_bass_head", has(CRItems.PLATINUM_BASS_HEAD.get())),
            "food/platinum_bass_stew", finished, enabled(CRItems.PLATINUM_BASS_STEW));

            // Gummies
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.LIME_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.FRUITS_LIME)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
            "gummy/lime", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_GUMMY));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.POMEGRANATE_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.FRUITS_POMEGRANATE)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_pomegranate", has(CRItemTags.FRUITS_POMEGRANATE)),
            "gummy/pomegranate", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_GUMMY));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.MELON_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(Items.MELON_SLICE)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_melon", has(Items.MELON_SLICE)),
            "gummy/melon", finished, enabled(CRItems.MELON_GUMMY));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.APPLE_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(Items.APPLE)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_apple", has(Items.APPLE)),
            "gummy/apple", finished, enabled(CRItems.APPLE_GUMMY));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.BANANA_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.BANANA)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_banana", has(CRItemTags.BANANA)),
            "gummy/banana", finished, enabled(CRItems.BANANA_GUMMY), not(tagEmpty(CRItemTags.BANANA)), modLoaded("neapolitan"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.VANILLA_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.DRIED_VANILLA_PODS)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_vanilla", has(CRItemTags.DRIED_VANILLA_PODS)),
            "gummy/vanilla", finished, enabled(CRItems.VANILLA_GUMMY), not(tagEmpty(CRItemTags.DRIED_VANILLA_PODS)), modLoaded("neapolitan"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.CHOCOLATE_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.CHOCOLATE_BAR)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_chocolate", has(CRItemTags.CHOCOLATE_BAR)),
            "gummy/chocolate", finished, enabled(CRItems.CHOCOLATE_GUMMY), not(tagEmpty(CRItemTags.CHOCOLATE_BAR)), modLoaded("neapolitan"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.STRAWBERRY_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.RED_STRAWBERRIES)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_strawberries", has(CRItemTags.RED_STRAWBERRIES)),
            "gummy/strawberry", finished, enabled(CRItems.STRAWBERRY_GUMMY), not(tagEmpty(CRItemTags.RED_STRAWBERRIES)), modLoaded("neapolitan"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.MINT_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.MINT_LEAVES)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_mint", has(CRItemTags.MINT_LEAVES)),
            "gummy/mint", finished, enabled(CRItems.MINT_GUMMY), not(tagEmpty(CRItemTags.MINT_LEAVES)), modLoaded("neapolitan"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.ADZUKI_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.ROASTED_ADZUKI_BEANS)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_adzuki", has(CRItemTags.ROASTED_ADZUKI_BEANS)),
            "gummy/adzuki", finished, enabled(CRItems.ADZUKI_GUMMY), not(tagEmpty(CRItemTags.ROASTED_ADZUKI_BEANS)), modLoaded("neapolitan"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.GREEN_TEA_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.TEA_LEAVES_GREEN)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_green_tea", has(CRItemTags.TEA_LEAVES_GREEN)),
            "gummy/green_tea", finished, enabled(CRItems.GREEN_TEA_GUMMY), not(tagEmpty(CRItemTags.TEA_LEAVES_GREEN)), modLoaded("farmersrespite"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.YELLOW_TEA_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.TEA_LEAVES_YELLOW)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_yellow_tea", has(CRItemTags.TEA_LEAVES_YELLOW)),
            "gummy/yellow_tea", finished, enabled(CRItems.YELLOW_TEA_GUMMY), not(tagEmpty(CRItemTags.TEA_LEAVES_YELLOW)), modLoaded("farmersrespite"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.BLACK_TEA_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.TEA_LEAVES_BLACK)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_black_tea", has(CRItemTags.TEA_LEAVES_BLACK)),
            "gummy/black_tea", finished, enabled(CRItems.BLACK_TEA_GUMMY), not(tagEmpty(CRItemTags.TEA_LEAVES_BLACK)), modLoaded("farmersrespite"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.COFFEE_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.COFFEE_BEANS)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_coffee_beans", has(CRItemTags.COFFEE_BEANS)),
            "gummy/coffee", finished, enabled(CRItems.COFFEE_GUMMY), not(tagEmpty(CRItemTags.COFFEE_BEANS)), modLoaded("farmersrespite"));

        /*wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PUMPKIN_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.ROASTED_PUMPKIN)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_roasted_pumpkin", has(CRItemTags.ROASTED_PUMPKIN)),
            "food/pumpkin_gummy", finished, enabled(CRItems.PUMPKIN_GUMMY), not(tagEmpty(CRItemTags.ROASTED_PUMPKIN)), modLoaded("seasonals"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.ALOE_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.ALOE_LEAVES)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_aloe", has(CRItemTags.ALOE_LEAVES)),
            "food/aloe_gummy", finished, enabled(CRItems.ALOE_GUMMY), not(tagEmpty(CRItemTags.ALOE_LEAVES)), modLoaded("atmospheric"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.PASSIONFRUIT_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.PASSIONFRUIT)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_passionfruit", has(CRItemTags.PASSIONFRUIT)),
            "food/passionfruit_gummy", finished, enabled(CRItems.PASSIONFRUIT_GUMMY), not(tagEmpty(CRItemTags.PASSIONFRUIT)), modLoaded("atmospheric"));
        wrap(CookingPotRecipeBuilder.cookingPotRecipe(CRItems.YUCCA_GUMMY.get(), 1, 200, 1.0F)
                .addIngredient(CRItemTags.YUCCA_FRUIT)
                .addIngredient(Items.SUGAR)
                .addIngredient(Items.HONEY_BOTTLE)
                .addIngredient(Items.KELP)
                .unlockedBy("has_yucca", has(CRItemTags.YUCCA_FRUIT)),
            "food/yucca_gummy", finished, enabled(CRItems.YUCCA_GUMMY), not(tagEmpty(CRItemTags.YUCCA_FRUIT)), modLoaded("atmospheric"));*/

        // Crafting
        wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRItems.LIME, 9)
                .requires(CRItems.LIME_CRATE.get())
                .unlockedBy("has_lime_crate", has(CRItems.LIME_CRATE.get())),
            "lime_from_lime_crate", finished, enabled("lime"), enabled("lime_crate"));
        wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRItems.LIME_CRATE)
                .requires(CRItems.LIME.get(), 9)
                .unlockedBy("has_lime", has(CRItems.LIME.get())),
            "lime_crate", finished, enabled("lime"), enabled("lime_crate"));
        wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRItems.POMEGRANATE, 9)
                .requires(CRItems.POMEGRANATE_CRATE.get())
                .unlockedBy("has_pomegranate_crate", has(CRItems.POMEGRANATE_CRATE.get())),
            "pomegranate_from_pomegranate_crate", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_CRATE));
        wrap(shapeless(RecipeCategory.BUILDING_BLOCKS, CRItems.POMEGRANATE_CRATE)
                .requires(CRItems.POMEGRANATE.get(), 9)
                .unlockedBy("has_pomegranate", has(CRItems.POMEGRANATE.get())),
            "pomegranate_crate", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_CRATE));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.POMEGRANATE_SEEDS, 8)
                .requires(CRItems.POMEGRANATE.get())
                .unlockedBy("has_pomegranate", has(CRItems.POMEGRANATE.get())),
            "pomegranate_seeds_from_pomegranate", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_SEEDS));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.POMEGRANATE_SEEDS, 2)
                .requires(CRItems.POMEGRANATE_SLICE.get())
                .unlockedBy("has_pomegranate_slice", has(CRItems.POMEGRANATE_SLICE.get())),
            "pomegranate_seeds_from_pomegranate_slice", finished, enabled(CRItems.POMEGRANATE), enabled(CRItems.POMEGRANATE_SLICE), enabled(CRItems.POMEGRANATE_SEEDS));
        wrap(shapeless(RecipeCategory.MISC, CRItems.LIME_SEEDS, 2)
                .requires(CRItems.LIME.get())
                .unlockedBy("has_lime", has(CRItems.LIME.get())),
            "lime_seeds_from_lime", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_SEEDS));
        wrap(shapeless(RecipeCategory.MISC, CRItems.LIME_SEEDS)
                .requires(CRItems.LIME_SLICE.get())
                .unlockedBy("has_lime_slice", has(CRItems.LIME_SLICE.get())),
            "lime_seeds_from_slice", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_SLICE), enabled(CRItems.LIME_SEEDS));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.PORTOBELLO_WRAP)
                .requires(ForgeTags.BREAD)
                .requires(CRItems.BAKED_PORTOBELLO_CAP.get())
                .requires(ForgeTags.CROPS_ONION)
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.VEGETABLES_CARROT)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_wrap", finished, enabled(CRItems.PORTOBELLO), enabled(CRItems.PORTOBELLO_WRAP), tagEmpty(CRItemTags.TORTILLA));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.PORTOBELLO_WRAP)
                .requires(CRItemTags.TORTILLA)
                .requires(CRItems.BAKED_PORTOBELLO_CAP.get())
                .requires(ForgeTags.CROPS_ONION)
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.VEGETABLES_CARROT)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_wrap_from_tortilla", finished, enabled(CRItems.PORTOBELLO), enabled(CRItems.PORTOBELLO_WRAP), not(tagEmpty(CRItemTags.TORTILLA)));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.PORTOBELLO_BURGER)
                .requires(ForgeTags.BREAD)
                .requires(CRItems.BAKED_PORTOBELLO_CAP.get())
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_burger", finished, enabled(CRItems.PORTOBELLO_BURGER), tagEmpty(CRItemTags.BURGER_BUN));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.PORTOBELLO_BURGER)
                .requires(CRItemTags.BURGER_BUN)
                .requires(CRItems.BAKED_PORTOBELLO_CAP.get())
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_burger_from_bun", finished, enabled(CRItems.PORTOBELLO_BURGER), not(tagEmpty(CRItemTags.BURGER_BUN)));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.LIMEADE)
                .requires(Ingredient.of(CRItemTags.FRUITS_LIME), 2)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
            "food/limeade", finished, enabled(CRItems.LIMEADE));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.BERRY_LIMEADE)
                .requires(Ingredient.of(CRItemTags.FRUITS_LIME), 2)
                .requires(Ingredient.of(ForgeTags.BERRIES), 3)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
            "food/berry_limeade", finished, enabled(CRItems.BERRY_LIMEADE));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.BERRY_LIMEADE)
                .requires(CRItems.LIMEADE.get(), 1)
                .requires(Ingredient.of(ForgeTags.BERRIES), 3)
                .unlockedBy("has_limeade", has(CRItems.LIMEADE.get())),
            "food/berry_limeade_from_limeade", finished, enabled(CRItems.BERRY_LIMEADE));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.PINK_LIMEADE)
                .requires(Ingredient.of(CRItemTags.FRUITS_LIME), 2)
                .requires(Ingredient.of(CRItemTags.FRUITS_POMEGRANATE), 3)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
            "food/pink_limeade", finished, enabled(CRItems.PINK_LIMEADE));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.PINK_LIMEADE)
                .requires(CRItems.LIMEADE.get(), 1)
                .requires(Ingredient.of(CRItemTags.FRUITS_POMEGRANATE), 3)
                .unlockedBy("has_limeade", has(CRItems.LIMEADE.get())),
            "food/pink_limeade_from_limeade", finished, enabled(CRItems.PINK_LIMEADE));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.MINT_LIMEADE)
                .requires(Ingredient.of(CRItemTags.FRUITS_LIME), 2)
                .requires(Ingredient.of(CRItemTags.MINT_LEAVES), 2)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
            "food/mint_limeade", finished, enabled(CRItems.MINT_LIMEADE), modLoaded("neapolitan"), not(tagEmpty(CRItemTags.MINT_LEAVES)));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.MINT_LIMEADE)
                .requires(CRItems.LIMEADE.get(), 1)
                .requires(Ingredient.of(CRItemTags.MINT_LEAVES), 2)
                .unlockedBy("has_limeade", has(CRItems.LIMEADE.get())),
            "food/mint_limeade_from_limeade", finished, enabled(CRItems.MINT_LIMEADE), modLoaded("neapolitan"), not(tagEmpty(CRItemTags.MINT_LEAVES)));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.POMEGRANATE_SMOOTHIE)
                .requires(Ingredient.of(CRItemTags.BANANA), 1)
                .requires(Ingredient.of(CRItemTags.FRUITS_POMEGRANATE), 2)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_pomegranate", has(CRItemTags.FRUITS_POMEGRANATE)),
            "food/pomegranate_smoothie", finished, enabled(CRItems.POMEGRANATE_SMOOTHIE), modLoaded("neapolitan"), not(tagEmpty(CRItemTags.BANANA)));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.SALMON_TARTARE)
                .requires(Ingredient.of(ForgeTags.RAW_FISHES_SALMON), 3)
                .requires(CRItemTags.FRUITS_CITRUS)
                .requires(Items.BOWL)
                .unlockedBy("has_citrus", has(CRItemTags.FRUITS_CITRUS)),
            "food/salmon_tartare", finished, enabled(CRItems.SALMON_TARTARE));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.COD_CEVICHE)
                .requires(ForgeTags.RAW_FISHES_COD)
                .requires(CRItemTags.FRUITS_CITRUS)
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .requires(Items.BOWL)
                .unlockedBy("has_citrus", has(CRItemTags.FRUITS_CITRUS)),
            "food/cod_ceviche", finished, enabled(CRItems.COD_CEVICHE));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.DELUXE_SALAD)
                .requires(Items.APPLE)
                .requires(ForgeTags.SALAD_INGREDIENTS_CABBAGE)
                .requires(Items.MELON_SLICE)
                .requires(Ingredient.of(CRItemTags.FRUITS_POMEGRANATE))
                .requires(Ingredient.of(CRItemTags.FRUITS_LIME))
                .requires(Items.SWEET_BERRIES)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(Items.BOWL)
                .unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
            "food/deluxe_salad", finished, enabled(CRItems.DELUXE_SALAD));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.POMEGRANATE_BEAN_SALAD)
                .requires(CRItemTags.FRUITS_POMEGRANATE)
                .requires(CRItemTags.ROASTED_ADZUKI_BEANS)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .requires(Items.BOWL)
                .unlockedBy("has_pomegranate", has(CRItemTags.FRUITS_POMEGRANATE)),
            "food/pomegranate_bean_salad", finished, enabled(CRItems.POMEGRANATE_BEAN_SALAD), not(tagEmpty(CRItemTags.ROASTED_ADZUKI_BEANS)), modLoaded("neapolitan"));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.CHOCOLATE_ARILS)
                .requires(CRItemTags.SEEDS_POMEGRANATE)
                .requires(CRItemTags.CHOCOLATE_BAR)
                .unlockedBy("has_pomegranate_seeds", has(CRItemTags.SEEDS_POMEGRANATE)),
            "food/chocolate_arils", finished, enabled(CRItems.CHOCOLATE_ARILS), not(tagEmpty(CRItemTags.CHOCOLATE_BAR)), modLoaded("neapolitan"), not(modLoaded("create")));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.STRAWBERRY_JAM_BUN)
                .requires(ForgeTags.DOUGH)
                .requires(ForgeTags.MILK)
                .requires(CRItemTags.RED_STRAWBERRIES)
                .requires(CRItemTags.LIME_OR_SLICE)
                .unlockedBy("has_strawberries", has(CRItemTags.RED_STRAWBERRIES)),
            "food/strawberry_jam_bun", finished, enabled(CRItems.STRAWBERRY_JAM_BUN), not(tagEmpty(CRItemTags.RED_STRAWBERRIES)), modLoaded("neapolitan"));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.BIG_RICE_BALL)
                .requires(Items.DRIED_KELP)
                .requires(ModItems.COOKED_RICE.get(), 3)
                .requires(CRItemTags.CRAB_MEAT)
                .unlockedBy("has_cooked_crab", has(CRItemTags.CRAB_MEAT)),
            "food/big_rice_ball", finished, enabled(CRItems.BIG_RICE_BALL));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.LAND_AND_SEA_BURGER)
                .requires(ForgeTags.BREAD)
                .requires(CRItems.BAKED_PORTOBELLO_CAP.get())
                .requires(CRItems.CHIEFTAIN_CLAW.get())
                .requires(ModItems.BEEF_PATTY.get())
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .unlockedBy("has_chieftain_claw", has(CRItems.CHIEFTAIN_CLAW.get())),
            "food/land_and_sea_burger", finished, enabled(CRItems.LAND_AND_SEA_BURGER), tagEmpty(CRItemTags.BURGER_BUN));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.LAND_AND_SEA_BURGER)
                .requires(CRItemTags.BURGER_BUN)
                .requires(CRItems.BAKED_PORTOBELLO_CAP.get())
                .requires(CRItems.CHIEFTAIN_CLAW.get())
                .requires(ModItems.BEEF_PATTY.get())
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .unlockedBy("has_chieftain_claw", has(CRItems.CHIEFTAIN_CLAW.get())),
            "food/land_and_sea_burger_from_bun", finished, enabled(CRItems.LAND_AND_SEA_BURGER), not(tagEmpty(CRItemTags.BURGER_BUN)));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.CLAM_ROLL)
                .requires(Ingredient.of(CRItemTags.RAW_CLAM), 2)
                .requires(ModItems.COOKED_RICE.get())
                .unlockedBy("has_raw_claw", has(CRItemTags.RAW_CLAM)),
            "food/clam_roll", finished, enabled(CRItems.CLAM_ROLL));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.UNI_ROLL)
                .requires(CRItems.UNI.get())
                .requires(ModItems.COOKED_RICE.get())
                .requires(Items.DRIED_KELP)
                .unlockedBy("has_uni", has(CRItems.UNI.get())),
            "food/uni_roll", finished, enabled(CRItems.UNI_ROLL));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.PRAWN_ROLL)
                .requires(Ingredient.of(CRItemTags.RAW_PRAWN), 2)
                .requires(ModItems.COOKED_RICE.get())
                .unlockedBy("has_raw_prawn", has(CRItemTags.RAW_PRAWN)),
            "food/prawn_roll", finished, enabled(CRItems.PRAWN_ROLL));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.PRAWN_PO_BOY)
                .requires(ForgeTags.BREAD)
                .requires(CRItemTags.COOKED_PRAWN)
                .requires(ForgeTags.EGGS)
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .unlockedBy("has_cooked_prawn", has(CRItemTags.COOKED_PRAWN)),
            "food/prawn_po_boy", finished, enabled(CRItems.PRAWN_PO_BOY));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.PRAWN_CEVICHE)
                .requires(CRItemTags.RAW_PRAWN)
                .requires(CRItemTags.FRUITS_CITRUS)
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .requires(Items.BOWL)
                .unlockedBy("has_raw_prawn", has(CRItemTags.RAW_PRAWN)),
            "food/prawn_ceviche", finished, enabled(CRItems.PRAWN_CEVICHE));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.FISH_MIX)
                .requires(ModItems.SALMON_SLICE.get())
                .requires(ModItems.COD_SLICE.get())
                .requires(CRItems.PLATINUM_BASS_SLICE.get())
                .requires(ForgeTags.CROPS_CABBAGE)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .requires(Items.BOWL)
                .unlockedBy("has_slice", has(CRItems.PLATINUM_BASS_SLICE.get())),
            "food/fish_mix", finished, enabled(CRItems.FISH_MIX));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.SEA_WRAP)
                .requires(ForgeTags.BREAD)
                .requires(CRItems.CHIEFTAIN_CLAW.get())
                .requires(CRItemTags.RAW_CLAM)
                .requires(ForgeTags.COOKED_FISHES_COD)
                .requires(ForgeTags.COOKED_FISHES_SALMON)
                .requires(CRItemTags.COOKED_PRAWN)
                .requires(Items.DRIED_KELP)
                .requires(ModItems.COOKED_RICE.get())
                .unlockedBy("has_claw", has(CRItems.CHIEFTAIN_CLAW.get())),
            "food/sea_wrap", finished, enabled(CRItems.SEA_WRAP), tagEmpty(CRItemTags.TORTILLA));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.SEA_WRAP)
                .requires(CRItemTags.TORTILLA)
                .requires(CRItems.CHIEFTAIN_CLAW.get())
                .requires(CRItemTags.RAW_CLAM)
                .requires(ForgeTags.COOKED_FISHES_COD)
                .requires(ForgeTags.COOKED_FISHES_SALMON)
                .requires(CRItemTags.COOKED_PRAWN)
                .requires(Items.DRIED_KELP)
                .requires(ModItems.COOKED_RICE.get())
                .unlockedBy("has_claw", has(CRItems.CHIEFTAIN_CLAW.get())),
            "food/sea_wrap_from_tortilla", finished, enabled(CRItems.SEA_WRAP), not(tagEmpty(CRItemTags.TORTILLA)));

        // Shaped Crafting
        wrap(shaped(RecipeCategory.FOOD, CRItems.PORTOBELLO_QUICHE)
                .pattern("eme")
                .pattern("ooo")
                .pattern("pcp")
                .define('e', ForgeTags.EGGS)
                .define('m', ForgeTags.MILK)
                .define('o', ForgeTags.CROPS_ONION)
                .define('p', CRItems.BAKED_PORTOBELLO_CAP.get())
                .define('c', ModItems.PIE_CRUST.get())
                .unlockedBy("has_baked_portobello_cap", has(CRItems.BAKED_PORTOBELLO_CAP.get())),
            "food/portobello_quiche", finished, enabled(CRItems.PORTOBELLO_QUICHE));
        wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CRItems.PORTOBELLO_QUICHE.get(), 1)
                .requires(CRItems.PORTOBELLO_QUICHE_SLICE.get(), 4)
                .unlockedBy("has_portobello_quiche_slice", has(CRItems.PORTOBELLO_QUICHE_SLICE.get())),
            "food/portobello_quiche_from_slices", finished, enabled(CRItems.PORTOBELLO_QUICHE), enabled(CRItems.PORTOBELLO_QUICHE_SLICE));
        wrap(shaped(RecipeCategory.FOOD, CRItems.LIME_PIE)
                .pattern("ese")
                .pattern("lll")
                .pattern("mcm")
                .define('e', ForgeTags.EGGS)
                .define('m', ForgeTags.MILK)
                .define('l', CRItemTags.FRUITS_LIME)
                .define('s', Items.SUGAR)
                .define('c', ModItems.PIE_CRUST.get())
                .unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
            "food/lime_pie", finished, enabled("lime_pie"));
        wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CRItems.LIME_PIE.get(), 1)
                .requires(CRItems.LIME_PIE_SLICE.get(), 4)
                .unlockedBy("has_lime_pie_slice", has(CRItems.LIME_PIE_SLICE.get())),
            "food/lime_pie_from_slices", finished, enabled(CRItems.LIME_PIE), enabled(CRItems.LIME_PIE_SLICE));
        wrap(shaped(RecipeCategory.FOOD, CRItems.LIME_POPSICLE)
                .pattern(" ll")
                .pattern("ill")
                .pattern("si ")
                .define('l', CRItemTags.FRUITS_LIME)
                .define('i', Items.ICE)
                .define('s', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
            "food/lime_popsicle", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_POPSICLE));
        wrap(shaped(RecipeCategory.FOOD, CRItems.LIME_COOKIE, 8)
                .pattern("wlw")
                .define('l', CRItemTags.FRUITS_LIME)
                .define('w', Tags.Items.CROPS_WHEAT)
                .unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
            "food/lime_cookie", finished, enabled(CRItems.LIME), enabled(CRItems.LIME_COOKIE));
        wrap(shaped(RecipeCategory.FOOD, CRItems.LIME_CAKE)
                .pattern("mlm")
                .pattern("ses")
                .pattern("wlw")
                .define('e', ForgeTags.EGGS)
                .define('m', ForgeTags.MILK)
                .define('l', CRItemTags.FRUITS_LIME)
                .define('s', Items.SUGAR)
                .define('w', ForgeTags.GRAIN_WHEAT)
                .unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
            "food/lime_cake", finished, enabled("lime_cake"));
        wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CRItems.LIME_CAKE.get(), 1)
                .requires(CRItems.LIME_CAKE_SLICE.get(), 7)
                .unlockedBy("has_lime_cake_slice", has(CRItems.LIME_CAKE_SLICE.get())),
            "food/lime_cake_from_slices", finished, enabled(CRItems.LIME_CAKE), enabled(CRItems.LIME_CAKE_SLICE));
        wrap(shaped(RecipeCategory.FOOD, CRItems.POMEGRANATE_CAKE)
                .pattern("mpm")
                .pattern("ses")
                .pattern("wpw")
                .define('e', ForgeTags.EGGS)
                .define('m', ForgeTags.MILK)
                .define('p', CRItemTags.FRUITS_POMEGRANATE)
                .define('s', Items.SUGAR)
                .define('w', ForgeTags.GRAIN_WHEAT)
                .unlockedBy("has_pomegranate", has(CRItemTags.FRUITS_POMEGRANATE)),
            "food/pomegranate_cake", finished, enabled("pomegranate_cake"));
        wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, CRItems.POMEGRANATE_CAKE.get(), 1)
                .requires(CRItems.POMEGRANATE_CAKE_SLICE.get(), 7)
                .unlockedBy("has_pomegranate_cake_slice", has(CRItems.POMEGRANATE_CAKE_SLICE.get())),
            "food/pomegranate_cake_from_slices", finished, enabled(CRItems.POMEGRANATE_CAKE), enabled(CRItems.POMEGRANATE_CAKE_SLICE));
        wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRItems.URCHIN_TEST_BLOCK.get())
                .pattern("xxx")
                .pattern("xxx")
                .pattern("xxx")
                .define('x', CRItems.URCHIN_TEST.get())
                .unlockedBy("has_urchin_test", has(CRItems.URCHIN_TEST.get())),
            "urchin_test_block", finished, enabled("urchin_test"));
        wrap(ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CRItems.URCHIN_TEST.get(), 9)
            .requires(CRItems.URCHIN_TEST_BLOCK.get(), 1)
            .unlockedBy("has_urchin_test_block", has(CRItems.URCHIN_TEST_BLOCK.get())),
            "unpack_urchin_test_block", finished, enabled("urchin_test"));
        wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRItems.URCHIN_TEST_BRICKS.get(), 4)
                .pattern("xx")
                .pattern("xx")
                .define('x', CRItems.URCHIN_TEST_BLOCK.get())
                .unlockedBy("has_urchin_test_block", has(CRItems.URCHIN_TEST_BLOCK.get())),
            "urchin_test_bricks", finished, enabled("urchin_test"));
        wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRItems.URCHIN_TEST_BRICK_SLAB.get(), 6)
                .pattern("xxx")
                .define('x', CRItems.URCHIN_TEST_BRICKS.get())
                .unlockedBy("has_urchin_test_bricks", has(CRItems.URCHIN_TEST_BRICKS.get())),
            "urchin_test_brick_slab", finished, enabled("urchin_test"));
        wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRItems.URCHIN_TEST_BRICK_STAIRS.get(), 4)
                .pattern("x  ")
                .pattern("xx ")
                .pattern("xxx")
                .define('x', CRItems.URCHIN_TEST_BRICKS.get())
                .unlockedBy("has_urchin_test_bricks", has(CRItems.URCHIN_TEST_BRICKS.get())),
            "urchin_test_brick_stairs", finished, enabled("urchin_test"));
        wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRItems.URCHIN_TEST_BRICK_WALL.get(), 6)
                .pattern("xxx")
                .pattern("xxx")
                .define('x', CRItems.URCHIN_TEST_BRICKS.get())
                .unlockedBy("has_urchin_test_bricks", has(CRItems.URCHIN_TEST_BRICKS.get())),
            "urchin_test_brick_wall", finished, enabled("urchin_test"));
        wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRItems.URCHIN_TEST_TILES.get(), 4)
                .pattern("xx")
                .pattern("xx")
                .define('x', CRItems.URCHIN_TEST_BRICKS.get())
                .unlockedBy("has_urchin_test_bricks", has(CRItems.URCHIN_TEST_BRICKS.get())),
            "urchin_test_tiles", finished, enabled("urchin_test"));
        wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRItems.URCHIN_TEST_TILE_SLAB.get(), 6)
                .pattern("xxx")
                .define('x', CRItems.URCHIN_TEST_TILES.get())
                .unlockedBy("has_urchin_test_tiles", has(CRItems.URCHIN_TEST_TILES.get())),
            "urchin_test_tile_slab", finished, enabled("urchin_test"));
        wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRItems.URCHIN_TEST_TILE_STAIRS.get(), 4)
                .pattern("x  ")
                .pattern("xx ")
                .pattern("xxx")
                .define('x', CRItems.URCHIN_TEST_TILES.get())
                .unlockedBy("has_urchin_test_tiles", has(CRItems.URCHIN_TEST_TILES.get())),
            "urchin_test_tile_stairs", finished, enabled("urchin_test"));
        wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRItems.URCHIN_TEST_TILE_WALL.get(), 6)
                .pattern("xxx")
                .pattern("xxx")
                .define('x', CRItems.URCHIN_TEST_TILES.get())
                .unlockedBy("has_urchin_test_tiles", has(CRItems.URCHIN_TEST_TILES.get())),
            "urchin_test_tile_wall", finished, enabled("urchin_test"));
        wrap(ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CRItems.CHISELED_URCHIN_TEST_BRICKS.get())
                .pattern("x")
                .pattern("x")
                .define('x', CRItems.URCHIN_TEST_BRICK_SLAB.get())
                .unlockedBy("has_urchin_test_brick_slab", has(CRItems.URCHIN_TEST_BRICK_SLAB.get())),
            "chiseled_urchin_test_bricks", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BLOCK.get()), RecipeCategory.DECORATIONS,
                CRItems.URCHIN_TEST_BRICKS.get())
                .unlockedBy("has_urchin_test_block", has(CRItems.URCHIN_TEST_BLOCK.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_bricks", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BLOCK.get()), RecipeCategory.DECORATIONS,
                CRItems.URCHIN_TEST_TILES.get())
                .unlockedBy("has_urchin_test_block", has(CRItems.URCHIN_TEST_BLOCK.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_tiles", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BRICKS.get()), RecipeCategory.DECORATIONS,
                CRItems.URCHIN_TEST_TILES.get())
                .unlockedBy("has_urchin_test_bricks", has(CRItems.URCHIN_TEST_BRICKS.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_tiles_from_bricks", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BRICKS.get()), RecipeCategory.DECORATIONS,
                    CRItems.CHISELED_URCHIN_TEST_BRICKS.get())
                .unlockedBy("has_urchin_test_bricks", has(CRItems.CHISELED_URCHIN_TEST_BRICKS.get())),
            CollectorsReap.MODID, "stonecutting/chiseled_urchin_test_bricks", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BLOCK.get()), RecipeCategory.DECORATIONS,
                    CRItems.CHISELED_URCHIN_TEST_BRICKS.get())
                .unlockedBy("has_urchin_test_block", has(CRItems.URCHIN_TEST_BLOCK.get())),
            CollectorsReap.MODID, "stonecutting/chiseled_urchin_test_bricks_from_block", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BRICKS.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_BRICK_SLAB.get(), 2)
                .unlockedBy("has_urchin_test_bricks", has(CRItems.URCHIN_TEST_BRICKS.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_brick_slab", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BLOCK.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_BRICK_SLAB.get(), 2)
                .unlockedBy("has_urchin_test_block", has(CRItems.URCHIN_TEST_BLOCK.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_brick_slab_from_block", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BRICKS.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_BRICK_STAIRS.get(), 1)
                .unlockedBy("has_urchin_test_bricks", has(CRItems.URCHIN_TEST_BRICKS.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_brick_stairs", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BLOCK.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_BRICK_STAIRS.get(), 1)
                .unlockedBy("has_urchin_test_block", has(CRItems.URCHIN_TEST_BLOCK.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_brick_stairs_from_block", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BRICKS.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_BRICK_WALL.get(), 1)
                .unlockedBy("has_urchin_test_bricks", has(CRItems.URCHIN_TEST_BRICKS.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_brick_wall", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BLOCK.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_BRICK_WALL.get(), 1)
                .unlockedBy("has_urchin_test_block", has(CRItems.URCHIN_TEST_BLOCK.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_brick_wall_from_block", finished, enabled("urchin_test"));

        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_TILES.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_TILE_SLAB.get(), 2)
                .unlockedBy("has_urchin_test_tiles", has(CRItems.URCHIN_TEST_TILES.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_tile_slab", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BRICKS.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_TILE_SLAB.get(), 2)
                .unlockedBy("has_urchin_test_bricks", has(CRItems.URCHIN_TEST_BRICKS.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_tile_slab_from_bricks", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BLOCK.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_TILE_SLAB.get(), 2)
                .unlockedBy("has_urchin_test_block", has(CRItems.URCHIN_TEST_BLOCK.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_tile_slab_from_block", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_TILES.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_TILE_STAIRS.get(), 1)
                .unlockedBy("has_urchin_test_tiles", has(CRItems.URCHIN_TEST_TILES.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_tile_stairs", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BRICKS.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_TILE_STAIRS.get(), 1)
                .unlockedBy("has_urchin_test_bricks", has(CRItems.URCHIN_TEST_BRICKS.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_tile_stairs_from_bricks", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BLOCK.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_TILE_STAIRS.get(), 1)
                .unlockedBy("has_urchin_test_block", has(CRItems.URCHIN_TEST_BLOCK.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_tile_stairs_from_block", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_TILES.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_TILE_WALL.get(), 1)
                .unlockedBy("has_urchin_test_tiles", has(CRItems.URCHIN_TEST_TILES.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_tile_wall", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BRICKS.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_TILE_WALL.get(), 1)
                .unlockedBy("has_urchin_test_bricks", has(CRItems.URCHIN_TEST_BRICKS.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_tile_wall_from_bricks", finished, enabled("urchin_test"));
        wrap(SingleItemRecipeBuilder.stonecutting(Ingredient.of(CRItems.URCHIN_TEST_BLOCK.get()), RecipeCategory.DECORATIONS,
                    CRItems.URCHIN_TEST_TILE_WALL.get(), 1)
                .unlockedBy("has_urchin_test_block", has(CRItems.URCHIN_TEST_BLOCK.get())),
            CollectorsReap.MODID, "stonecutting/urchin_test_tile_wall_from_block", finished, enabled("urchin_test"));

        // Neapolitan Compat
        wrap(shapeless(RecipeCategory.FOOD, CRItems.LIME_ICE_CREAM)
                .requires(Items.BOWL)
                .requires(CRItemTags.FRUITS_LIME)
                .requires(ForgeTags.MILK)
                .requires(CRItemTags.ICE_CUBES)
                .requires(Items.SUGAR)
                .unlockedBy("has_lime", has(CRItemTags.FRUITS_LIME)),
            "food/lime_ice_cream", finished, enabled(CRItems.LIME_ICE_CREAM), not(tagEmpty(CRItemTags.ICE_CUBES)), modLoaded("neapolitan"));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.LIME_MILKSHAKE, 3)
                .requires(Items.GLASS_BOTTLE, 3)
                .requires(CRItems.LIME_ICE_CREAM.get())
                .requires(ForgeTags.MILK)
                .unlockedBy("has_lime_ice_cream", has(CRItems.LIME_ICE_CREAM.get())),
            "food/lime_milkshake", finished, enabled(CRItems.LIME_ICE_CREAM), enabled(CRItems.LIME_MILKSHAKE), modLoaded("neapolitan"));
        wrap(shaped(RecipeCategory.BUILDING_BLOCKS, CRItems.LIME_ICE_CREAM_BLOCK, 8)
                .pattern("sss")
                .pattern("sis")
                .pattern("sss")
                .define('s', Blocks.SNOW_BLOCK)
                .define('i', CRItems.LIME_ICE_CREAM.get())
                .unlockedBy("has_lime_ice_cream", has(CRItems.LIME_ICE_CREAM.get())),
            "lime_ice_cream_block", finished, enabled(CRItems.LIME_ICE_CREAM_BLOCK), enabled(CRItems.LIME_ICE_CREAM), modLoaded("neapolitan"));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.POMEGRANATE_ICE_CREAM)
                .requires(Items.BOWL)
                .requires(CRItemTags.FRUITS_POMEGRANATE)
                .requires(ForgeTags.MILK)
                .requires(CRItemTags.ICE_CUBES)
                .requires(Items.SUGAR)
                .unlockedBy("has_pomegranate", has(CRItemTags.FRUITS_POMEGRANATE)),
            "food/pomegranate_ice_cream", finished, enabled(CRItems.POMEGRANATE_ICE_CREAM), not(tagEmpty(CRItemTags.ICE_CUBES)), modLoaded("neapolitan"));
        wrap(shapeless(RecipeCategory.FOOD, CRItems.POMEGRANATE_MILKSHAKE, 3)
                .requires(Items.GLASS_BOTTLE, 3)
                .requires(CRItems.POMEGRANATE_ICE_CREAM.get())
                .requires(ForgeTags.MILK)
                .unlockedBy("has_pomegranate_ice_cream", has(CRItems.POMEGRANATE_ICE_CREAM.get())),
            "food/pomegranate_milkshake", finished, enabled(CRItems.POMEGRANATE_ICE_CREAM), enabled(CRItems.POMEGRANATE_MILKSHAKE), modLoaded("neapolitan"));
        wrap(shaped(RecipeCategory.BUILDING_BLOCKS, CRItems.POMEGRANATE_ICE_CREAM_BLOCK, 8)
                .pattern("sss")
                .pattern("sis")
                .pattern("sss")
                .define('s', Blocks.SNOW_BLOCK)
                .define('i', CRItems.POMEGRANATE_ICE_CREAM.get())
                .unlockedBy("has_pomegranate_ice_cream", has(CRItems.POMEGRANATE_ICE_CREAM.get())),
            "pomegranate_ice_cream_block", finished, enabled(CRItems.POMEGRANATE_ICE_CREAM_BLOCK), enabled(CRItems.POMEGRANATE_ICE_CREAM), modLoaded("neapolitan"));
}


    private InventoryChangeTrigger.TriggerInstance has(ItemLike... items) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(items);
    }

    private void wrap(RecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, CollectorsReap.MODID, name, consumer, conds);
    }

    private void wrap(RecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = Util.rl(modid, name);
        ConditionalRecipe.Builder cond;
        if (conds.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conds));
        } else if (conds.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conds[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.save(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0])
          .generateAdvancement()
          .build(consumer, loc);
    }

    private void wrap(SingleItemRecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = Util.rl(modid, name);
        ConditionalRecipe.Builder cond;
        if (conds.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conds));
        } else if (conds.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conds[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.save(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0])
            .generateAdvancement()
            .build(consumer, loc);
    }

    private void wrap(SmithingTransformRecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = Util.cr(name);
        ConditionalRecipe.Builder cond;
        if (conds.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conds));
        } else if (conds.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conds[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.save(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0])
            .generateAdvancement()
            .build(consumer, loc);
    }

    private void wrap(CuttingBoardRecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, CollectorsReap.MODID, name, consumer, conds);
    }

    private void wrap(CuttingBoardRecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = Util.rl(modid, name);
        ConditionalRecipe.Builder cond;
        if (conds.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conds));
        } else if (conds.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conds[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.build(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0])
            .generateAdvancement()
            .build(consumer, loc);
    }

    private void wrap(CookingPotRecipeBuilder builder, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        wrap(builder, CollectorsReap.MODID, name, consumer, conds);
    }

    private void wrap(CookingPotRecipeBuilder builder, String modid, String name, Consumer<FinishedRecipe> consumer, ICondition... conds) {
        ResourceLocation loc = Util.rl(modid, name);
        ConditionalRecipe.Builder cond;
        if (conds.length > 1) {
            cond = ConditionalRecipe.builder().addCondition(and(conds));
        } else if (conds.length == 1) {
            cond = ConditionalRecipe.builder().addCondition(conds[0]);
        } else {
            cond = ConditionalRecipe.builder();
        }
        FinishedRecipe[] recipe = new FinishedRecipe[1];
        builder.build(f -> recipe[0] = f, loc);
        cond.addRecipe(recipe[0])
            .generateAdvancement()
            .build(consumer, loc);
    }

    private static void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience, Consumer<FinishedRecipe> consumer) {
        String namePrefix = Util.cr(name).toString();
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200).unlockedBy(name, has(ingredient)).save(consumer);
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600).unlockedBy(name, has(ingredient)).save(consumer, namePrefix + "_from_campfire_cooking");
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100).unlockedBy(name, has(ingredient)).save(consumer, namePrefix + "_from_smoking");
    }

    private EnabledCondition enabled(RegistryObject<Item> item) {
        return new EnabledCondition(Util.name(item));
    }

    private EnabledCondition enabled(String name) {
        return new EnabledCondition(name);
    }
    
    private ShapelessRecipeBuilder shapeless(RecipeCategory category, RegistryObject<Item> returns, int... count) {
        if (count.length > 0 && count[0] > 1) {
            return ShapelessRecipeBuilder.shapeless(category, returns.get(), count[0]);
        }
        return ShapelessRecipeBuilder.shapeless(category, returns.get());
    }

    private ShapedRecipeBuilder shaped(RecipeCategory category, RegistryObject<Item> returns, int... count) {
        if (count.length > 0 && count[0] > 1) {
            return ShapedRecipeBuilder.shaped(category, returns.get(), count[0]);
        }
        return ShapedRecipeBuilder.shaped(category, returns.get());
    }
}