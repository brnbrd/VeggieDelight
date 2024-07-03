package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PlatinumBass extends AbstractFish {
	public final AnimationState swimAnimationState = new AnimationState();
	public final AnimationState drownAnimationState = new AnimationState();

	public PlatinumBass(EntityType<? extends AbstractFish> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.@NotNull Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 1.0D)
				.add(Attributes.MAX_HEALTH, 8.0D);
	}

	@Override
	protected SoundEvent getFlopSound() {
		return SoundEvents.SALMON_FLOP;
	}

	@Override
	public @NotNull ItemStack getBucketItemStack() {
		return CRItems.PLATINUM_BASS_BUCKET.get().getDefaultInstance();
	}

	private boolean isMovingInWater() {
		return this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D && this.isInWaterOrBubble();
	}

	@Override
	public void tick() {
		if (this.level().isClientSide()) {
			if (this.isDeadOrDying() || this.getAirSupply() < this.getMaxAirSupply() - 20) {
				this.drownAnimationState.startIfStopped(this.tickCount);
			} else {
				this.drownAnimationState.stop();
				if (this.isMovingInWater()) {
					this.swimAnimationState.startIfStopped(this.tickCount);
				} else {
					this.swimAnimationState.stop();
				}
			}
		}
		super.tick();
	}
}
