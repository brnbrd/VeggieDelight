package net.brdle.collectorsreap.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class CrabPathNavigation extends PathNavigation {
	public CrabPathNavigation(Mob pMob, Level pLevel) {
		super(pMob, pLevel);
	}

	@Override
	protected @NotNull PathFinder createPathFinder(int p_217792_) {
		this.nodeEvaluator = new AmphibiousNodeEvaluator(false);
		this.nodeEvaluator.setCanPassDoors(true);
		return new PathFinder(this.nodeEvaluator, p_217792_);
	}

	@Override
	protected @NotNull Vec3 getTempMobPos() {
		return new Vec3(this.mob.getX(), this.mob.getY(0.5D), this.mob.getZ());
	}

	/**
	 * If on ground or swimming and can swim
	 */
	@Override
	protected boolean canUpdatePath() {
		return true;
	}

	protected boolean canMoveDirectly(@NotNull Vec3 p_217796_, @NotNull Vec3 p_217797_) {
		return !this.isInLiquid() || isClearForMovementBetween(this.mob, p_217796_, p_217797_);
	}

	public boolean isStableDestination(@NotNull BlockPos p_217799_) {
		return true;
	}
}
