package net.brdle.collectorsreap.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.fluids.FluidType;

public abstract class WaterGroundCreature extends WaterCreature {

	public WaterGroundCreature(EntityType<? extends WaterGroundCreature> type, Level level) {
		super(type, level);
	}

	public static boolean checkWaterGroundSpawnRules(EntityType<? extends WaterAnimal> creature, LevelAccessor level, MobSpawnType type, BlockPos pos, RandomSource rand) {
		return level.getFluidState(pos).is(FluidTags.WATER) &&
				level.getFluidState(pos.above()).is(FluidTags.WATER) &&
				pos.getY() < level.getSeaLevel() - 3;
	}

	@Override
	public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
		return false;
	}

	@Override
	public void jumpInFluid(FluidType type) {
	}

	@Override
	public void knockback(double pStrength, double pX, double pZ) {
	}

	@Override
	public boolean canSwimInFluidType(FluidType type) {
		return false;
	}

	@Override
	public boolean isPushedByFluid(FluidType type) {
		return false;
	}
}
