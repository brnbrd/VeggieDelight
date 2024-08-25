package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.util.ITeleporter;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nullable;

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

	@Override
	public void onHit(@NotNull HitResult result) {
		super.onHit(result);
		for (int i = 0; i < 32; ++i) {
			this.level().addParticle(ParticleTypes.BUBBLE_POP, this.getX(), this.getY() + this.random.nextDouble() * 2.0, this.getZ(), this.random.nextGaussian(), 0.0, this.random.nextGaussian());
		}
		if (!this.level().isClientSide() && !this.isRemoved()) {
			if (!this.isInWater()) {
				Entity entity = this.getOwner();
				if (entity instanceof ServerPlayer server) {
					if (server.connection.isAcceptingMessages() && server.level() == this.level() && !server.isSleeping()) {
						if (server.isPassenger()) {
							server.dismountTo(this.getX(), this.getY(), this.getZ());
						}
						entity.teleportTo(this.getX(), this.getY(), this.getZ());
						entity.resetFallDistance();
					}
				} else if (entity != null) {
					entity.teleportTo(this.getX(), this.getY(), this.getZ());
					entity.resetFallDistance();
				}
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
			super.tick();
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
		return true;
	}
}