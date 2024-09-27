package net.brdle.collectorsreap.common.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.brdle.collectorsreap.Util;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

public class LootItemBlockIsTagCondition implements LootItemCondition {

	final TagKey<Block> tag;

	LootItemBlockIsTagCondition(TagKey<Block> tag) {
		this.tag = tag;
	}

	public static LootItemBlockIsTagCondition isTag(TagKey<Block> tag) {
		return new LootItemBlockIsTagCondition(tag);
	}

	@Override
	public @NotNull LootItemConditionType getType() {
		return CRLootItemConditions.IS_TAG.get();
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
		BlockState state = lootContext.getParamOrNull(LootContextParams.BLOCK_STATE);
		return state != null && state.is(this.tag);
	}

	public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<LootItemBlockIsTagCondition> {
		/**
		 * Serialize the value by putting its data into the JsonObject.
		 */
		public void serialize(JsonObject object, LootItemBlockIsTagCondition cond, @NotNull JsonSerializationContext context) {
			object.addProperty("tag", cond.tag.location().toString());
		}

		/**
		 * Deserialize a value by reading it from the JsonObject.
		 */
		public @NotNull LootItemBlockIsTagCondition deserialize(@NotNull JsonObject object, @NotNull JsonDeserializationContext context) {
			return new LootItemBlockIsTagCondition(BlockTags.create(Util.rl(GsonHelper.getAsString(object, "tag"))));
		}
	}
}