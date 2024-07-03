package net.brdle.collectorsreap.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChieftainCrabAnimation {
	public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(1.88f).looping()
			.addAnimation("SmallClaw",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 7.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.88f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("LargeClaw",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.88f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Movable",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.48f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.52f, KeyframeAnimations.degreeVec(0f, 0f, -22.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.56f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("LeftEye",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.36f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.4f, KeyframeAnimations.degreeVec(0f, 0f, -90f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.44f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("RightEye",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.36f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.4f, KeyframeAnimations.degreeVec(0f, 0f, 90f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(1.44f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR))).build();
	public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(0.24f).looping()
			.addAnimation("Main",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.12f, KeyframeAnimations.posVec(0f, -1f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.24f, KeyframeAnimations.posVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("SmallClaw",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-15.82f, -12.36f, -76.77f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.12f, KeyframeAnimations.degreeVec(-17.53f, -13.22f, -84.42f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.24f, KeyframeAnimations.degreeVec(-14f, -11.72f, -69.08f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("LargeClaw",
					new AnimationChannel(AnimationChannel.Targets.POSITION,
							new Keyframe(0f, KeyframeAnimations.posVec(1f, 1f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("LargeClaw",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(-11.64f, 0.66f, 61.56f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.12f, KeyframeAnimations.degreeVec(-13.66f, 1.08f, 79.17f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.24f, KeyframeAnimations.degreeVec(-11.64f, 0.66f, 61.56f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("Movable",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0.16f, KeyframeAnimations.degreeVec(0f, 0f, -22.5f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.24f, KeyframeAnimations.degreeVec(0f, 0f, -22.5f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("LeftLegs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.12f, KeyframeAnimations.degreeVec(0f, 0f, -10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.24f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("RightLegs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.12f, KeyframeAnimations.degreeVec(0f, 0f, 10f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.24f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR)))
			.addAnimation("BackLegs",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.12f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR),
							new Keyframe(0.24f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.LINEAR))).build();
}
