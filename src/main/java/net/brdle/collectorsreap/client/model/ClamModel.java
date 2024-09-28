package net.brdle.collectorsreap.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.brdle.collectorsreap.client.animation.ClamAnimation;
import net.brdle.collectorsreap.common.entity.Clam;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.jetbrains.annotations.NotNull;

public class ClamModel extends HierarchicalModel<Clam> {
	private final ModelPart Main;

	public ClamModel(ModelPart root) {
		this.Main = root.getChild("Main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Main = partdefinition.addOrReplaceChild("Main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Top = Main.addOrReplaceChild("Top", CubeListBuilder.create().texOffs(0, 13).addBox(-5.0F, -1.0F, -8.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
			.texOffs(24, 28).addBox(-4.0F, -3.0F, -7.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -6.0F, 2.0F));
		PartDefinition Hinge = Main.addOrReplaceChild("Hinge", CubeListBuilder.create().texOffs(30, 4).addBox(-4.0F, -5.0F, 4.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
			.texOffs(30, 0).addBox(-5.0F, -5.0F, 5.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Bottom = Main.addOrReplaceChild("Bottom", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.1F))
			.texOffs(0, 0).addBox(-5.0F, -5.0F, -6.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(@NotNull Clam entity, float limbSwing, float limbSwingAmount, float age, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.openAnimationState, ClamAnimation.CLAM_IDLE, age);
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public @NotNull ModelPart root() {
		return this.Main;
	}
}