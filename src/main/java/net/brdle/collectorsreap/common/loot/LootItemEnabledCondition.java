package net.brdle.collectorsreap.common.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.brdle.collectorsreap.common.config.CRConfig;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

public class LootItemEnabledCondition implements LootItemCondition {

	final String item;

	LootItemEnabledCondition(String item) {
		this.item = item;
	}

	public static LootItemEnabledCondition enabled(String item) {
		return new LootItemEnabledCondition(item);
	}

	@Override
	public @NotNull LootItemConditionType getType() {
		return CRLootItemConditions.ENABLED.get();
	}

	/**
	 * Evaluates this predicate on the given argument.
	 *
	 * @param lootContext the input argument
	 * @return {@code true} if the input argument matches the predicate,
	 * otherwise {@code false}
	 */
	@Override
	public boolean test(LootContext lootContext) {
		return CRConfig.verify(this.item);
	}

	public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<LootItemEnabledCondition> {
		/**
		 * Serialize the value by putting its data into the JsonObject.
		 */
		public void serialize(JsonObject object, LootItemEnabledCondition cond, @NotNull JsonSerializationContext context) {
			object.addProperty("item", cond.item);
		}

		/**
		 * Deserialize a value by reading it from the JsonObject.
		 */
		public @NotNull LootItemEnabledCondition deserialize(@NotNull JsonObject object, @NotNull JsonDeserializationContext context) {
			return new LootItemEnabledCondition(GsonHelper.getAsString(object, "item"));
		}
	}
}