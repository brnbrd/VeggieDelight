package net.brdle.collectorsreap.common.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.brdle.collectorsreap.Util;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.util.Lazy;
import org.jetbrains.annotations.NotNull;

public class PearlyClawItem extends PearlItem {
	private final Lazy<Multimap<Attribute, AttributeModifier>> attributes;

	public PearlyClawItem(Properties properties) {
		super(properties);
		this.attributes = Lazy.of(() -> {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.put(ForgeMod.BLOCK_REACH.get(), new AttributeModifier(Util.BLOCK_REACH,
				"Block reach modifier", 2.0D, AttributeModifier.Operation.ADDITION));
			return builder.build();
		});
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
		Multimap<Attribute, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);
		if (slot.getType() == EquipmentSlot.Type.HAND) {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.putAll(mods);
			builder.putAll(this.attributes.get());
			return builder.build();
		}
		return mods;
	}

	@Override
	public @NotNull Rarity getRarity(@NotNull ItemStack stack) {
		return Rarity.UNCOMMON;
	}
}