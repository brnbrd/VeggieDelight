package net.brdle.collectorsreap.compat.letfishlove;

import com.uraneptus.letfishlove.common.blocks.RoeBlock;
import com.uraneptus.letfishlove.core.other.LFLProperties;
import net.minecraft.world.entity.EntityType;
import java.util.function.Supplier;

public class CRRoeBlock extends RoeBlock {
	public CRRoeBlock(Supplier<EntityType<?>> fish) {
		super(fish, LFLProperties.roeBlockProperties());
	}
}