package net.brdle.collectorsreap.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ClamAnimation {
	public static final AnimationDefinition CLAM_IDLE = AnimationDefinition.Builder.withLength(2f).looping()
			.addAnimation("Top",
					new AnimationChannel(AnimationChannel.Targets.ROTATION,
							new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(1f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM),
							new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
									AnimationChannel.Interpolations.CATMULLROM))).build();
}