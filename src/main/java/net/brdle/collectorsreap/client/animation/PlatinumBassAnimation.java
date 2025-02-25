package net.brdle.collectorsreap.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PlatinumBassAnimation {
	public static final AnimationDefinition MODEL_SWIM = AnimationDefinition.Builder.withLength(0.96f).looping()
		.addAnimation("Whole",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 15f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.48f, KeyframeAnimations.degreeVec(0f, -15f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.96f, KeyframeAnimations.degreeVec(0f, 15f, 0f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("Head",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.08f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.16f, KeyframeAnimations.degreeVec(0f, 2.5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.24f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.32f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.4f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.48f, KeyframeAnimations.degreeVec(0f, -7.5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.56f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.64f, KeyframeAnimations.degreeVec(0f, -2.5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.72f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.8f, KeyframeAnimations.degreeVec(0f, 2.5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.88f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.96f, KeyframeAnimations.degreeVec(0f, 7.5f, 0f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("Tail",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 30f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.04f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.08f, KeyframeAnimations.degreeVec(0f, 20f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.12f, KeyframeAnimations.degreeVec(0f, 15f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.16f, KeyframeAnimations.degreeVec(0f, 10f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.2f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.24f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.28f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.32f, KeyframeAnimations.degreeVec(0f, -10f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.36f, KeyframeAnimations.degreeVec(0f, -15f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.4f, KeyframeAnimations.degreeVec(0f, -20f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.44f, KeyframeAnimations.degreeVec(0f, -25f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.48f, KeyframeAnimations.degreeVec(0f, -30f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.52f, KeyframeAnimations.degreeVec(0f, -25f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.56f, KeyframeAnimations.degreeVec(0f, -20f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.6f, KeyframeAnimations.degreeVec(0f, -15f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.64f, KeyframeAnimations.degreeVec(0f, -10f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.68f, KeyframeAnimations.degreeVec(0f, -5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.72f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.76f, KeyframeAnimations.degreeVec(0f, 5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.8f, KeyframeAnimations.degreeVec(0f, 10f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.84f, KeyframeAnimations.degreeVec(0f, 15f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.88f, KeyframeAnimations.degreeVec(0f, 20f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.92f, KeyframeAnimations.degreeVec(0f, 25f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.96f, KeyframeAnimations.degreeVec(0f, 30f, 0f),
					AnimationChannel.Interpolations.LINEAR))).build();

	public static final AnimationDefinition MODEL_DROWN = AnimationDefinition.Builder.withLength(0.16f).looping()
		.addAnimation("Whole",
			new AnimationChannel(AnimationChannel.Targets.POSITION,
				new Keyframe(0f, KeyframeAnimations.posVec(7f, 2f, 2f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("Whole",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -90f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("Whole",
			new AnimationChannel(AnimationChannel.Targets.SCALE,
				new Keyframe(0f, KeyframeAnimations.scaleVec(1.1f, 1f, 1f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.04f, KeyframeAnimations.scaleVec(1.2f, 1f, 1f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.08f, KeyframeAnimations.scaleVec(1.1f, 1f, 1f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.12f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("LeftFin",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -32.5f, 0f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("RightFin",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 35f, 0f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("Head",
			new AnimationChannel(AnimationChannel.Targets.SCALE,
				new Keyframe(0f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("Tail",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -17.5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.08f, KeyframeAnimations.degreeVec(0f, 17.5f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.16f, KeyframeAnimations.degreeVec(0f, -17.5f, 0f),
					AnimationChannel.Interpolations.LINEAR))).build();
}