package net.brdle.collectorsreap.compat.letfishlove;

import com.uraneptus.letfishlove.common.items.RoeItem;
import net.minecraft.world.level.block.Block;
import java.util.function.Supplier;

public class CRRoeItem extends RoeItem {
	public CRRoeItem(Supplier<Block> roeBlock) {
		super(roeBlock);
	}
}