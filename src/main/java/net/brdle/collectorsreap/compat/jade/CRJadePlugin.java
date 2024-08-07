package net.brdle.collectorsreap.compat.jade;

import net.brdle.collectorsreap.common.block.FruitBushBlock;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class CRJadePlugin implements IWailaPlugin {

	@Override
	public void register(IWailaCommonRegistration registration) {
	}

	@Override
	public void registerClient(IWailaClientRegistration registration) {
		registration.registerBlockComponent(CRCropProgress.INSTANCE, FruitBushBlock.class);
	}
}
