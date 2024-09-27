package net.brdle.collectorsreap.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import java.util.Map;
import java.util.function.Predicate;

public class CRMilkshakeCauldronBlock extends LayeredCauldronBlock {
	public static final Predicate<Biome.Precipitation> FALSE = (precipitation) -> false;

	public CRMilkshakeCauldronBlock(Map<Item, CauldronInteraction> map) {
		super(BlockBehaviour.Properties.copy(Blocks.CAULDRON).requiresCorrectToolForDrops().noOcclusion(), FALSE, map);
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
		return new ItemStack(Items.CAULDRON);
	}
}