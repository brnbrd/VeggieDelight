package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.common.CRSoundEvents;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UrchinDart extends AbstractArrow {

	public UrchinDart(EntityType<? extends UrchinDart> type, Level level) {
		super(type, level);
	}

	public UrchinDart(LivingEntity shooter, Level level) {
		super(CREntities.URCHIN_DART.get(), shooter, level);
	}

	@Override
	public void doPostHurtEffects(@NotNull LivingEntity target) {
		super.doPostHurtEffects(target);
		MobEffectInstance poison = new MobEffectInstance(MobEffects.POISON, 100, 1);
		target.addEffect(poison, this.getEffectSource());
	}

	@Override
	public boolean tryPickup(@NotNull Player player) {
		return false;
	}

	@Override
	public @NotNull ItemStack getPickupItem() {
		return new ItemStack(CRItems.URCHIN_DART.get());
	}

	@Nullable
	@Override
	public ItemStack getPickResult() {
		return this.getPickupItem();
	}

	@Override
	public @NotNull SoundEvent getDefaultHitGroundSoundEvent() {
		return CRSoundEvents.URCHIN_DART_HIT.get();
	}
}