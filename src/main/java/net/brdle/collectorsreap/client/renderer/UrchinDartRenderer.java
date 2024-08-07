package net.brdle.collectorsreap.client.renderer;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.entity.UrchinDart;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class UrchinDartRenderer extends ArrowRenderer<UrchinDart> {
	public static final ResourceLocation URCHIN_DART_LOCATION = Util.cr("textures/entity/urchin_dart/urchin_dart.png");

	public UrchinDartRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull UrchinDart dart) {
		return URCHIN_DART_LOCATION;
	}
}