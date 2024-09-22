package net.brdle.collectorsreap.common.item;

import net.brdle.collectorsreap.common.CRSoundEvents;
import net.brdle.collectorsreap.common.entity.UrchinDart;
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
			if (this.getUseDuration(stack) - timeLeft >= 10) {
				level.playSound(null, player.getX(), player.getY(), player.getZ(), CRSoundEvents.URCHIN_DART_THROW.get(), SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
				player.getCooldowns().addCooldown(this, 20);
				if (!level.isClientSide()) {
					UrchinDart dart = new UrchinDart(player, level);
					dart.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.1F, 1.0F);
					level.addFreshEntity(dart);
				}
				player.awardStat(Stats.ITEM_USED.get(this));
				if (!player.getAbilities().instabuild) {
					stack.shrink(1);
				}
			}
		}
	}
}