package net.brdle.collectorsreap.data.gen;

import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.data.ItemModels;
import java.util.List;

public class CRItemModelProvider extends ItemModelProvider {
	public CRItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, CollectorsReap.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		for (RegistryObject<Item> entry : CRItems.ITEMS.getEntries()) {
			ResourceLocation id = entry.getId();
			if (entry == CRItems.URCHIN_DART) {
				continue;
			} else if (!(isBasic(entry))) {
				if (entry.get() instanceof ForgeSpawnEggItem) {
					spawnEgg(id);
					continue;
				} else if (entry == CRItems.PORTOBELLO) {
					itemGeneratedModel(CRItems.PORTOBELLO.get(), CRBlockStateProvider.resourceBlock(Util.name(CRItems.PORTOBELLO)));
					continue;
				} else if (entry == CRItems.PORTOBELLO_COLONY) {
					itemGeneratedModel(CRItems.PORTOBELLO_COLONY.get(), CRBlockStateProvider.resourceBlock(Util.name(CRItems.PORTOBELLO_COLONY) + "_stage3"));
					continue;
				} else if (entry.get() instanceof BlockItem b) {
					if (b.getBlock() instanceof WallBlock) {
						wallInventory(id.getPath(), Util.rl(id.getNamespace(), "block/" + id.getPath().replace("_wall", "s")));
						continue;
					} else if (!(entry.get() instanceof ItemNameBlockItem)) {
						withExistingParent(id.getPath(), Util.cr("block/" + id.getPath()));
						continue;
					}
				}
			}
			basicItem(id);
		}
	}

	public ItemModelBuilder itemGeneratedModel(Item item, ResourceLocation texture) {
		return withExistingParent(Util.name(item), ItemModels.GENERATED).texture("layer0", texture);
	}

	public ItemModelBuilder handheld(ResourceLocation item) {
		return withExistingParent(item.getPath(), ItemModels.HANDHELD).texture("layer0", Util.cr("item/" + item.getPath()));
	}

	public ItemModelBuilder spawnEgg(ResourceLocation item) {
		return withExistingParent(item.getPath(), "item/template_spawn_egg");
	}

	private boolean isBasic(RegistryObject<Item> entry) {
		return List.of(
			CRItems.PORTOBELLO_QUICHE,
			CRItems.LIME_PIE,
			CRItems.LIME_CAKE,
			CRItems.POMEGRANATE_CAKE,
			CRItems.LIME_SEEDS,
			CRItems.POMEGRANATE_SEEDS,
			CRItems.PLATINUM_BASS_ROE
		).contains(entry);
	}
}