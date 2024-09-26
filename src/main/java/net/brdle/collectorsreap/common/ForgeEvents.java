package net.brdle.collectorsreap.common;

import java.util.List;
import java.util.Objects;
import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.effect.CREffects;
import net.brdle.collectorsreap.common.entity.BeeGoToFruitBushGoal;
import net.brdle.collectorsreap.common.entity.BeeGrowFruitGoal;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CREntityTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeEvents {

	@SubscribeEvent
	public void onBeeJoin(EntityJoinLevelEvent e) {
		if (e.getEntity() instanceof Bee bee) {
			bee.getGoalSelector().addGoal(3, new BeeGrowFruitGoal(bee));
			bee.getGoalSelector().addGoal(4, new BeeGoToFruitBushGoal(bee));
		}
	}

	@SubscribeEvent
	public void onWanderingTrader(WandererTradesEvent e) {
		if (CRConfig.verify(CRItems.LIME) && CRConfig.verify(CRItems.LIME_SEEDS)) {
			e.getGenericTrades().add((ent, r) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), Util.gs(CRItems.LIME_SEEDS), 5, 1, 1));
		}
		if (CRConfig.verify(CRItems.PORTOBELLO)) {
			e.getGenericTrades().add((ent, r) -> new MerchantOffer(new ItemStack(Items.BROWN_MUSHROOM, 4), Util.gs(CRItems.PORTOBELLO), 10, 1, 1));
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onCorrodeWeapon(LivingDamageEvent e) {
		if (e.getEntity().hasEffect(CREffects.CORROSION.get()) && e.getSource().getEntity() instanceof Player p) {
			InteractionHand hand = p.getUsedItemHand();
			ItemStack stack = p.getItemInHand(hand);
			if (stack.isDamageableItem()) {
				int damage = Objects.requireNonNull(e.getEntity().getEffect(CREffects.CORROSION.get())).getAmplifier();
				stack.hurtAndBreak(damage, p, en -> en.broadcastBreakEvent(hand));
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onCorrodeProjectile(ProjectileImpactEvent e) {
		if (
			e.getRayTraceResult().getType() == HitResult.Type.ENTITY &&
			((EntityHitResult) e.getRayTraceResult()).getEntity() instanceof LivingEntity victim &&
			victim.hasEffect(CREffects.CORROSION.get())
		) {
			Projectile proj = e.getProjectile();
			if (proj.getType().is(CREntityTags.CORROSION_IMMUNE)) {
				return;
			}
			e.setCanceled(true);
			if (!proj.level().isClientSide() && proj.level() instanceof ServerLevel server) {
				for (int i = 0; i < 3; i++) {
					server.sendParticles(CRParticleTypes.ACID.get(), proj.getRandomX(0.3D), proj.getRandomY(), proj.getRandomZ(0.3D), 1, 0.0D, 0.0D, 0.0D, 0.0D);
				}
				victim.playSound(SoundEvents.REDSTONE_TORCH_BURNOUT, 0.4F, 1.1F);
				if (proj instanceof ThrownTrident trident) {
					trident.tridentItem.hurt(5 * Objects.requireNonNull(victim.getEffect(CREffects.CORROSION.get())).getAmplifier(), trident.level().getRandom(), null);
				} else {
					proj.discard();
					proj.gameEvent(GameEvent.ENTITY_DIE);
				}
			}
		}
	}

	private static boolean validateVolatile(LivingEntity attacker) {
		return (
			attacker != null &&
			attacker.hasEffect(CREffects.VOLATILITY.get()) &&
			!attacker.getType().is(CREntityTags.INVOLATILE) &&
			!(attacker instanceof Player p && p.getAttackStrengthScale(0F) != 1F)
		);
	}

	@SubscribeEvent
	public void onVolatile(LivingDamageEvent e) {
		LivingEntity victim = e.getEntity();
		if (
			victim instanceof Mob &&
			e.getSource().getEntity() != null &&
			!victim.level().isClientSide() &&
			victim.level() instanceof ServerLevel server &&
			e.getSource().getEntity() instanceof LivingEntity attacker &&
			validateVolatile(attacker)
		) {
			server.sendParticles(CRParticleTypes.SHOCKWAVE.get(), victim.getX(), victim.getY(), victim.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
			int level = Objects.requireNonNull(attacker.getEffect(CREffects.VOLATILITY.get())).getAmplifier();
			List<Mob> mobs = server.getNearbyEntities(Mob.class,
				TargetingConditions.DEFAULT.selector(mob -> (
					mob != attacker &&
					mob != victim &&
					!mob.getType().is(CREntityTags.VOLATILITY_IMMUNE) &&
					!(mob instanceof TamableAnimal tame && tame.isTame())
				)),
				victim, victim.getBoundingBox().inflate(4.0D + ((double) level), 2.0D, 4.0D + ((double) level)))
			.stream().limit(3 + level).toList();
			if (!mobs.isEmpty()) {
				float hurtAmount = (e.getAmount() + ((float) (level - 1)) * 0.65F) / mobs.size();
				mobs.forEach(mob -> {
					Vec3 vec32 = mob.getEyePosition().subtract(victim.position().add(0.0D, 1.0F, 0.0D)).normalize();
					mob.playSound(SoundEvents.LIGHTNING_BOLT_THUNDER, 0.2F, 1.75F);
					mob.hurt(e.getSource(), hurtAmount);
					double d1 = (1.0D - mob.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE)) * 0.75D;
					mob.push(vec32.x() * d1, vec32.y() * d1 * 0.35D, vec32.z() * d1);
				});
			}
		}
	}
}