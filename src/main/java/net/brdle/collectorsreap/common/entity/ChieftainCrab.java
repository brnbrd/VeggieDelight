package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.annotation.Nonnull;
import java.util.UUID;

public class ChieftainCrab extends WaterAnimal implements NeutralMob, Bucketable {
	private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(ChieftainCrab.class, EntityDataSerializers.BOOLEAN);
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
	private int remainingPersistentAngerTime;
	@Nullable private UUID persistentAngerTarget;
	public final AnimationState idleAnimationState = new AnimationState();
	public final AnimationState movingAnimationState = new AnimationState();

	public ChieftainCrab(EntityType<? extends WaterAnimal> type, Level level) {
		super(type, level);
		this.setAirSupply(300);
	}

	public static AttributeSupplier.@NotNull Builder createAttributes() {
		return Mob.createMobAttributes()
			.add(Attributes.MAX_HEALTH, 30.0D)
			.add(Attributes.MOVEMENT_SPEED, 0.15D)
			.add(Attributes.ATTACK_DAMAGE, 8.0D)
			.add(Attributes.ATTACK_KNOCKBACK, 0.5D)
			.add(Attributes.ARMOR, 3.0D)
			.add(Attributes.ARMOR_TOUGHNESS, 2.0D)
			.add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
	}

	@Override
	protected void handleAirSupply(int pAirSupply) {
	}

	@Override
	public float getSpeed() {
		float speed = super.getSpeed();
		return this.isInWater() ? speed * 3F : speed;
	}

	@Override
	protected @NotNull PathNavigation createNavigation(@NotNull Level pLevel) {
		return new CrabPathNavigation(this, pLevel);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 2.0D, true));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1.5D, 40));
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	}

	@Override
	public void aiStep() {
		if (this.isInWater() && !this.isOnGround()) {
			this.sinkInFluid(ForgeMod.WATER_TYPE.get());
		}
		super.aiStep();
	}

	@Override
	public @Nonnull MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	@Override
	public float getStepHeight() {
		return 1.125F;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(FROM_BUCKET, false);
	}

	@Override
	public boolean requiresCustomPersistence() {
		return super.requiresCustomPersistence() || this.fromBucket();
	}

	@Override
	public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
		//return !this.fromBucket() && !this.hasCustomName();
		return false;
	}

	@Override
	public @NotNull InteractionResult mobInteract(@NotNull Player pPlayer, @NotNull InteractionHand pHand) {
		return Bucketable.bucketMobPickup(pPlayer, pHand, this).orElse(super.mobInteract(pPlayer, pHand));
	}

	@Override
	public void addAdditionalSaveData(@NotNull CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("FromBucket", this.fromBucket());
	}

	@Override
	public void readAdditionalSaveData(@NotNull CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setFromBucket(compound.getBoolean("FromBucket"));
	}

	@Override
	public void saveToBucketTag(ItemStack bucket) {
		CompoundTag nbt = bucket.getOrCreateTag();
		nbt.putFloat("Health", this.getHealth());
	}

	@Override
	public void loadFromBucketTag(CompoundTag nbt) {
		if (nbt.contains("Health", 99)) {
			this.setHealth(nbt.getFloat("Health"));
		}
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
	public @NotNull ItemStack getBucketItemStack() {
		return CRItems.CHIEFTAIN_CRAB_BUCKET.get().getDefaultInstance();
	}

	@Override
	public @NotNull SoundEvent getPickupSound() {
		return SoundEvents.BUCKET_FILL_AXOLOTL;
	}

	private boolean isMoving() {
		return this.getDeltaMovement().horizontalDistanceSqr() > 5.0E-4D;
	}

	private boolean isMovingInWater() {
		return this.isMoving() && this.isInWaterOrBubble();
	}

	@Override
	public void tick() {
		super.tick();
		if (this.getLevel().isClientSide()) {
			if (this.isMoving()) {
				this.idleAnimationState.stop();
				this.movingAnimationState.startIfStopped(this.tickCount);
			} else {
				this.movingAnimationState.stop();
				this.idleAnimationState.startIfStopped(this.tickCount);
			}
		} else {
			this.updatePersistentAnger((ServerLevel)this.getLevel(), true);
		}
	}

	public static boolean checkCrabSpawnRules(EntityType<ChieftainCrab> crab, ServerLevelAccessor level, MobSpawnType type, BlockPos pos, RandomSource rand) {
		return level.getBlockState(pos.below()).is(CRBlockTags.CRAB_SPAWNABLE_ON);
	}

	@Override
	public @Nullable SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor worldIn, @NotNull DifficultyInstance difficultyIn, @NotNull MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		if (dataTag != null && dataTag.contains("Health", 99)) {
			this.setHealth(dataTag.getFloat("Health"));
		}
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	protected float getStandingEyeHeight(@NotNull Pose pose, @NotNull EntityDimensions size) {
		return this.getBbHeight() * 0.75F;
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean canDrownInFluidType(FluidType type) {
		return type != ForgeMod.WATER_TYPE.get();
	}

	@Override
	public boolean isPushedByFluid(FluidType type) {
		return false;
	}

	@Override
	public boolean causeFallDamage(float pFallDistance, float pMultiplier, @NotNull DamageSource pSource) {
		return false;
	}

	@Override
	public boolean canBeLeashed(@NotNull Player pPlayer) {
		return false;
	}

	@Override
	protected SoundEvent getHurtSound(@NotNull DamageSource pDamageSource) {
		return SoundEvents.TROPICAL_FISH_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.TROPICAL_FISH_DEATH;
	}

	@Override
	protected void playStepSound(@NotNull BlockPos pPos, @NotNull BlockState pBlock) {
		this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
	}

	@Override
	public int getRemainingPersistentAngerTime() {
		return this.remainingPersistentAngerTime;
	}

	@Override
	public void setRemainingPersistentAngerTime(int pTime) {
		this.remainingPersistentAngerTime = pTime;
	}

	@Nullable
	@Override
	public UUID getPersistentAngerTarget() {
		return this.persistentAngerTarget;
	}

	@Override
	public void setPersistentAngerTarget(@Nullable UUID pTarget) {
		this.persistentAngerTarget = pTarget;
	}

	@Override
	public void startPersistentAngerTimer() {
		this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.getRandom()));
	}
}