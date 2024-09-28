package net.brdle.collectorsreap.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.brdle.collectorsreap.client.animation.PlatinumBassAnimation;
import net.brdle.collectorsreap.common.entity.PlatinumBass;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.jetbrains.annotations.NotNull;

public class PlatinumBassModel extends HierarchicalModel<PlatinumBass> {
	private final ModelPart body;
	private final ModelPart leftFin;
	private final ModelPart rightFin;
	private final ModelPart head;
	private final ModelPart tail;

	public PlatinumBassModel(ModelPart root) {
		this.body = root.getChild("Body");
		this.leftFin = this.body.getChild("LeftFin");
		this.rightFin = this.body.getChild("RightFin");
		this.head = this.body.getChild("Head");
		this.tail = this.body.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition root = meshdefinition.getRoot();
		PartDefinition body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -12.0F, -1.0F, 6.0F, 10.0F, 16.0F, new CubeDeformation(0.0F))
			.texOffs(0, 11).addBox(0.0F, -15.0F, 3.0F, 0.0F, 16.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -8.0F));
		PartDefinition LeftFin = body.addOrReplaceChild("LeftFin", CubeListBuilder.create().texOffs(30, 26).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -6.0F, 0.0F, 0.0F, 0.6981F, 0.0F));
		PartDefinition RightFin = body.addOrReplaceChild("RightFin", CubeListBuilder.create().texOffs(30, 20).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -6.0F, 0.0F, 0.0F, -0.6981F, 0.0F));
		PartDefinition Head = body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -7.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
			.texOffs(28, 0).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -1.0F));
		PartDefinition Tail = body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(26, 38).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
			.texOffs(0, 0).addBox(0.0F, -5.0F, 3.0F, 0.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 15.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return body;
	}

	@Override
	public void setupAnim(PlatinumBass entity, float pLimbSwing, float pLimbSwingAmount, float age, float pNetHeadYaw, float pHeadPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.swimAnimationState, PlatinumBassAnimation.MODEL_SWIM, age);
		this.animate(entity.drownAnimationState, PlatinumBassAnimation.MODEL_DROWN, age);
	}
}