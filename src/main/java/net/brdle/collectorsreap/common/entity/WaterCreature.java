package net.brdle.collectorsreap.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public abstract class WaterCreature extends WaterAnimal implements Bucketable {
	protected static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(WaterCreature.class, EntityDataSerializers.BOOLEAN);

	public WaterCreature(EntityType<? extends WaterCreature> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 8.0F, 1.6D, 1.4D, EntitySelector.NO_SPECTATORS::test));
	}

	@Override
	protected @NotNull PathNavigation createNavigation(@NotNull Level pLevel) {
		return new WaterBoundPathNavigation(this, pLevel);
	}

	@Override
	public void travel(@NotNull Vec3 pTravelVector) {
		if (this.isEffectiveAi() && this.isInWater()) {
			this.moveRelative(0.01F, pTravelVector);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
			if (this.getTarget() == null) {
				this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
			}
		} else {
			super.travel(pTravelVector);
		}
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return 6;
	}

	@Override
	protected float getStandingEyeHeight(@NotNull Pose pPose, EntityDimensions pSize) {
		return pSize.height * 0.65F;
	}

	@Override
	public boolean requiresCustomPersistence() {
		return super.requiresCustomPersistence() || this.fromBucket();
	}

	@Override
	public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
		return !this.fromBucket() && !this.hasCustomName();
	}

	@Override
	protected @NotNull InteractionResult mobInteract(@NotNull Player pPlayer, @NotNull InteractionHand pHand) {
		return Bucketable.bucketMobPickup(pPlayer, pHand, this).orElse(super.mobInteract(pPlayer, pHand));
	}

	@Override
	public void saveToBucketTag(@NotNull ItemStack stack) {
		Bucketable.saveDefaultDataToBucketTag(this, stack);
	}

	@Override
	public void loadFromBucketTag(@NotNull CompoundTag tag) {
		Bucketable.loadDefaultDataFromBucketTag(this, tag);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(FROM_BUCKET, false);
	}

	@Override
	public boolean fromBucket() {
		return this.entityData.get(FROM_BUCKET);
	}

	@Override
	public void setFromBucket(boolean pFromBucket) {
		this.entityData.set(FROM_BUCKET, pFromBucket);
	}

	@Override
	public void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putBoolean("FromBucket", this.fromBucket());
	}

	@Override
	public void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		this.setFromBucket(pCompound.getBoolean("FromBucket"));
	}

	@Override
	public @NotNull SoundEvent getPickupSound() {
		return SoundEvents.BUCKET_FILL_FISH;
	}

	@Override
	protected @NotNull SoundEvent getSwimSound() {
		return SoundEvents.FISH_SWIM;
	}

	@Override
	protected void playStepSound(@NotNull BlockPos pPos, @NotNull BlockState pBlock) {
	}
}