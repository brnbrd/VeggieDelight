package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;

public class TigerPrawn extends WaterCreature {
	public final AnimationState swimAnimationState = new AnimationState();
	public final AnimationState drownAnimationState = new AnimationState();

	public TigerPrawn(EntityType<? extends WaterCreature> type, Level level) {
		super(type, level);
		this.moveControl = new PrawnMoveControl(this);
	}

	public static AttributeSupplier.@NotNull Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 1.0D)
				.add(Attributes.MAX_HEALTH, 6.0D);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 40));
	}

	@Override
	public @NotNull ItemStack getBucketItemStack() {
		return CRItems.TIGER_PRAWN_BUCKET.get().getDefaultInstance();
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

	@Override
	public void aiStep() {
		if (this.isInWater() && !this.onGround()) {
			this.sinkInFluid(ForgeMod.WATER_TYPE.get());
		}
		super.aiStep();
	}

	static class PrawnMoveControl extends MoveControl {
		private final TigerPrawn prawn;

		PrawnMoveControl(TigerPrawn prawn) {
			super(prawn);
			this.prawn = prawn;
		}

		@Override
		public void tick() {
			if (this.operation == MoveControl.Operation.MOVE_TO && !this.prawn.getNavigation().isDone()) {
				float f = (float) (this.speedModifier * this.prawn.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.prawn.setSpeed(Mth.lerp(0.125F, this.prawn.getSpeed(), f));
				double d0 = this.wantedX - this.prawn.getX();
				double d1 = this.wantedY - this.prawn.getY();
				double d2 = this.wantedZ - this.prawn.getZ();
				if (d1 != 0.0D) {
					double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
					this.prawn.setDeltaMovement(this.prawn.getDeltaMovement().add(0.0D, (double) this.prawn.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
				}
				if (d0 != 0.0D || d2 != 0.0D) {
					float f1 = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
					this.prawn.setYRot(this.rotlerp(this.prawn.getYRot(), f1, 90.0F));
					this.prawn.yBodyRot = this.prawn.getYRot();
				}
			} else {
				this.prawn.setSpeed(0.0F);
			}
		}
	}
}
