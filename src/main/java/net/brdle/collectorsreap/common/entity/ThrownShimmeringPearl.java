package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.ForgeEventFactory;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;

public class ThrownShimmeringPearl extends ThrowableItemProjectile {
	public ThrownShimmeringPearl(EntityType<? extends ThrownShimmeringPearl> type, Level level) {
		super(type, level);
	}

	public ThrownShimmeringPearl(Level level, LivingEntity shooter) {
		super(CREntities.SHIMMERING_PEARL.get(), shooter, level);
	}

	@Override
	public @NotNull Item getDefaultItem() {
		return CRItems.SHIMMERING_PEARL.get();
	}

	@Override
	public void onHitEntity(@NotNull EntityHitResult result) {
		super.onHitEntity(result);
		result.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 1.0F);
		this.discard();
	}

	private void teleport(Entity entity, double X, double Y, double Z) {
		entity.teleportTo(X, Y, Z);
		entity.resetFallDistance();
		if (entity instanceof LivingEntity living) {
			living.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 2));
			if (entity.isInWater()) {
				living.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 60, 0));
			}
		}
	}

	@Override
	public void onHit(@NotNull HitResult result) {
		super.onHit(result);
		for (int i = 0; i < 32; ++i) {
			this.level().addParticle(ParticleTypes.BUBBLE_POP, this.getX(), this.getY() + this.random.nextDouble() * 2.0, this.getZ(), this.random.nextGaussian(), 0.0, this.random.nextGaussian());
		}
		if (!this.level().isClientSide() && !this.isRemoved()) {
			Entity entity = this.getOwner();
			if (entity instanceof ServerPlayer server) {
				if (server.connection.isAcceptingMessages() && server.level() == this.level() && !server.isSleeping()) {
					if (server.isPassenger()) {
						server.dismountTo(this.getX(), this.getY(), this.getZ());
					}
					this.teleport(entity, this.getX(), this.getY(), this.getZ());
				}
			} else if (entity != null) {
				this.teleport(entity, this.getX(), this.getY(), this.getZ());
			}
			this.discard();
		}
	}

	@Override
	public void tick() {
		Entity entity = this.getOwner();
		if (entity instanceof Player && !entity.isAlive()) {
			this.discard();
		} else {
			// Projectile
			if (!this.hasBeenShot) {
				this.gameEvent(GameEvent.PROJECTILE_SHOOT, this.getOwner());
				this.hasBeenShot = true;
			}
			if (!this.leftOwner) {
				this.leftOwner = this.checkLeftOwner();
			}

			// Entity
			this.baseTick();

			// ThrowableProjectile
			HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
			if (hitresult.getType() != HitResult.Type.MISS && !ForgeEventFactory.onProjectileImpact(this, hitresult)) {
				this.onHit(hitresult);
			}
			this.checkInsideBlocks();
			Vec3 vec3 = this.getDeltaMovement();
			double d2 = this.getX() + vec3.x;
			double d0 = this.getY() + vec3.y;
			double d1 = this.getZ() + vec3.z;
			this.updateRotation();
			if (this.isInWater()) {
				this.level().addParticle(ParticleTypes.BUBBLE, d2 - vec3.x * 0.25, d0 - vec3.y * 0.25, d1 - vec3.z * 0.25, vec3.x, vec3.y, vec3.z);
			}
			if (!this.isNoGravity()) {
				Vec3 vec31 = this.getDeltaMovement();
				this.setDeltaMovement(vec31.x, vec31.y - (double)this.getGravity(), vec31.z);
			}
			this.setPos(d2, d0, d1);
		}
	}

	@Nullable
	public Entity changeDimension(@NotNull ServerLevel pServer, @NotNull ITeleporter teleporter) {
		Entity entity = this.getOwner();
		if (entity != null && entity.level().dimension() != pServer.dimension()) {
			this.setOwner(null);
		}
		return super.changeDimension(pServer, teleporter);
	}

	@Override
	public boolean fireImmune() {
		return false;
	}

	@Override
	public boolean dismountsUnderwater() {
		return false;
	}
}