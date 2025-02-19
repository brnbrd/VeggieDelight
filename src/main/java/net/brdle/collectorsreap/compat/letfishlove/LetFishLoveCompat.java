package net.brdle.collectorsreap.compat.letfishlove;

import net.brdle.collectorsreap.common.block.CRBlocks;
import net.brdle.collectorsreap.common.entity.CREntities;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class LetFishLoveCompat {
	public static Block roeBlock() {
		return new CRRoeBlock(CREntities.PLATINUM_BASS::get);
	}

	public static Item roeItem() {
		return new CRRoeItem(CRBlocks.PLATINUM_BASS_ROE);
	}
}