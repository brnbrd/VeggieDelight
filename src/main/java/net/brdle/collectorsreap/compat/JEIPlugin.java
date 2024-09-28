package net.brdle.collectorsreap.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.fluid.CRFluids;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.function.Predicate;

@JeiPlugin
@ParametersAreNonnullByDefault
@SuppressWarnings("unused")
public class JEIPlugin implements IModPlugin {
	private static final ResourceLocation ID = Util.cr("jei_plugin");

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		// Remove all disabled Items from JEI
		var items = CRItems.ITEMS.getEntries().stream()
			.filter(Predicate.not(CRConfig::verify)) // Keep only Items that are not enabled in the config
			.map(Util::gs) // Get ItemStack
			.toList();
		if (!items.isEmpty()) {
			registration.getIngredientManager().removeIngredientsAtRuntime(VanillaTypes.ITEM_STACK, items);
		}
		registration.addItemStackInfo(Util.gs(CRItems.PORTOBELLO), Component.translatable("desc." + CollectorsReap.MODID + "." + Util.name(CRItems.PORTOBELLO)));

		if (!ModList.get().isLoaded("farmersrespite")) {
			registration.getIngredientManager().removeIngredientsAtRuntime(ForgeTypes.FLUID_STACK, List.of(
				new FluidStack(CRFluids.LIME_GREEN_TEA.get(), 1000),
				new FluidStack(CRFluids.POMEGRANATE_BLACK_TEA.get(), 1000)
			));
		}

		// Lime
		String limeTranslationKey = "desc." + CollectorsReap.MODID + "." + Util.name(CRItems.LIME);
		List<ItemStack> limeStack = List.of(Util.gs(CRItems.LIME), Util.gs(CRItems.LIME_SLICE));
		if (CRConfig.LIME_POLLINATION.get()) {
			registration.addItemStackInfo(limeStack, Component.translatable(limeTranslationKey),
				Component.translatable(limeTranslationKey + ".pollination")
			);
		} else {
			registration.addItemStackInfo(limeStack, Component.translatable(limeTranslationKey));
		}

		// Pomegranate
		String pomTranslationKey = "desc." + CollectorsReap.MODID + "." + Util.name(CRItems.POMEGRANATE);
		List<ItemStack> pomStack = List.of(Util.gs(CRItems.POMEGRANATE), Util.gs(CRItems.POMEGRANATE_SLICE));
		if (CRConfig.POMEGRANATE_POLLINATION.get()) {
			registration.addItemStackInfo(pomStack,
				Component.translatable(pomTranslationKey),
				Component.translatable(pomTranslationKey + ".pollination")
			);
		} else {
			registration.addItemStackInfo(pomStack, Component.translatable(pomTranslationKey));
		}

		if (ModList.get().isLoaded("mynethersdelight")) {
			if (CRConfig.verify(CRItems.STYGIAN_POMEGRANATE)) {
				registration.addItemStackInfo(
					Util.gs(CRItems.STYGIAN_POMEGRANATE),
					Component.translatable("desc." + CollectorsReap.MODID + "." + Util.name(CRItems.STYGIAN_POMEGRANATE))
				);
			}
			registration.addItemStackInfo(Util.gs(CRItems.PORTOBELLO_COLONY), Component.translatable("mynethersdelight.jei.info.mushroom_colony"));
		}
	}

	@Override
	public @NotNull ResourceLocation getPluginUid() {
		return ID;
	}
}