package net.brdle.collectorsreap.common.entity;

import net.brdle.collectorsreap.common.block.FruitBushBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.block.state.BlockState;

public class BeeGrowFruitGoal extends Goal {
	private final Bee bee;

	public BeeGrowFruitGoal(Bee bee) {
		this.bee = bee;
	}

	private Bee getBee() {
		return this.bee;
	}

	public boolean canBeeUse() {
		if (this.getBee().getCropsGrownSincePollination() >= 14) {
			return false;
		} else {
			return this.getBee().hasNectar();
		}
	}

	public boolean canBeeContinueToUse() {
		return this.canBeeUse();
	}

	@Override
	public boolean canUse() {
		return this.canBeeUse() && !this.getBee().isAngry();
	}

	@Override
	public boolean canContinueToUse() {
		return this.canBeeContinueToUse() && !this.getBee().isAngry();
	}

	@Override
	public void tick() {
		if (
			this.getBee().level() instanceof ServerLevel level &&
				this.getBee().getRandom().nextInt(this.adjustedTickDelay(30)) == 0
		) {
			for (int i = 1; i <= 2; ++i) {
				BlockPos blockpos = this.getBee().blockPosition().below(i);
				BlockState blockstate = level.getBlockState(blockpos);
				if (blockstate.getBlock() instanceof FruitBushBlock fruit) {
					int age = blockstate.getValue(FruitBushBlock.AGE);
					if (age == FruitBushBlock.MAX_AGE - 1) {
						fruit.performBonemeal(level, bee.getRandom(), blockpos, blockstate);
						this.getBee().level().levelEvent(2005, blockpos, 0);
						this.getBee().incrementNumCropsGrownSincePollination();
					}
				}
			}
		}
	}
}