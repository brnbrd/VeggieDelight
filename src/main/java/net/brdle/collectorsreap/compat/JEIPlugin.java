package net.brdle.collectorsreap.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.brdle.collectorsreap.CollectorsReap;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Predicate;

@JeiPlugin
@ParametersAreNonnullByDefault
@SuppressWarnings("unused")
public class JEIPlugin implements IModPlugin
{
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
        registration.addItemStackInfo(Util.gs(CRItems.LIME), Component.translatable("desc." + CollectorsReap.MODID + "." + Util.name(CRItems.LIME)));
        registration.addItemStackInfo(Util.gs(CRItems.POMEGRANATE), Component.translatable("desc." + CollectorsReap.MODID + "." + Util.name(CRItems.POMEGRANATE)));
        if (ModList.get().isLoaded("mynethersdelight")) {
            registration.addItemStackInfo(Util.gs(CRItems.PORTOBELLO_COLONY), Component.translatable("mynethersdelight.jei.info.mushroom_colony"));
        }
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }
}