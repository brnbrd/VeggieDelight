package net.brdle.collectorsreap.common.item;

import net.brdle.collectorsreap.common.entity.UrchinDart;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class UrchinDartItem extends Item {
	public UrchinDartItem(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
		player.startUsingItem(hand);
		return InteractionResultHolder.consume(player.getItemInHand(hand));
	}

	@Override
	public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
		return UseAnim.SPEAR;
	}

	@Override
	public int getUseDuration(@NotNull ItemStack stack) {
		return 36000;
	}

	@Override
	public void releaseUsing(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity, int timeLeft) {
		if (entity instanceof Player player) {
			int i = this.getUseDuration(stack) - timeLeft;
			if (i >= 10) {
				if (!level.isClientSide) {
					UrchinDart dart = new UrchinDart(player, level);
					dart.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.1F, 1.0F);
					level.addFreshEntity(dart);
					level.playSound(null, dart, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
					if (!player.getAbilities().instabuild) {
						if (stack.getCount() > 1) {
							stack.shrink(1);
						} else {
							player.getInventory().removeItem(stack);
						}
					}
					player.awardStat(Stats.ITEM_USED.get(this));
				}
			}
		}
	}
}
