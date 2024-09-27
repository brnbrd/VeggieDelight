package net.brdle.collectorsreap.common.block;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import java.util.Objects;
import java.util.function.Supplier;

public class EffectCakeBlock extends CakeBlock {

	private final Supplier<Item> slice;

	public EffectCakeBlock(Properties prop, Supplier<Item> slice) {
		super(prop);
		this.slice = slice;
	}

	public Item getSlice() {
		return slice.get();
	}

	@Override
	public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (
			itemstack.is(ItemTags.CANDLES) &&
			state.getValue(BITES) == 0 &&
			Block.byItem(itemstack.getItem()) instanceof CandleBlock candle &&
			EffectCandleCakeBlock.exists(this, candle)
		) {
			if (!player.isCreative()) {
				itemstack.shrink(1);
			}
			level.playSound(null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
			level.setBlockAndUpdate(pos, EffectCandleCakeBlock.byCakeCandle(this, candle));
			level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
			player.awardStat(Stats.ITEM_USED.get(itemstack.getItem()));
			return InteractionResult.SUCCESS;
		}
		if (level.isClientSide()) {
			if (itemstack.is(ForgeTags.TOOLS_KNIVES)) {
				return cutSlice(level, pos, state, player);
			}
			if (eatSlice(level, pos, state, player).consumesAction()) {
				return InteractionResult.SUCCESS;
			}
			if (itemstack.isEmpty()) {
				return InteractionResult.CONSUME;
			}
		}
		if (itemstack.is(ForgeTags.TOOLS_KNIVES)) {
			return cutSlice(level, pos, state, player);
		}
		return eatSlice(level, pos, state, player);
	}

	/**
	 * Eats a slice from the pie, feeding the player.
	 */
	public InteractionResult eatSlice(Level level, BlockPos pos, BlockState state, Player player) {
		if (!player.canEat(false)) {
			return InteractionResult.PASS;
		}
		player.awardStat(Stats.EAT_CAKE_SLICE);
		Item slice = this.getSlice();
		ItemStack sliceStack = slice.getDefaultInstance();
		player.getFoodData().eat(slice, sliceStack, player);
		EffectCakeBlock.addEatEffect(sliceStack, level, player);
		level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
		int bites = state.getValue(BITES);
		if (bites < 6) {
			level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
		} else {
			level.removeBlock(pos, false);
			level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
		}
		return InteractionResult.SUCCESS;
	}

	/**
	 * Cuts off a bite and drops a slice item, without feeding the player.
	 */
	public InteractionResult cutSlice(Level level, BlockPos pos, BlockState state, Player player) {
		int bites = state.getValue(BITES);
		if (bites < 6) {
			level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
		} else {
			level.removeBlock(pos, false);
		}
		Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), this.getSlice().getDefaultInstance());
		level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
		return InteractionResult.SUCCESS;
	}

	public static void addEatEffect(ItemStack pFood, Level pLevel, Player p) {
		Item item = pFood.getItem();
		if (item.isEdible() && pFood.getFoodProperties(p) != null) {
			for (Pair<MobEffectInstance, Float> pair : Objects.requireNonNull(pFood.getFoodProperties(p)).getEffects()) {
				if (!pLevel.isClientSide && pair.getFirst() != null && pLevel.random.nextFloat() < pair.getSecond()) {
					p.addEffect(new MobEffectInstance(pair.getFirst()));
				}
			}
		}
	}
}