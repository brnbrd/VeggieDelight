package net.brdle.collectorsreap.common.item.food;

import joptsimple.internal.Strings;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.List;

public class CompatConsumable extends ConsumableItem {

	private final String[] modid;
	private final float heal;

	public CompatConsumable(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, String... modid) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
		this.heal = 0.0F;
		this.modid = modid;
	}

	public CompatConsumable(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, float heal, String... modid) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
		this.heal = heal;
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

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level worldIn, @NotNull LivingEntity entity) {
		if (this.loaded() && this.heal > 0.0F) {
			entity.heal(this.heal);
		}
		return super.finishUsingItem(stack, worldIn, entity);
	}
}
