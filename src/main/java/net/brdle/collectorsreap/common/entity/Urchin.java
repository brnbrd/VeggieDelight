package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;

public class Urchin extends WaterGroundCreature {

	public Urchin(EntityType<? extends Urchin> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.@NotNull Builder createAttributes() {
		return Mob.createMobAttributes()
			.add(Attributes.MOVEMENT_SPEED, 0.1D)
			.add(Attributes.MAX_HEALTH, 10.0D);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new PanicGoal(this, 1.5D));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 6.0F, 1.25D, 1.35D, EntitySelector.NO_SPECTATORS::test));
		this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 0.5D, 40));
	}

	@Override
	public @NotNull ItemStack getBucketItemStack() {
		return CRItems.URCHIN_BUCKET.get().getDefaultInstance();
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	public void aiStep() {
		if (this.isInWater() && !this.onGround()) {
			this.sinkInFluid(ForgeMod.WATER_TYPE.get());
		}
		super.aiStep();
	}

	@Override
	public boolean hurt(@NotNull DamageSource source, float pAmount) {
		Entity entity = source.getEntity();
		if (
			!this.level().isClientSide() &&
			entity instanceof LivingEntity living &&
			!this.isInvulnerableTo(source) &&
			!source.isIndirect()
		) {
			DamageSource thorns = living.damageSources().thorns(this);
			if (!living.isInvulnerableTo(thorns)) {
				living.hurt(thorns, 3.0F);
			}
			living.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0), this);
		}
		return super.hurt(source, pAmount);
	}
}
