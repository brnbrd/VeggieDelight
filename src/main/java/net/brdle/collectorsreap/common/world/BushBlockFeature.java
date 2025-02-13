package net.brdle.collectorsreap.common.world;

import com.mojang.serialization.Codec;
import net.brdle.collectorsreap.common.block.FruitBushBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class BushBlockFeature extends Feature<SimpleBlockConfiguration> {
	public BushBlockFeature(Codec<SimpleBlockConfiguration> c) {
		super(c);
	}

	public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> pContext) {
		WorldGenLevel worldgenlevel = pContext.level();
		BlockPos blockpos = pContext.origin();
		BlockState blockstate = pContext.config().toPlace().getState(pContext.random(), blockpos);
		if (blockstate.canSurvive(worldgenlevel, blockpos) && worldgenlevel.isEmptyBlock(blockpos.above())) {
			if (blockstate.getBlock() instanceof FruitBushBlock) {
				FruitBushBlock.placeAt(worldgenlevel, blockstate, blockpos, 2);
				return true;
			}
		}
		return false;
	}
}