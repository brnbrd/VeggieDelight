package net.brdle.collectorsreap.common.config;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class CRConfig {

	private static final CRConfig CONFIG;
	public static final ForgeConfigSpec SPEC;
	private static final Map<String, ForgeConfigSpec.BooleanValue> stuff = new HashMap<>();
	public static ForgeConfigSpec.BooleanValue LIME_POLLINATION;
	public static ForgeConfigSpec.BooleanValue POMEGRANATE_POLLINATION;
	public static ForgeConfigSpec.BooleanValue FAST_POLLINATE;

	CRConfig(ForgeConfigSpec.Builder builder) {
		builder.comment("Configure Collector's Reap");
		stuff.clear();
		builder.push("Items");
		CRItems.ITEMS.getEntries().stream()
				.map(obj -> obj.getId().getPath())
				.sorted()
				.forEach(not -> put(builder, stuff, not, true));
		builder.pop();
		builder.push("Behavior");
		LIME_POLLINATION = builder
				.comment("Whether Lime Bushes require Bee pollination to reach final growth stage.")
				.define("lime_pollination", true);
		POMEGRANATE_POLLINATION = builder
				.comment("Whether Pomegranate Bushes require Bee pollination to reach final growth stage in overworld.")
				.define("pomegranate_pollination", true);
		FAST_POLLINATE = builder
				.comment("Whether bee pollination of bushes should occur much quicker (when Bee collides with it) rather than on Bee's AI scheduled timing. Use this if having issues with pollination.")
				.define("fast_pollinate", false);
		builder.pop();
	}

	private static void put(ForgeConfigSpec.Builder builder, Map<String, ForgeConfigSpec.BooleanValue> map, String name, boolean def) {
		map.put(name, builder.define(name, def));
	}

	private static boolean contains(String item) {
		return stuff.containsKey(item);
	}

	public static boolean verify(String item) {
		return contains(item) && stuff.get(item).get();
	}

	public static boolean verify(RegistryObject<Item> item) {
		return verify(item.getId().getPath());
	}

	public static boolean verify(Item item) {
		return verify(Util.name(item));
	}

	static {
		var pair = new ForgeConfigSpec.Builder().configure(CRConfig::new);
		SPEC = pair.getRight();
		CONFIG = pair.getLeft();
	}
}