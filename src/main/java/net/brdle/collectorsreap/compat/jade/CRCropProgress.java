package net.brdle.collectorsreap.compat.jade;

import net.brdle.collectorsreap.Util;
import net.brdle.collectorsreap.common.block.FruitBushBlock;
import net.brdle.collectorsreap.common.block.LimeBushBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum CRCropProgress implements IBlockComponentProvider {
	INSTANCE;

	@Override
	public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
		BlockState state = blockAccessor.getBlockState();
		Block block = state.getBlock();
		if (block instanceof FruitBushBlock) {
			addMaturityTooltip(tooltip, state.getValue(FruitBushBlock.AGE) / (float) FruitBushBlock.MAX_AGE);
		}
	}

	private static void addMaturityTooltip(ITooltip tooltip, float growthValue) {
		growthValue *= 100.0F;
		if (growthValue < 100.0F)
			tooltip.add(Component.translatable("tooltip.jade.crop_growth", Component.literal(String.format("%.0f%%", growthValue)).withStyle(ChatFormatting.WHITE)));
		else
			tooltip.add(Component.translatable("tooltip.jade.crop_growth", Component.translatable("tooltip.jade.crop_mature").withStyle(ChatFormatting.GREEN)));
	}

	@Override
	public ResourceLocation getUid() {
		return Util.cr("crop_progress");
	}
}
