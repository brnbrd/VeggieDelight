package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.common.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.block.PieBlock;

public class CRBlockStateProvider extends BlockStateProvider {
    public CRBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, CollectorsReap.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.pieBlock(CRBlocks.PORTOBELLO_QUICHE);
        this.pieBlock(CRBlocks.LIME_PIE);
        this.stageBlock(CRBlocks.PORTOBELLO_COLONY.get(), PortobelloColonyBlock.COLONY_AGE);
        this.cross(CRBlocks.PORTOBELLO.get());
        this.crateBlock(CRBlocks.LIME_CRATE.get(), "lime");
        this.crateBlock(CRBlocks.POMEGRANATE_CRATE.get(), "pomegranate");
        this.cakeBlock(CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.WHITE_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.ORANGE_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.MAGENTA_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.LIGHT_BLUE_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.YELLOW_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.LIME_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.PINK_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.GRAY_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.LIGHT_GRAY_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.CYAN_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.PURPLE_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.BLUE_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.BROWN_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.GREEN_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.RED_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.candleCakeBlock(CRBlocks.BLACK_CANDLE_LIME_CAKE, CRBlocks.LIME_CAKE);
        this.cakeBlock(CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.WHITE_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.ORANGE_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.MAGENTA_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.LIGHT_BLUE_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.YELLOW_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.LIME_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.PINK_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.GRAY_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.LIGHT_GRAY_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.CYAN_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.PURPLE_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.BLUE_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.BROWN_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.GREEN_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.RED_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.candleCakeBlock(CRBlocks.BLACK_CANDLE_POMEGRANATE_CAKE, CRBlocks.POMEGRANATE_CAKE);
        this.simpleBlock(CRBlocks.LIME_ICE_CREAM_BLOCK.get());
        this.simpleBlock(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get());
        this.simpleBlock(CRBlocks.URCHIN_TEST_BLOCK.get(), this.models().cubeBottomTop(
            "urchin_test_block",
            resourceBlock("urchin_test_block_side"),
            resourceBlock("urchin_test_block_bottom"),
            resourceBlock("urchin_test_block_top")
        ));
        this.simpleBlock(CRBlocks.URCHIN_TEST_BRICKS.get());
        this.slabBlock((SlabBlock) CRBlocks.URCHIN_TEST_BRICK_SLAB.get(), resourceBlock("urchin_test_bricks"), resourceBlock("urchin_test_bricks"));
        this.stairsBlock((StairBlock) CRBlocks.URCHIN_TEST_BRICK_STAIRS.get(), resourceBlock("urchin_test_bricks"));
        this.wallBlock((WallBlock) CRBlocks.URCHIN_TEST_BRICK_WALL.get(), resourceBlock("urchin_test_bricks"));
        this.simpleBlock(CRBlocks.CHISELED_URCHIN_TEST_BRICKS.get());
        this.simpleBlock(CRBlocks.URCHIN_TEST_TILES.get());
        this.slabBlock((SlabBlock) CRBlocks.URCHIN_TEST_TILE_SLAB.get(), resourceBlock("urchin_test_tiles"), resourceBlock("urchin_test_tiles"));
        this.stairsBlock((StairBlock) CRBlocks.URCHIN_TEST_TILE_STAIRS.get(), resourceBlock("urchin_test_tiles"));
        this.wallBlock((WallBlock) CRBlocks.URCHIN_TEST_TILE_WALL.get(), resourceBlock("urchin_test_tiles"));
    }

    public void crateBlock(Block block, String cropName) {
        this.simpleBlock(block, this.models().cubeBottomTop(Util.name(block), resourceBlock(cropName + "_crate_side"), Util.rl(FarmersDelight.MODID, "block/crate_bottom"), resourceBlock(cropName + "_crate_top")));
    }

    // Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
    public static ResourceLocation resourceBlock(String path) {
        return Util.cr("block/" + path);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(resourceBlock(path), models().existingFileHelper);
    }

    public void cross(Block block) {
        this.simpleBlock(block, models().cross("block/" + Util.name(block),
            CRBlockStateProvider.resourceBlock(Util.name(block))).renderType("cutout"));
    }

    // Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
    public void stageBlock(Block block, IntegerProperty ageProperty, Property<?>... ignored) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            String stageName = Util.name(block) + "_stage" + state.getValue(ageProperty);
            return ConfiguredModel.builder()
                .modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
        }, ignored);
    }

    public void upperLowerStageBlock(Block block, IntegerProperty ageProperty, EnumProperty<DoubleBlockHalf> halfProperty, Property<?> ignored) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            String name = Util.name(block) + "_" + state.getValue(halfProperty).getSerializedName();
            var mod = models()
                .withExistingParent("block/" + name + "_stage" + state.getValue(ageProperty), Util.cr(name))
                .texture("side", resourceBlock(Util.name(block) + "_side_stage" + state.getValue(ageProperty)))
                .texture("plant", resourceBlock(Util.name(block) + "_plant_" + state.getValue(halfProperty).getSerializedName() + "_stage" + state.getValue(ageProperty)))
                .texture("particle", resourceBlock(Util.name(block) + "_plant_" + state.getValue(halfProperty).getSerializedName() + "_stage" + state.getValue(ageProperty)));
            if (state.getValue(halfProperty) == DoubleBlockHalf.UPPER) {
                mod.texture("top", resourceBlock(Util.name(block) + "_top_stage" + state.getValue(ageProperty)));
            }
            return ConfiguredModel.builder().modelFile(mod).build();
        }, ignored);
    }

    public void pomegranateBushBlock(Block block, IntegerProperty ageProperty, EnumProperty<DoubleBlockHalf> halfProperty) {
        getVariantBuilder(block).forAllStates(state -> {
            String halfStageName = Util.name(block) + "_" + state.getValue(halfProperty).getSerializedName() + "_stage" + state.getValue(ageProperty);
            String name = Util.name(block) + "_stage" + state.getValue(ageProperty);
            return ConfiguredModel.builder()
                .modelFile(models()
                    .withExistingParent("block/" + halfStageName,
                        Util.cr(Util.name(block) + "_" + state.getValue(halfProperty).getSerializedName()))
                    .texture("0", resourceBlock(name))).build();
        });
    }

    // Adapted from: https://github.com/vectorwing/FarmersDelight/blob/1.19/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
    public void pieBlock(RegistryObject<Block> block) {
        getVariantBuilder(block.get()).forAllStates(state -> {
            int bites = state.getValue(PieBlock.BITES);
            String name = Util.name(block);
            String suffix = bites > 0 ? "_slice" + bites : "";
            var mod = models()
                .withExistingParent("block/" + name + suffix, Util.rl(FarmersDelight.MODID, "pie" + suffix))
                .texture("top", resourceBlock(name + "_top"))
                .texture("bottom", resourceBlock(name + "_bottom"))
                .texture("side", resourceBlock(name + "_side"))
                .texture("particle", resourceBlock(name + "_top"));
            if (bites > 0) {
                mod.texture("inner", resourceBlock(name + "_inner"));
            }
            return ConfiguredModel.builder().modelFile(mod)
                .rotationY(((int) state.getValue(PieBlock.FACING).toYRot() + 180) % 360).build();
            }
        );
    }

    public void cakeBlock(RegistryObject<Block> block) {
        getVariantBuilder(block.get()).forAllStates(state -> {
                int bites = state.getValue(CakeBlock.BITES);
                String name = Util.name(block);
                String suffix = bites > 0 ? "_slice" + bites : "";
                var mod = models()
                    .withExistingParent("block/" + name + suffix, Util.rl("minecraft", "cake" + suffix))
                    .texture("top", resourceBlock(name + "_top"))
                    .texture("bottom", resourceBlock(name + "_bottom"))
                    .texture("side", resourceBlock(name + "_side"))
                    .texture("particle", resourceBlock(name + "_side"));
                if (bites > 0) {
                    mod.texture("inside", resourceBlock(name + "_inner"));
                }
                return ConfiguredModel.builder().modelFile(mod).build();
            }
        );
    }

    public void candleCakeBlock(RegistryObject<Block> block, RegistryObject<Block> cake) {
        getVariantBuilder(block.get()).forAllStates(state -> {
            String lit = state.getValue(AbstractCandleBlock.LIT) ? "_lit" : "";
            String name = Util.name(block);
            String cakeName = Util.name(cake);
            String candle = name.replace("_" + cakeName, "") + lit;
            return ConfiguredModel.builder().modelFile(models()
                .withExistingParent("block/" + name + lit, Util.rl("minecraft", "template_cake_with_candle"))
                .texture("bottom", resourceBlock(cakeName + "_bottom"))
                .texture("candle", Util.rl("minecraft", "block/" + candle))
                .texture("particle", resourceBlock(cakeName + "_side"))
                .texture("side", resourceBlock(cakeName + "_side"))
                .texture("top", resourceBlock(cakeName + "_top"))).build();
        });
    }
}
