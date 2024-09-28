package net.brdle.collectorsreap;

import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.proxy.ClientProxy;
import net.brdle.collectorsreap.proxy.CommonProxy;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CollectorsReap.MODID)
public class CollectorsReap {
	public static final String MODID = "collectorsreap";
	private static final Logger LOGGER = LogManager.getLogger();
	public static CollectorsReap instance;
	public static CommonProxy proxy;

	public CollectorsReap() {
		instance = this;
		proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
		proxy.start();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CRConfig.COMMON);
	}

	public static Logger getLogger() {
		return LOGGER;
	}
}