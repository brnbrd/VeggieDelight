package net.brdle.collectorsreap.common.item.food;

import joptsimple.internal.Strings;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import java.util.List;

public class CompatDrinkable extends DrinkableItem {
	private final String[] modid;

	public CompatDrinkable(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip, String... modid) {
		super(
			properties.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16),
			hasPotionEffectTooltip,
			hasCustomTooltip
		);
		this.modid = modid;
	}

	public String[] getModid() {
		return this.modid;
	}

	public boolean loaded() {
		for (String mod : this.getModid()) {
			if (ModList.get().isLoaded(mod)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> comps, @NotNull TooltipFlag isAdvanced) {
		if (!this.loaded()) {
			comps.add(Component.translatable("tooltip.requires_modid"));
			comps.add(Component.literal(Strings.join(this.getModid(), ", ")).withStyle(ChatFormatting.UNDERLINE));
		}
		super.appendHoverText(stack, level, comps, isAdvanced);
	}
}