package net.brdle.collectorsreap.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.client.model.TigerPrawnModel;
import net.brdle.collectorsreap.common.entity.TigerPrawn;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class TigerPrawnRenderer extends MobRenderer<TigerPrawn, TigerPrawnModel> {
	private static final String resource = "tiger_prawn";
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Util.cr(resource), "main");
	private static final ResourceLocation TEXTURE = Util.cr("textures/entity/" + resource + "/" + resource + ".png");

	public TigerPrawnRenderer(EntityRendererProvider.Context manager) {
		super(manager, new TigerPrawnModel(manager.bakeLayer(LAYER_LOCATION)), 0.4F);
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull TigerPrawn pEntity) {
		return TEXTURE;
	}

	@Override
	protected void setupRotations(@NotNull TigerPrawn entityLiving, @NotNull PoseStack stack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
		super.setupRotations(entityLiving, stack, pAgeInTicks, pRotationYaw, pPartialTicks);
		float f = 4.3F * Mth.sin(0.6F * pAgeInTicks);
		stack.mulPose(Vector3f.YP.rotationDegrees(f));
		if (!entityLiving.isInWater()) {
			stack.translate(0.1D, 0.1D, -0.1D);
			stack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
		}
	}
}