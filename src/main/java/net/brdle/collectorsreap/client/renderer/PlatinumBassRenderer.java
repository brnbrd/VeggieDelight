package net.brdle.collectorsreap.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.client.model.PlatinumBassModel;
import net.brdle.collectorsreap.common.entity.PlatinumBass;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class PlatinumBassRenderer extends MobRenderer<PlatinumBass, PlatinumBassModel> {
	private static final String resource = "platinum_bass";
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Util.cr(resource), "main");
	private static final ResourceLocation TEXTURE = Util.cr("textures/entity/" + resource + "/" + resource + ".png");

	public PlatinumBassRenderer(EntityRendererProvider.Context manager) {
		super(manager, new PlatinumBassModel(manager.bakeLayer(LAYER_LOCATION)), 0.8F);
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull PlatinumBass pEntity) {
		return TEXTURE;
	}

	@Override
	protected void setupRotations(@NotNull PlatinumBass entityLiving, @NotNull PoseStack stack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
		super.setupRotations(entityLiving, stack, pAgeInTicks, pRotationYaw, pPartialTicks);
		float f = 4.3F * Mth.sin(0.6F * pAgeInTicks);
		stack.mulPose(Vector3f.YP.rotationDegrees(f));
		if (!entityLiving.isInWater()) {
			stack.translate(0.1D, 0.1D, -0.1D);
			stack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
		}
	}
}