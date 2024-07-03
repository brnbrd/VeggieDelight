package net.brdle.collectorsreap.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class AcidParticle extends TextureSheetParticle {
	AcidParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
		super(pLevel, pX, pY, pZ);
		this.setSize(0.02F, 0.02F);
		this.friction = 0.96F;
		this.xd = this.xd * (double) 0.01F + pXSpeed;
		this.yd = this.yd * (double) 0.01F + pYSpeed;
		this.zd = this.zd * (double) 0.01F + pZSpeed;
		this.x += (this.random.nextFloat() - this.random.nextFloat()) * 0.05F;
		this.y += (this.random.nextFloat() - this.random.nextFloat()) * 0.05F;
		this.z += (this.random.nextFloat() - this.random.nextFloat()) * 0.05F;
		this.lifetime = (int) (8.0D / (Math.random() * 0.8D + 0.2D)) + 6;
	}

	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		if (this.lifetime-- <= 0) {
			this.remove();
		} else {
			this.yd -= 0.002D;
			this.move(this.xd, this.yd, this.zd);
			this.xd *= 0.85F;
			this.yd *= 0.85F;
			this.zd *= 0.85F;
		}
	}

	public @NotNull ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprite;

		public Provider(SpriteSet pSprites) {
			this.sprite = pSprites;
		}

		public Particle createParticle(@NotNull SimpleParticleType pType, @NotNull ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
			AcidParticle acid = new AcidParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
			acid.pickSprite(this.sprite);
			return acid;
		}
	}
}