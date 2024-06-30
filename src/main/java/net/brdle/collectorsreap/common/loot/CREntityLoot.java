package net.brdle.collectorsreap.common.loot;

import net.brdle.collectorsreap.common.entity.CREntities;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.data.loot.EntityLoot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import java.util.stream.Collectors;

public class CREntityLoot extends EntityLoot {

    @Override
    protected void addTables() {
        this.add(CREntities.TIGER_PRAWN.get(), LootTable.lootTable()
            .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(CRItems.TIGER_PRAWN.get())
                .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))));
        this.add(CREntities.PLATINUM_BASS.get(), LootTable.lootTable()
            .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(CRItems.PLATINUM_BASS.get())
                .apply(SmeltItemFunction.smelted().when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, ENTITY_ON_FIRE))))));
        this.add(CREntities.URCHIN.get(), LootTable.lootTable()
            .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(CRItems.URCHIN.get()))));
        this.add(CREntities.CHIEFTAIN_CRAB.get(), LootTable.lootTable());
        this.add(CREntities.CLAM.get(), LootTable.lootTable()
            .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(CRItems.CLAM.get()))));
    }

    @Override
    protected @NotNull Iterable<EntityType<?>> getKnownEntities() {
        return CREntities.ENTITY_TYPES.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
    }
}
