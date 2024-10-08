package net.foxirion.realitymod.item;

import net.foxirion.realitymod.RealityMod;
import net.foxirion.realitymod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RealityMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RM_BUILDING_BLOCKS = CREATIVE_MODE_TABS.register("rm_building_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PALM_PLANKS.get()))
                    .title(Component.translatable("creativetab.rm_building_blocks"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .withTabsAfter(ModCreativeModeTabs.RM_NATURAL_BLOCKS.getKey())
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.OASIS_CLAY.get());
                        pOutput.accept(ModBlocks.PALM_LOG.get());
                        pOutput.accept(ModBlocks.PALM_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_PALM_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_PALM_WOOD.get());
                        pOutput.accept(ModBlocks.PALM_PLANKS.get());
                        pOutput.accept(ModBlocks.PALM_BUTTON.get());
                        pOutput.accept(ModBlocks.PALM_DOOR.get());
                        pOutput.accept(ModBlocks.PALM_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.PALM_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.PALM_SLAB.get());
                        pOutput.accept(ModBlocks.PALM_STAIRS.get());
                        pOutput.accept(ModBlocks.PALM_FENCE.get());
                        pOutput.accept(ModBlocks.PALM_FENCE_GATE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> RM_NATURAL_BLOCKS = CREATIVE_MODE_TABS.register("rm_natural_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PALM_LOG.get()))
                    .title(Component.translatable("creativetab.rm_natural_blocks"))
                    .withTabsBefore(ModCreativeModeTabs.RM_BUILDING_BLOCKS.getKey())
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.OASIS_CLAY.get());
                        pOutput.accept(ModBlocks.PALM_LOG.get());
                        pOutput.accept(ModBlocks.PALM_LEAVES.get());
                        pOutput.accept(ModBlocks.PALM_SAPLING.get());
                        pOutput.accept(ModBlocks.FOSSIL.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_FOSSIL.get());
                        pOutput.accept(ModBlocks.FROZEN_FOSSIL.get());
                        pOutput.accept(ModBlocks.NETHER_FOSSIL.get());
                        pOutput.accept(ModBlocks.DESERT_TURTLE_EGG.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> RM_FUNCTIONAL_BLOCKS = CREATIVE_MODE_TABS.register("rm_functional_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PALM_SIGN.get()))
                    .title(Component.translatable("creativetab.rm_functional_blocks"))
                    .withTabsBefore(ModCreativeModeTabs.RM_NATURAL_BLOCKS.getKey())
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PALM_SIGN.get());
                        pOutput.accept(ModItems.PALM_HANGING_SIGN.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> RM_TOOLS_AND_UTILITIES = CREATIVE_MODE_TABS.register("rm_tools_and_utilities",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PALM_BOAT.get()))
                    .title(Component.translatable("creativetab.rm_tools_and_utilities"))
                    .withTabsBefore(ModCreativeModeTabs.RM_FUNCTIONAL_BLOCKS.getKey())
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PALM_BOAT.get());
                        pOutput.accept(ModItems.PALM_CHEST_BOAT.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> RM_COMBAT = CREATIVE_MODE_TABS.register("rm_combat",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DESERT_TURTLE_HELMET.get()))
                    .title(Component.translatable("creativetab.rm_combat"))
                    .withTabsBefore(ModCreativeModeTabs.RM_TOOLS_AND_UTILITIES.getKey())
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.DESERT_TURTLE_HELMET.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> RM_FOOD_AND_DRINKS = CREATIVE_MODE_TABS.register("rm_food_and_drinks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COCONUT.get()))
                    .title(Component.translatable("creativetab.rm_food_and_drinks"))
                    .withTabsBefore(ModCreativeModeTabs.RM_COMBAT.getKey())
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.COCONUT.get());
                        pOutput.accept(ModItems.COCONUT_MILK.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> RM_INGREDIENTS = CREATIVE_MODE_TABS.register("rm_ingredients",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DESERT_TURTLE_SCUTE.get()))
                    .title(Component.translatable("creativetab.rm_ingredients"))
                    .withTabsBefore(ModCreativeModeTabs.RM_FOOD_AND_DRINKS.getKey())
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.DESERT_TURTLE_SCUTE.get());
                        pOutput.accept(ModItems.OASIS_CLAY_BALL.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> RM_SPAWN_EGGS = CREATIVE_MODE_TABS.register("rm_spawn_eggs",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DESERT_TURTLE_SPAWN_EGG.get()))
                    .title(Component.translatable("creativetab.rm_spawn_eggs"))
                    .withTabsBefore(ModCreativeModeTabs.RM_INGREDIENTS.getKey())
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.DESERT_TURTLE_SPAWN_EGG.get());
                    }).build());
}
