package net.brdle.collectorsreap.common.item;

import net.brdle.collectorsreap.common.CRSoundEvents;
import net.brdle.collectorsreap.common.entity.ThrownShimmeringPearl;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ShimmeringPearlItem extends PearlItem {

	public ShimmeringPearlItem(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull Rarity getRarity(@NotNull ItemStack stack) {
		return Rarity.UNCOMMON;
	}

	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		level.playSound(null, player.getX(), player.getY(), player.getZ(), CRSoundEvents.SHIMMERING_PEARL_THROW.get(), SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
		player.getCooldowns().addCooldown(this, 15);
		if (!level.isClientSide()) {
			ThrownShimmeringPearl thrown = new ThrownShimmeringPearl(level, player);
			thrown.setItem(itemstack);
			thrown.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.75F, 1.0F);
			level.addFreshEntity(thrown);
		}
		player.awardStat(Stats.ITEM_USED.get(this));
		if (!player.getAbilities().instabuild) {
			itemstack.shrink(1);
		}
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}