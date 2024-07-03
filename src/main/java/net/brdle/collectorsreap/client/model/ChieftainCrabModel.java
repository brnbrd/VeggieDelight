package net.brdle.collectorsreap.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.brdle.collectorsreap.client.animation.ChieftainCrabAnimation;
import net.brdle.collectorsreap.common.entity.ChieftainCrab;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.jetbrains.annotations.NotNull;

public class ChieftainCrabModel extends HierarchicalModel<ChieftainCrab> {

	private final ModelPart Main;

	public ChieftainCrabModel(ModelPart root) {
		this.Main = root.getChild("Main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Main = partdefinition.addOrReplaceChild("Main", CubeListBuilder.create().texOffs(0, 9).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(12, 24).addBox(-3.0F, -8.0F, -4.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 24).addBox(3.0F, -8.0F, -4.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-8.0F, -5.0F, -4.0F, 16.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition Mouth = Main.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(0, 4).addBox(-3.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -5.0F, -5.0F, -0.2182F, 0.0F, 0.0F));
		PartDefinition SmallClaw = Main.addOrReplaceChild("SmallClaw", CubeListBuilder.create().texOffs(14, 32).addBox(0.0F, -2.0F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -3.0F, -5.5F, 0.1762F, 0.4488F, 0.3894F));
		PartDefinition LargeClaw = Main.addOrReplaceChild("LargeClaw", CubeListBuilder.create().texOffs(28, 9).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 32).addBox(-5.0F, 0.0F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -3.0F, -7.0F, 0.1974F, -0.1289F, -0.176F));
		PartDefinition Movable = LargeClaw.addOrReplaceChild("Movable", CubeListBuilder.create().texOffs(28, 26).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(-0.01F))
				.texOffs(0, 0).addBox(-5.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition LeftLegs = Main.addOrReplaceChild("LeftLegs", CubeListBuilder.create().texOffs(16, 17).addBox(0.0F, 0.0F, -4.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -3.0F, -1.0F, 0.0F, 0.0F, -0.9599F));
		PartDefinition RightLegs = Main.addOrReplaceChild("RightLegs", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, 0.0F, -4.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -3.0F, -1.0F, 0.0F, 0.0F, 0.9599F));
		PartDefinition BackLegs = Main.addOrReplaceChild("BackLegs", CubeListBuilder.create().texOffs(0, 21).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 3.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition LeftEye = Main.addOrReplaceChild("LeftEye", CubeListBuilder.create().texOffs(4, 0).addBox(-0.5F, -1.5F, -0.01F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -5.5F, -5.0F));
		PartDefinition RightEye = Main.addOrReplaceChild("RightEye", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.5F, -0.01F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -5.5F, -5.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public @NotNull ModelPart root() {
		return Main;
	}

	@Override
	public void setupAnim(@NotNull ChieftainCrab entity, float limbSwing, float limbSwingAmount, float age, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.idleAnimationState, ChieftainCrabAnimation.IDLE, age);
		this.animate(entity.movingAnimationState, ChieftainCrabAnimation.WALK, age);
	}
}