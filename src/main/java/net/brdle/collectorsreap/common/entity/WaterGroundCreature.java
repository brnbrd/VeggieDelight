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
import org.jetbrains.annotations.NotNull;

public abstract class WaterGroundCreature extends WaterCreature {
	public WaterGroundCreature(EntityType<? extends WaterGroundCreature> type, Level level) {
		super(type, level);
	}

	public static boolean checkWaterGroundSpawnRules(EntityType<? extends WaterAnimal> creature, LevelAccessor level, MobSpawnType type, BlockPos pos, RandomSource rand) {
		return (
			level.getFluidState(pos).is(FluidTags.WATER) &&
			level.getFluidState(pos.above()).is(FluidTags.WATER) &&
			pos.getY() < (level.getSeaLevel() - 2)
		);
	}

	@Override
	public void jumpInFluid(@NotNull FluidType type) {
	}

	@Override
	public void knockback(double strength, double x, double z) {
		super.knockback(strength * 0.2, x, z);
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