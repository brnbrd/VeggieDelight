package net.brdle.collectorsreap.common.fluid;

import net.brdle.collectorsreap.CollectorsReap;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CRFluids {

	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, CollectorsReap.MODID);
	public static final DeferredRegister<FluidType> TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, CollectorsReap.MODID);

	public static final RegistryObject<FluidType> LIME_GREEN_TEA_TYPE = TYPES.register("lime_green_tea_type",
		() -> new TeaFluidType(0xff95ac38));
	public static final RegistryObject<FluidType> POMEGRANATE_BLACK_TEA_TYPE = TYPES.register("pomegranate_black_tea_type",
		() -> new TeaFluidType(0xff900f2f));

	public static void create(IEventBus bus) {
		FLUIDS.register(bus);
		TYPES.register(bus);
	}	public static final RegistryObject<FlowingFluid> LIME_GREEN_TEA = FLUIDS.register("lime_green_tea",
		() -> new ForgeFlowingFluid.Source(CRFluids.LIME_GREEN_TEA_PROPERTIES));



	public static final RegistryObject<FlowingFluid> FLOWING_LIME_GREEN_TEA = FLUIDS.register("flowing_lime_green_tea",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.LIME_GREEN_TEA_PROPERTIES));


	public static final RegistryObject<FlowingFluid> POMEGRANATE_BLACK_TEA = FLUIDS.register("pomegranate_black_tea",
		() -> new ForgeFlowingFluid.Source(CRFluids.POMEGRANATE_BLACK_TEA_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_POMEGRANATE_BLACK_TEA = FLUIDS.register("flowing_pomegranate_black_tea",
		() -> new ForgeFlowingFluid.Flowing(CRFluids.POMEGRANATE_BLACK_TEA_PROPERTIES));

	public static final ForgeFlowingFluid.Properties LIME_GREEN_TEA_PROPERTIES = new ForgeFlowingFluid.Properties(LIME_GREEN_TEA_TYPE, LIME_GREEN_TEA, FLOWING_LIME_GREEN_TEA);
	public static final ForgeFlowingFluid.Properties POMEGRANATE_BLACK_TEA_PROPERTIES = new ForgeFlowingFluid.Properties(POMEGRANATE_BLACK_TEA_TYPE, POMEGRANATE_BLACK_TEA, FLOWING_POMEGRANATE_BLACK_TEA);


}