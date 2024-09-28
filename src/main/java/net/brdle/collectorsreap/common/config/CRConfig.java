package net.brdle.collectorsreap.common.config;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.RegistryObject;
import java.util.HashMap;
import java.util.Map;

public class CRConfig {

	public static final ForgeConfigSpec COMMON;
	private static final Map<String, ForgeConfigSpec.BooleanValue> ITEMS = new HashMap<>();

	// COMMON
	public static ForgeConfigSpec.BooleanValue LIME_POLLINATION;
	public static ForgeConfigSpec.BooleanValue POMEGRANATE_POLLINATION;
	public static ForgeConfigSpec.BooleanValue FAST_POLLINATE;

	static {
		ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

		COMMON_BUILDER.comment("Enabled items").push("Items");
		CRItems.ITEMS.getEntries().stream()
			.map(obj -> obj.getId().getPath())
			.sorted()
			.forEach(name -> put(COMMON_BUILDER, name));
		COMMON_BUILDER.pop();

		COMMON_BUILDER.push("Behavior");
		LIME_POLLINATION = COMMON_BUILDER
			.comment("Whether Lime Bushes require Bee pollination to reach final growth stage.")
			.define("lime_pollination", true);
		POMEGRANATE_POLLINATION = COMMON_BUILDER
			.comment("Whether Pomegranate Bushes require Bee pollination to reach final growth stage in the Overworld.")
			.define("pomegranate_pollination", true);
		FAST_POLLINATE = COMMON_BUILDER
			.comment("Whether bee pollination of bushes should occur much quicker (when Bee collides with it) rather than on Bee's AI scheduled timing. Use this if having issues with pollination.")
			.define("fast_pollinate", false);
		COMMON_BUILDER.pop();

		COMMON = COMMON_BUILDER.build();
	}

	public static boolean verify(String item) {
		return contains(item) && ITEMS.get(item).get();
	}

	public static boolean verify(RegistryObject<Item> item) {
		return verify(item.getId().getPath());
	}

	public static boolean verify(Item item) {
		return verify(Util.name(item));
	}

	private static void put(ForgeConfigSpec.Builder builder, String name) {
		CRConfig.ITEMS.put(name, builder.define(name, true));
	}

	private static boolean contains(String item) {
		return ITEMS.containsKey(item);
	}
}