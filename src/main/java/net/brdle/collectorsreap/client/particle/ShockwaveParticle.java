package net.brdle.collectorsreap.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.HugeExplosionParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ShockwaveParticle extends HugeExplosionParticle {
	ShockwaveParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pQuadSizeMultiplier, SpriteSet pSprites) {
		super(pLevel, pX, pY, pZ, pQuadSizeMultiplier, pSprites);
		this.lifetime = 12;
		this.quadSize = 3.0F;
		this.setSpriteFromAge(pSprites);
	}

	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprite;

		public Provider(SpriteSet pSprites) {
			this.sprite = pSprites;
		}

		public Particle createParticle(@NotNull SimpleParticleType pType, @NotNull ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
			ShockwaveParticle acid = new ShockwaveParticle(pLevel, pX, pY, pZ, pXSpeed, this.sprite);
			acid.pickSprite(this.sprite);
			return acid;
		}
	}
}