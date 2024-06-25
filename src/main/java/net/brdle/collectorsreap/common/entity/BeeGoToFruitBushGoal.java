package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.common.block.FruitBushBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.NotNull;
import java.util.EnumSet;

public class BeeGoToFruitBushGoal extends MoveToBlockGoal {
	private final Bee bee;

	public BeeGoToFruitBushGoal(Bee bee) {
		super(bee, 1.0D, 3, 2);
		this.bee = bee;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	private Bee getBee() {
		return this.bee;
	}

	public boolean canBeeUse() {
		return (
			!this.getBee().hasRestriction() &&
			!this.getBee().isAngry() &&
			this.getBee().getCropsGrownSincePollination() < 10 &&
			this.getBee().hasNectar()
		);
	}

	@Override
	public boolean canUse() {
		return this.canBeeUse() && super.canUse();
	}

	@Override
	public boolean canContinueToUse() {
		return this.canBeeUse() && super.canContinueToUse();
	}

	@Override
	protected boolean isValidTarget(LevelReader level, @NotNull BlockPos pos) {
		BlockState state = level.getBlockState(pos);
		return (
			state.getBlock() instanceof FruitBushBlock &&
			state.hasProperty(FruitBushBlock.HALF) &&
			state.getValue(FruitBushBlock.HALF) == DoubleBlockHalf.UPPER &&
			state.hasProperty(FruitBushBlock.AGE) &&
			state.getValue(FruitBushBlock.AGE) == FruitBushBlock.MAX_AGE - 1
		);
	}
}