package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.block.EffectCandleCakeBlock;
import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ModTags;
import java.util.concurrent.CompletableFuture;

public class CRBlockTagProvider extends BlockTagsProvider {

	public CRBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, CollectorsReap.MODID, existingFileHelper);
	}

	@Override
	public void addTags(HolderLookup.@NotNull Provider provider)
	{
		// Farmer's Delight
		this.tag(ModTags.MINEABLE_WITH_KNIFE)
			.add(CRBlocks.PORTOBELLO_QUICHE.get())
			.add(CRBlocks.LIME_PIE.get());
		this.tag(ModTags.COMPOST_ACTIVATORS)
			.add(CRBlocks.PORTOBELLO.get())
			.add(CRBlocks.PORTOBELLO_COLONY.get());
		this.tag(ModTags.UNAFFECTED_BY_RICH_SOIL)
			.add(CRBlocks.PORTOBELLO_COLONY.get());

		// Collector's Reap
		this.tag(CRBlockTags.PORTOBELLO_SPAWNABLE_ON)
			.addTag(ModTags.MUSHROOM_COLONY_GROWABLE_ON)
			.addTag(BlockTags.MUSHROOM_GROW_BLOCK)
			.addTag(BlockTags.DIRT);
		this.tag(CRBlockTags.POMEGRANATE_FAST_ON)
			.addTag(BlockTags.NYLIUM)
			.addOptionalTag(Util.rl("nethersdelight", "rich_soul_soil"));
		this.tag(CRBlockTags.CRAB_SPAWNABLE_ON)
			.addTag(BlockTags.SAND)
			.addTag(Tags.Blocks.GRAVEL)
			.add(Blocks.WATER)
			.add(Blocks.CLAY);

		// Minecraft
		this.tag(BlockTags.BEE_GROWABLES)
			.add(CRBlocks.LIME_BUSH.get())
			.add(CRBlocks.POMEGRANATE_BUSH.get());
		CRBlocks.BLOCKS.getEntries()
			.stream()
			.map(RegistryObject::get)
			.filter(b -> b instanceof EffectCandleCakeBlock)
			.forEach(b -> this.tag(BlockTags.CANDLE_CAKES).add(b));
		this.tag(BlockTags.CANDLE_CAKES);
		this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
			.add(CRBlocks.LIME_ICE_CREAM_BLOCK.get())
			.add(CRBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get());
		this.tag(BlockTags.MINEABLE_WITH_AXE)
			.add(CRBlocks.PORTOBELLO.get())
			.add(CRBlocks.LIME_CRATE.get())
			.add(CRBlocks.POMEGRANATE_CRATE.get());
		this.tag(BlockTags.WALLS)
			.add(CRBlocks.URCHIN_TEST_BRICK_WALL.get())
			.add(CRBlocks.URCHIN_TEST_TILE_WALL.get());
		this.tag(BlockTags.SLABS)
			.add(CRBlocks.URCHIN_TEST_BRICK_SLAB.get())
			.add(CRBlocks.URCHIN_TEST_TILE_SLAB.get());
		this.tag(BlockTags.STAIRS)
			.add(CRBlocks.URCHIN_TEST_BRICK_STAIRS.get())
			.add(CRBlocks.URCHIN_TEST_TILE_STAIRS.get());
		this.tag(BlockTags.CAULDRONS)
			.add(CRBlocks.LIME_MILKSHAKE_CAULDRON.get())
			.add(CRBlocks.POMEGRANATE_MILKSHAKE_CAULDRON.get());

		// Serene Seasons
		this.tag(CRBlockTags.WINTER_CROPS);
		this.tag(CRBlockTags.AUTUMN_CROPS)
			.add(CRBlocks.POMEGRANATE_BUSH.get());
		this.tag(CRBlockTags.SUMMER_CROPS)
			.add(CRBlocks.POMEGRANATE_BUSH.get());
		this.tag(CRBlockTags.SPRING_CROPS)
			.add(CRBlocks.LIME_BUSH.get());

		// My Nether's Delight
		this.tag(CRBlockTags.SHOWCASE_ACTIVATORS)
			.add(CRBlocks.PORTOBELLO.get())
			.add(CRBlocks.PORTOBELLO_COLONY.get());

		// Other
		this.tag(BlockTags.create(Util.rl("twilightforest", "portal/decoration"))).add(CRBlocks.PORTOBELLO.get());
		this.tag(BlockTags.create(Util.rl("immersive_weathering", "small_mushrooms"))).add(CRBlocks.PORTOBELLO.get());
		this.tag(BlockTags.create(Util.rl("autumnity", "snail_snacks"))).add(CRBlocks.PORTOBELLO.get());
	}
}
