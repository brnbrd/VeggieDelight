package net.brdle.collectorsreap.common.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeMod;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

public class PearlyClawItem extends PearlItem {
	private static final UUID BLOCK_REACH = UUID.fromString("6ba3d68d-2e14-4b88-92c8-5a6796650af3");
	private static final UUID ENTITY_REACH = UUID.fromString("d646b38f-546d-4f8a-8fe6-bda88d7e7bab");
	private final Multimap<Attribute, AttributeModifier> attributes;

	public PearlyClawItem(Properties properties) {
		super(properties);
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(ForgeMod.BLOCK_REACH.get(), new AttributeModifier(BLOCK_REACH, "Claw modifier", 2.0, AttributeModifier.Operation.ADDITION));
		builder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(ENTITY_REACH, "Claw modifier", 2.0, AttributeModifier.Operation.ADDITION));
		this.attributes = builder.build();
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
		return slot.getType() == EquipmentSlot.Type.HAND ? this.attributes : super.getAttributeModifiers(slot, stack);
	}

	@Override
	public @NotNull Rarity getRarity(@NotNull ItemStack stack) {
		return Rarity.UNCOMMON;
	}
}