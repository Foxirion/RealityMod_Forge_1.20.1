package net.foxirion.realitymod.datagen.loot;

import net.foxirion.realitymod.block.ModBlocks;
import net.foxirion.realitymod.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //dropSelf

        this.dropSelf(ModBlocks.PALM_BUTTON.get());
        this.dropSelf(ModBlocks.PALM_FENCE.get());
        this.dropSelf(ModBlocks.PALM_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PALM_PLANKS.get());
        this.dropSelf(ModBlocks.PALM_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PALM_LOG.get());
        this.dropSelf(ModBlocks.PALM_STAIRS.get());
        this.dropSelf(ModBlocks.PALM_SAPLING.get());
        this.dropSelf(ModBlocks.PALM_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PALM_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PALM_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_PALM_WOOD.get());

        //Complex drops

        this.add(ModBlocks.DESERT_TURTLE_EGG.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ModBlocks.DESERT_TURTLE_EGG.get())
                                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))))));

        this.add(ModBlocks.FOSSIL.get(), this::createFossilDrops);

        this.add(ModBlocks.OASIS_CLAY.get(),
                (block) -> createOasisClayDrops(ModBlocks.OASIS_CLAY.get(), ModItems.OASIS_CLAY_BALL.get()));

        this.add(ModBlocks.PALM_DOOR.get(),
                block -> createDoorTable(ModBlocks.PALM_DOOR.get()));

        this.add(ModBlocks.PALM_LEAVES.get(),
                (block) -> createPalmLeavesDrops(ModBlocks.PALM_LEAVES.get(), ModBlocks.PALM_SAPLING.get(), 0.05F, 0.0625F, 0.083333336F, 0.1F));

        this.add(ModBlocks.PALM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALM_SLAB.get()));

        this.add(ModBlocks.PALM_SIGN.get(), block ->
                createSingleItemTable(ModItems.PALM_SIGN.get()));
        this.add(ModBlocks.PALM_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.PALM_SIGN.get()));
        this.add(ModBlocks.PALM_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.PALM_HANGING_SIGN.get()));
        this.add(ModBlocks.PALM_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.PALM_HANGING_SIGN.get()));

    }

    //Methods
    private LootTable.Builder createFossilDrops(Block block) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(AlternativesEntry.alternatives(
                                                LootItem.lootTableItem(block)
                                                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                                                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))))
                                        )
                                        .otherwise(LootItem.lootTableItem(Items.BONE_MEAL)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                                                .hasEnchantment(new EnchantmentPredicate(Enchantments.BLOCK_FORTUNE, MinMaxBounds.Ints.exactly(3))))))
                                        )
                        )
                )
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.75f))
                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.exactly(0)))))
                        .add(LootItem.lootTableItem(Items.BONE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))
                                        .when(LootItemRandomChanceCondition.randomChance(0.6f)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                                .hasEnchantment(new EnchantmentPredicate(Enchantments.BLOCK_FORTUNE, MinMaxBounds.Ints.exactly(3))))))
                        )
                )
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.004f))
                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.exactly(0)))))
                        .add(LootItem.lootTableItem(Items.SKELETON_SKULL))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
                );
    }

    protected LootTable.Builder createPalmLeavesDrops(Block pPalmLeavesBlock, Block pSaplingBlock, float... pChances) {
        return this.createLeavesDrops(pPalmLeavesBlock, pSaplingBlock, pChances)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_SILK_TOUCH.invert())
                        .when(HAS_SHEARS.invert())
                        .add(((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(pPalmLeavesBlock,
                                LootItem.lootTableItem(ModItems.COCONUT.get())))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,
                                        0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));

    }
    protected LootTable.Builder createOasisClayDrops(Block block, Item ball) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block)
                                .when(HAS_SILK_TOUCH)
                                .otherwise(LootItem.lootTableItem(ball)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))))));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}