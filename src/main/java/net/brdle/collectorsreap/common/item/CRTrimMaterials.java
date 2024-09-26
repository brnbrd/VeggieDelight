package net.brdle.collectorsreap.common.item;

import net.brdle.collectorsreap.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraftforge.registries.RegistryObject;
import java.util.Map;

public class CRTrimMaterials {
	public static final ResourceKey<TrimMaterial> PEARL = register("pearl");

	private static ResourceKey<TrimMaterial> register(final String name) {
		return ResourceKey.create(Registries.TRIM_MATERIAL, Util.cr(name));
	}

	public static void bootstrap(BootstapContext<TrimMaterial> context) {
		register(context, PEARL, CRItems.SHIMMERING_PEARL, Style.EMPTY.withColor(15715308), 0.2F);
	}

	private static void register(BootstapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, RegistryObject<Item> trimItem, Style color, float itemModelIndex) {
		TrimMaterial material = new TrimMaterial(trimKey.location().getPath(), trimItem.getHolder().get(), itemModelIndex, Map.of(), Component.translatable("trim_material." + trimKey.location().toLanguageKey()).withStyle(color));
		context.register(trimKey, material);
	}
}
