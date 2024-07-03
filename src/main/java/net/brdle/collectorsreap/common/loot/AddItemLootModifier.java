package net.brdle.collectorsreap.common.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.brdle.collectorsreap.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AddItemLootModifier extends LootModifier {
	public static final Supplier<Codec<AddItemLootModifier>> CODEC = Suppliers.memoize(() ->
			RecordCodecBuilder.create(inst -> codecStart(inst)
					.and(ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(g -> g.item))
					.and(Codec.INT.fieldOf("minAmount").forGetter(g -> g.minAmount))
					.and(Codec.INT.fieldOf("maxAmount").forGetter(g -> g.maxAmount))
					.and(Codec.FLOAT.fieldOf("chance").forGetter(g -> g.chance))
					.apply(inst, AddItemLootModifier::new))
	);
	protected final Item item;
	protected final int minAmount;
	protected final int maxAmount;
	protected final float chance;

	public AddItemLootModifier(LootItemCondition[] conditions, Item item, int minAmount, int maxAmount, float chance) {
		super(conditions);
		this.item = item;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.chance = chance;
	}

	@Override
	protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		try {
			if (context.getRandom().nextFloat() > this.chance || this.maxAmount < 1) {
				return generatedLoot;
			}
			int amount = this.minAmount == this.maxAmount ? this.minAmount : context.getRandom().nextInt(this.maxAmount + 1 - this.minAmount) + this.minAmount;
			return (amount >= 1) ? Util.with(generatedLoot, new ItemStack(this.item, amount)) : generatedLoot;
		} catch (Exception e) {
			throw new RuntimeException("Collector's Reap add item loot modifier error", e);
		}
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return CRLootModifiers.ADD_ITEM.get();
	}
}