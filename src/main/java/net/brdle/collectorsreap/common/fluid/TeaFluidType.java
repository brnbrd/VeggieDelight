package net.brdle.collectorsreap.common.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import java.util.function.Consumer;

public class TeaFluidType extends FluidType {
	private final int tint;

	public TeaFluidType(int tint) {
		super(Properties.create()
			.sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
			.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
		);
		this.tint = tint;
	}

	@Override
	public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
		consumer.accept(new IClientFluidTypeExtensions() {
			@Override
			public int getTintColor() {
				return tint;
			}

			@Override
			public ResourceLocation getStillTexture() {
				return new ResourceLocation("block/water_still");
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return new ResourceLocation("block/water_flow");
			}
		});
	}
}