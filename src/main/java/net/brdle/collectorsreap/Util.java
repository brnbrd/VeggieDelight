package net.brdle.collectorsreap;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import java.util.Objects;
import java.util.function.Supplier;

public class Util {

	public static ResourceLocation rl(String modid, String path) {
		return new ResourceLocation(modid, path);
	}

	public static ResourceLocation rl(String separated) {
		return new ResourceLocation(separated);
	}

	public static ResourceLocation cr(String path) {
		return new ResourceLocation(CollectorsReap.MODID, path);
	}

	public static TagKey<Item> it(String modid, String path) {
		return ItemTags.create(rl(modid, path));
	}

	public static ObjectArrayList<ItemStack> with(ObjectArrayList<ItemStack> before, ItemStack addition) {
		before.add(addition);
		return before;
	}

	@Nullable
	public static Item item(String modid, String path) {
		return item(rl(modid, path));
	}

	@Nullable
	public static Item item(ResourceLocation rl) {
		return ForgeRegistries.ITEMS.getValue(rl);
	}

	public static ItemStack gs(Supplier<Item> r) {
		return r.get().getDefaultInstance();
	}

	public static String name(Item item) {
		return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
	}

	public static String name(Block block) {
		return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
	}

	public static String name(RegistryObject<?> reg) {
		return reg.getId().getPath();
	}
}