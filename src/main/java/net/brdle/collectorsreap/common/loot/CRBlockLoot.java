package net.brdle.collectorsreap.common.loot;

import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.block.LimeBushBlock;
import net.brdle.collectorsreap.common.block.PomegranateBushBlock;
import net.brdle.collectorsreap.common.block.PortobelloColonyBlock;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class CRBlockLoot extends BlockLoot {

    @Override
    protected void addTables() {
        this.dropSelf(CRBlocks.PORTOBELLO.get());
        this.empty(CRBlocks.PORTOBELLO_QUICHE);
        this.empty(CRBlocks.LIME_PIE);
        // Lime Bush drops Seeds and optional Limes
        this.add(CRBlocks.LIME_BUSH.get(), (b) -> applyExplosionDecay(b,
            LootTable.lootTable()
                .withPool(this.applyExplosionCondition(CRItems.LIME_SEEDS.get(),
                    LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(b)
                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(LimeBushBlock.HALF, DoubleBlockHalf.LOWER)))
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(CRItems.LIME_SEEDS.get()))))
                .withPool(this.applyExplosionCondition(CRItems.LIME.get(),
                    LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(b)
                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(LimeBushBlock.AGE, LimeBushBlock.MAX_AGE)
                                .hasProperty(LimeBushBlock.HALF, DoubleBlockHalf.LOWER)))
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(CRItems.LIME.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))))));
        // Pomegranate Bush drops Seeds and optional Pomegranates
        this.add(CRBlocks.POMEGRANATE_BUSH.get(), (b) -> applyExplosionDecay(b,
            LootTable.lootTable()
                .withPool(applyExplosionCondition(CRItems.POMEGRANATE_SEEDS.get(),
                LootPool.lootPool()
                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(b)
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                            .hasProperty(PomegranateBushBlock.HALF, DoubleBlockHalf.LOWER)))
                    .setRolls(ConstantValue.exactly(1.0F))
                    .add(LootItem.lootTableItem(CRItems.POMEGRANATE_SEEDS.get()))))
                .withPool(applyExplosionCondition(CRItems.POMEGRANATE.get(),
                LootPool.lootPool()
                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(b)
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                            .hasProperty(PomegranateBushBlock.AGE, PomegranateBushBlock.MAX_AGE)
                            .hasProperty(PomegranateBushBlock.HALF, DoubleBlockHalf.LOWER)))
                    .setRolls(ConstantValue.exactly(1.0F))
                    .add(LootItem.lootTableItem(CRItems.POMEGRANATE.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))))));
        this.dropSelf(CRBlocks.LIME_CRATE.get());
        this.dropSelf(CRBlocks.POMEGRANATE_CRATE.get());
        this.empty(CRBlocks.LIME_CAKE);
        this.dropOther(CRBlocks.CANDLE_LIME_CAKE.get(), Blocks.CANDLE);
        this.dropOther(CRBlocks.WHITE_CANDLE_LIME_CAKE.get(), Blocks.WHITE_CANDLE);
        this.dropOther(CRBlocks.ORANGE_CANDLE_LIME_CAKE.get(), Blocks.ORANGE_CANDLE);
        this.dropOther(CRBlocks.MAGENTA_CANDLE_LIME_CAKE.get(), Blocks.MAGENTA_CANDLE);
        this.dropOther(CRBlocks.LIGHT_BLUE_CANDLE_LIME_CAKE.get(), Blocks.LIGHT_BLUE_CANDLE);
        this.dropOther(CRBlocks.YELLOW_CANDLE_LIME_CAKE.get(), Blocks.YELLOW_CANDLE);
        this.dropOther(CRBlocks.LIME_CANDLE_LIME_CAKE.get(), Blocks.LIME_CANDLE);
        this.dropOther(CRBlocks.PINK_CANDLE_LIME_CAKE.get(), Blocks.PINK_CANDLE);
        this.dropOther(CRBlocks.GRAY_CANDLE_LIME_CAKE.get(), Blocks.GRAY_CANDLE);
        this.dropOther(CRBlocks.LIGHT_GRAY_CANDLE_LIME_CAKE.get(), Blocks.LIGHT_GRAY_CANDLE);
        this.dropOther(CRBlocks.CYAN_CANDLE_LIME_CAKE.get(), Blocks.CYAN_CANDLE);
        this.dropOther(CRBlocks.PURPLE_CANDLE_LIME_CAKE.get(), Blocks.PURPLE_CANDLE);
        this.dropOther(CRBlocks.BLUE_CANDLE_LIME_CAKE.get(), Blocks.BLUE_CANDLE);
        this.dropOther(CRBlocks.BROWN_CANDLE_LIME_CAKE.get(), Blocks.BROWN_CANDLE);
        this.dropOther(CRBlocks.GREEN_CANDLE_LIME_CAKE.get(), Blocks.GREEN_CANDLE);
        this.dropOther(CRBlocks.RED_CANDLE_LIME_CAKE.get(), Blocks.RED_CANDLE);
        this.dropOther(CRBlocks.BLACK_CANDLE_LIME_CAKE.get(), Blocks.BLACK_CANDLE);
        this.empty(CRBlocks.POMEGRANATE_CAKE);
        this.dropOther(CRBlocks.CANDLE_POMEGRANATE_CAKE.get(), Blocks.CANDLE);
        this.dropOther(CRBlocks.WHITE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.WHITE_CANDLE);
        this.dropOther(CRBlocks.ORANGE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.ORANGE_CANDLE);
        this.dropOther(CRBlocks.MAGENTA_CANDLE_POMEGRANATE_CAKE.get(), Blocks.MAGENTA_CANDLE);
        this.dropOther(CRBlocks.LIGHT_BLUE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.LIGHT_BLUE_CANDLE);
        this.dropOther(CRBlocks.YELLOW_CANDLE_POMEGRANATE_CAKE.get(), Blocks.YELLOW_CANDLE);
        this.dropOther(CRBlocks.LIME_CANDLE_POMEGRANATE_CAKE.get(), Blocks.LIME_CANDLE);
        this.dropOther(CRBlocks.PINK_CANDLE_POMEGRANATE_CAKE.get(), Blocks.PINK_CANDLE);
        this.dropOther(CRBlocks.GRAY_CANDLE_POMEGRANATE_CAKE.get(), Blocks.GRAY_CANDLE);
        this.dropOther(CRBlocks.LIGHT_GRAY_CANDLE_POMEGRANATE_CAKE.get(), Blocks.LIGHT_GRAY_CANDLE);
        this.dropOther(CRBlocks.CYAN_CANDLE_POMEGRANATE_CAKE.get(), Blocks.CYAN_CANDLE);
        this.dropOther(CRBlocks.PURPLE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.PURPLE_CANDLE);
        this.dropOther(CRBlocks.BLUE_CANDLE_POMEGRANATE_CAKE.get(), Blocks.BLUE_CANDLE);
        this.dropOther(CRBlocks.BROWN_CANDLE_POMEGRANATE_CAKE.get(), Blocks.BROWN_CANDLE);
        this.dropOther(CRBlocks.GREEN_CANDLE_POMEGRANATE_CAKE.get(), Blocks.GREEN_CANDLE);
        this.dropOther(CRBlocks.RED_CANDLE_POMEGRANATE_CAKE.get(), Blocks.RED_CANDLE);
        this.dropOther(CRBlocks.BLACK_CANDLE_POMEGRANATE_CAKE.get(), Blocks.BLACK_CANDLE);
        this.dropSelf(CRBlocks.LIME_ICE_CREAM_BLOCK.get());
        this.dropSelf(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get());
        this.dropOther(CRBlocks.LIME_MILKSHAKE_CAULDRON.get(), Blocks.CAULDRON);
        this.dropOther(CRBlocks.POMEGRANATE_MILKSHAKE_CAULDRON.get(), Blocks.CAULDRON);
        this.dropSelf(CRBlocks.URCHIN_TEST_BLOCK.get());
        this.dropSelf(CRBlocks.URCHIN_TEST_BRICKS.get());
        this.dropSelf(CRBlocks.URCHIN_TEST_BRICK_SLAB.get());
        this.dropSelf(CRBlocks.URCHIN_TEST_BRICK_STAIRS.get());
        this.dropSelf(CRBlocks.URCHIN_TEST_BRICK_WALL.get());
        this.dropSelf(CRBlocks.CHISELED_URCHIN_TEST_BRICKS.get());
        this.dropSelf(CRBlocks.URCHIN_TEST_TILES.get());
        this.dropSelf(CRBlocks.URCHIN_TEST_TILE_SLAB.get());
        this.dropSelf(CRBlocks.URCHIN_TEST_TILE_STAIRS.get());
        this.dropSelf(CRBlocks.URCHIN_TEST_TILE_WALL.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return CRBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)
            .filter(b -> !(b instanceof PortobelloColonyBlock))
            ::iterator;
    }

    public void empty(RegistryObject<Block> block) {
        this.add(block.get(), LootTable.lootTable());
    }
}
