package net.brdle.collectorsreap.common.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.jetbrains.annotations.NotNull;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Set;
import java.util.function.Supplier;

public class CRFishingLoot extends LootModifier {
	public static final Supplier<Codec<CRFishingLoot>> CODEC = Suppliers.memoize(() ->
		RecordCodecBuilder.create(inst -> codecStart(inst).and(
			inst.group(
				Codec.STRING.fieldOf("table").xmap(CRLootModifiers::getLootTableReference, CRLootModifiers::getString).forGetter(m -> m.lootTable),
				Codec.FLOAT.fieldOf("chance").forGetter(m -> m.chance)
			)).apply(inst, CRFishingLoot::new)
		)
	);

	private static final Field LOOT_FIELD = ObfuscationReflectionHelper.findField(LootContext.class, "f_278466_"); // Version-specific field name
	private final LootTableReference lootTable;
	private final float chance;

	public CRFishingLoot(LootItemCondition[] conditions, LootTableReference lootTable, float chance) {
		super(conditions);
		this.lootTable = lootTable;
		this.chance = chance;
	}

	/**
	 * Applies the modifier to the generated loot (all loot conditions have already been checked
	 * and have returned true).
	 *
	 * @param generatedLoot the list of ItemStacks that will be dropped, generated by loot tables
	 * @param context       the LootContext, identical to what is passed to loot tables
	 * @return modified loot drops
	 */
	@Override
	protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		try {
			@SuppressWarnings("unchecked") Set<LootTable> set = Collections.unmodifiableSet((Set<LootTable>) LOOT_FIELD.get(context));
			if (set.isEmpty() && context.getRandom().nextFloat() <= chance) {
				ObjectArrayList<ItemStack> loot = ObjectArrayList.of();
				lootTable.createItemStack(loot::add, context);
				return loot;
			} else {
				return generatedLoot;
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException("Collector's Reap fishing loot table error", e);
		}
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return CRLootModifiers.FISHING.get();
	}
}