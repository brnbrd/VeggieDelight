package net.brdle.collectorsreap.common.item;

import joptsimple.internal.Strings;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class CompatItem extends Item {
	private final String[] modid;

	public CompatItem(Properties properties, String... modid) {
		super(properties);
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