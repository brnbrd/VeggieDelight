package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Clam extends WaterGroundCreature {
	public static final int VARIANTS = 4;
	private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Clam.class, EntityDataSerializers.INT);
	public final AnimationState openAnimationState = new AnimationState();

	public Clam(EntityType<? extends Clam> type, Level level) {
		super(type, level);
	}

	@Override
	public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
		return !this.fromBucket() && !this.hasCustomName();
	}

	public static AttributeSupplier.@NotNull Builder createAttributes() {
		return Mob.createMobAttributes()
			.add(Attributes.MOVEMENT_SPEED, 0.0D)
			.add(Attributes.MAX_HEALTH, 10.0D);
	}

	public int getVariant() {
		return this.entityData.get(VARIANT);
	}

	private void setVariant(int variant) {
		this.entityData.set(VARIANT, variant);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(VARIANT, 0);
	}

	@Override
	public void addAdditionalSaveData(@NotNull CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Variant", getVariant());
	}

	@Override
	public void readAdditionalSaveData(@NotNull CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		setVariant(Mth.clamp(compound.getInt("Variant"), 0, VARIANTS - 1));
	}

	@Override
	public void saveToBucketTag(ItemStack bucket) {
		CompoundTag nbt = bucket.getOrCreateTag();
		nbt.putInt("Variant", this.getVariant());
		nbt.putFloat("Health", this.getHealth());
	}

	@Override
	public void loadFromBucketTag(CompoundTag nbt) {
		if (nbt.contains("Variant")) {
			this.setVariant(nbt.getInt("Variant"));
		}
		if (nbt.contains("Health", 99)) {
			this.setHealth(nbt.getFloat("Health"));
		}
	}

	@Override
	public @NotNull ItemStack getBucketItemStack() {
		return CRItems.CLAM_BUCKET.get().getDefaultInstance();
	}

	@Override
	public @NotNull SoundEvent getPickupSound() {
		return SoundEvents.BUCKET_FILL_AXOLOTL;
	}

	@Override
	public @Nullable SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor worldIn, @NotNull DifficultyInstance difficultyIn, @NotNull MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		if (dataTag == null) {
			setVariant(getRandom().nextInt(VARIANTS));
		} else if (dataTag.contains("Variant", 3)) {
			this.setVariant(dataTag.getInt("Variant"));
		} else if (dataTag.contains("Health", 99)) {
			this.setHealth(dataTag.getFloat("Health"));
		}
		this.setXRot(this.getRandom().nextFloat());
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	public boolean isPushable() {
		return true;
	}

	@Override
	public void aiStep() {
		if (this.isInWater() && !this.onGround()) {
			this.sinkInFluid(ForgeMod.WATER_TYPE.get());
		}
		super.aiStep();
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			if (this.isInWater()) {
				this.openAnimationState.startIfStopped(this.tickCount);
			} else {
				this.openAnimationState.stop();
			}
		}
	}

	@Override
	protected void registerGoals() {
	}
}