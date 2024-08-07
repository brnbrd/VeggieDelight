package net.brdle.collectorsreap.common.fluid;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CRFluids {
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.FLUID_TYPES.get(), CollectorsReap.MODID);
}
