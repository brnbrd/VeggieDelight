package net.brdle.collectorsreap.common.item.food;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CompatDrinkable extends CompatConsumable {

	public CompatDrinkable(Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip, String modid) {
		super(properties.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), hasPotionEffectTooltip, hasCustomTooltip, modid);
	}

	@Override
	public int getUseDuration(@NotNull ItemStack stack) {
		return 32;
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level worldIn, @NotNull LivingEntity entity) {
		super.finishUsingItem(stack, worldIn, entity);
		if (entity instanceof ServerPlayer serverPlayer) {
			CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
			serverPlayer.awardStat(Stats.ITEM_USED.get(this));
		}
		if (stack.isEmpty()) {
			return new ItemStack(Items.GLASS_BOTTLE);
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
				if (!player.getInventory().add(itemstack)) {
					player.drop(itemstack, false);
				}
			}
			return stack;
		}
	}

	@Override
	public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
		return UseAnim.DRINK;
	}

	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand) {
		return ItemUtils.startUsingInstantly(world, player, hand);
	}
}