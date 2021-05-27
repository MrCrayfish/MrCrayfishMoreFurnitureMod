package com.mrcrayfish.morefurniture.datagen;

import com.mrcrayfish.morefurniture.Generator;
import com.mrcrayfish.morefurniture.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Consumer;

public class RecipeGen extends RecipeProvider
{
    public RecipeGen(DataGenerator generator)
    {
        super(generator);
    }

    private static Block getResultBlock(Generator.Variant variant, Generator.FurnitureType type, boolean stripped)
    {
        try
        {
            String fieldFormat = stripped ? "%s_%s_STRIPPED_%s" : "%s_%s_%s";
            String fieldName = String.format(fieldFormat, variant.getLog().getRegistryName().getNamespace().toUpperCase(), type.getId().toUpperCase(), variant.getId().toUpperCase());
            RegistryObject<Block> block = (RegistryObject<Block>) ModBlocks.class.getField(fieldName).get(null);
            return block.get();
        }
        catch(NoSuchFieldException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static Block getUpgradedFence(Generator.Variant variant, boolean stripped)
    {
        try
        {
            String fieldFormat = stripped ? "%s_UPGRADED_FENCE_STRIPPED_%s" : "%s_UPGRADED_FENCE_%s";
            String fieldName = String.format(fieldFormat, variant.getLog().getRegistryName().getNamespace().toUpperCase(), variant.getId().toUpperCase());
            RegistryObject<Block> block = (RegistryObject<Block>) ModBlocks.class.getField(fieldName).get(null);
            return block.get();
        }
        catch(NoSuchFieldException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        Generator generator = new Generator();
        generator.getRegisteredVariants().forEach(variant -> {
            table(consumer, getResultBlock(variant, Generator.TABLE, false), variant.getLog(), variant.getPlanks());
            chair(consumer, getResultBlock(variant, Generator.CHAIR, false), variant.getLog(), variant.getPlanks());
            coffeeTable(consumer, getResultBlock(variant, Generator.COFFEE_TABLE, false), variant.getLog(), variant.getPlanks());
            cabinet(consumer, getResultBlock(variant, Generator.CABINET, false), variant.getLog(), variant.getPlanks());
            bedsideCabinet(consumer, getResultBlock(variant, Generator.BEDSIDE_CABINET, false), variant.getLog(), variant.getPlanks());
            desk(consumer, getResultBlock(variant, Generator.DESK, false), variant.getLog(), variant.getPlanks());
            deskCabinet(consumer, getResultBlock(variant, Generator.DESK_CABINET, false), variant.getLog(), variant.getPlanks());
            blinds(consumer, getResultBlock(variant, Generator.BLINDS, false), variant.getLog());
            upgradedFence(consumer, getResultBlock(variant, Generator.UPGRADED_FENCE, false), variant.getLog());
            upgradedGate(consumer, getResultBlock(variant, Generator.UPGRADED_GATE, false), variant.getLog());
            crate(consumer, getResultBlock(variant, Generator.CRATE, false), variant.getLog(), variant.getPlanks());
            parkBench(consumer, getResultBlock(variant, Generator.PARK_BENCH, false), variant.getLog(), variant.getPlanks());
            kitchenCounter(consumer, getResultBlock(variant, Generator.KITCHEN_COUNTER, false), variant.getLog(), variant.getPlanks());
            kitchenDrawer(consumer, getResultBlock(variant, Generator.KITCHEN_DRAWER, false), variant.getLog(), variant.getPlanks());
            kitchenSink(consumer, getResultBlock(variant, Generator.KITCHEN_SINK_LIGHT, false), Blocks.WHITE_CONCRETE, variant.getPlanks());
            kitchenSink(consumer, getResultBlock(variant, Generator.KITCHEN_SINK_DARK, false), Blocks.GRAY_CONCRETE, variant.getPlanks());
            mailBox(consumer, getResultBlock(variant, Generator.MAIL_BOX, false), getUpgradedFence(variant, false), variant.getLog().getRegistryName().getNamespace());

            if(variant.getStrippedLog() != null)
            {
                table(consumer, getResultBlock(variant, Generator.TABLE, true), variant.getStrippedLog(), variant.getLog());
                chair(consumer, getResultBlock(variant, Generator.CHAIR, true), variant.getStrippedLog(), variant.getLog());
                coffeeTable(consumer, getResultBlock(variant, Generator.COFFEE_TABLE, true), variant.getStrippedLog(), variant.getLog());
                cabinet(consumer, getResultBlock(variant, Generator.CABINET, true), variant.getLog(), variant.getStrippedLog());
                bedsideCabinet(consumer, getResultBlock(variant, Generator.BEDSIDE_CABINET, true), variant.getStrippedLog(), variant.getLog());
                desk(consumer, getResultBlock(variant, Generator.DESK, true), variant.getStrippedLog(), variant.getLog());
                deskCabinet(consumer, getResultBlock(variant, Generator.DESK_CABINET, true), variant.getStrippedLog(), variant.getLog());
                blinds(consumer, getResultBlock(variant, Generator.BLINDS, true), variant.getStrippedLog());
                upgradedFence(consumer, getResultBlock(variant, Generator.UPGRADED_FENCE, true), variant.getStrippedLog());
                upgradedGate(consumer, getResultBlock(variant, Generator.UPGRADED_GATE, true), variant.getStrippedLog());
                crate(consumer, getResultBlock(variant, Generator.CRATE, true), variant.getStrippedLog(), variant.getLog());
                parkBench(consumer, getResultBlock(variant, Generator.PARK_BENCH, true), variant.getLog(), variant.getStrippedLog());
                kitchenCounter(consumer, getResultBlock(variant, Generator.KITCHEN_COUNTER, true), variant.getLog(), variant.getStrippedLog());
                kitchenDrawer(consumer, getResultBlock(variant, Generator.KITCHEN_DRAWER, true), variant.getLog(), variant.getStrippedLog());
                kitchenSink(consumer, getResultBlock(variant, Generator.KITCHEN_SINK_LIGHT, true), Blocks.WHITE_CONCRETE, variant.getStrippedLog());
                kitchenSink(consumer, getResultBlock(variant, Generator.KITCHEN_SINK_DARK, true), Blocks.GRAY_CONCRETE, variant.getStrippedLog());
                mailBox(consumer, getResultBlock(variant, Generator.MAIL_BOX, true), getUpgradedFence(variant, true), variant.getLog().getRegistryName().getNamespace());
            }
        });
    }

    private static void table(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider table, IItemProvider log, IItemProvider planks)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(table, 4).patternLine("LLL").patternLine(" P ").patternLine(" P ").key('L', log).key('P', planks).setGroup("table").addCriterion("has_log", hasItem(log)).addCriterion("has_planks", hasItem(planks))::build).generateAdvancement().build(recipeConsumer, table.asItem().getRegistryName());
    }

    private static void chair(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider chair, IItemProvider log, IItemProvider planks)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(chair, 4).patternLine("L  ").patternLine("LLL").patternLine("P P").key('L', log).key('P', planks).setGroup("chair").addCriterion("has_log", hasItem(log)).addCriterion("has_planks", hasItem(planks))::build).generateAdvancement().build(recipeConsumer, chair.asItem().getRegistryName());
    }

    private static void coffeeTable(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider table, IItemProvider log, IItemProvider planks)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(table, 4).patternLine("LLL").patternLine("P P").key('L', log).key('P', planks).setGroup("coffee_table").addCriterion("has_log", hasItem(log)).addCriterion("has_planks", hasItem(planks))::build).generateAdvancement().build(recipeConsumer, table.asItem().getRegistryName());
    }

    private static void cabinet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider cabinet, IItemProvider log, IItemProvider planks)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(cabinet, 2).patternLine("PPL").patternLine("P L").patternLine("PPL").key('L', log).key('P', planks).setGroup("cabinet").addCriterion("has_log", hasItem(log)).addCriterion("has_planks", hasItem(planks))::build).generateAdvancement().build(recipeConsumer, cabinet.asItem().getRegistryName());
    }

    private static void bedsideCabinet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider cabinet, IItemProvider log, IItemProvider planks)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(cabinet, 2).patternLine("LLL").patternLine("P P").patternLine("PPP").key('L', log).key('P', planks).setGroup("bedside_cabinet").addCriterion("has_log", hasItem(log)).addCriterion("has_planks", hasItem(planks))::build).generateAdvancement().build(recipeConsumer, cabinet.asItem().getRegistryName());
    }

    private static void desk(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider desk, IItemProvider log, IItemProvider planks)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(desk, 2).patternLine("LLL").patternLine("P P").patternLine("P P").key('L', log).key('P', planks).setGroup("desk").addCriterion("has_log", hasItem(log)).addCriterion("has_planks", hasItem(planks))::build).generateAdvancement().build(recipeConsumer, desk.asItem().getRegistryName());
    }

    private static void deskCabinet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider desk, IItemProvider log, IItemProvider planks)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(desk, 2).patternLine("LLL").patternLine("PPP").patternLine("P P").key('L', log).key('P', planks).setGroup("desk_cabinet").addCriterion("has_log", hasItem(log)).addCriterion("has_planks", hasItem(planks))::build).generateAdvancement().build(recipeConsumer, desk.asItem().getRegistryName());
    }

    private static void blinds(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider blinds, IItemProvider log)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(blinds, 2).patternLine("LLL").patternLine("SSS").patternLine("SSS").key('L', log).key('S', Tags.Items.RODS_WOODEN).setGroup("blinds").addCriterion("has_log", hasItem(log))::build).generateAdvancement().build(recipeConsumer, blinds.asItem().getRegistryName());
    }

    private static void upgradedFence(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider fence, IItemProvider log)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(fence, 12).patternLine("LSL").patternLine("LSL").key('L', log).key('S', Tags.Items.RODS_WOODEN).setGroup("upgraded_fence").addCriterion("has_log", hasItem(log))::build).generateAdvancement().build(recipeConsumer, fence.asItem().getRegistryName());
    }

    private static void upgradedGate(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider gate, IItemProvider log)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(gate, 2).patternLine("LGL").key('L', log).key('G', Tags.Items.FENCE_GATES_WOODEN).setGroup("upgraded_gate").addCriterion("has_log", hasItem(log)).addCriterion("has_gate", hasItem(Tags.Items.FENCE_GATES_WOODEN))::build).generateAdvancement().build(recipeConsumer, gate.asItem().getRegistryName());
    }

    private static void crate(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider crate, IItemProvider log, IItemProvider planks)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(crate, 2).patternLine("LPL").patternLine("P P").patternLine("LPL").key('L', log).key('P', planks).setGroup("crate").addCriterion("has_log", hasItem(log)).addCriterion("has_planks", hasItem(planks))::build).generateAdvancement().build(recipeConsumer, crate.asItem().getRegistryName());
    }

    private static void parkBench(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider bench, IItemProvider log, IItemProvider planks)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(bench, 4).patternLine("PPP").patternLine("PPP").patternLine("L L").key('L', log).key('P', planks).setGroup("park_bench").addCriterion("has_log", hasItem(log)).addCriterion("has_planks", hasItem(planks))::build).generateAdvancement().build(recipeConsumer, bench.asItem().getRegistryName());
    }

    private static void mailBox(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider mailbox, IItemProvider fence, String modId)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(modId)).addRecipe(ShapedRecipeBuilder.shapedRecipe(mailbox).patternLine("C").patternLine("F").patternLine("F").key('C', Tags.Items.CHESTS_WOODEN).key('F', fence).setGroup("mail_box").addCriterion("has_postbox", hasItem(com.mrcrayfish.furniture.core.ModBlocks.POST_BOX.get())).addCriterion("has_chest", hasItem(Tags.Items.CHESTS_WOODEN))::build).generateAdvancement().build(recipeConsumer, mailbox.asItem().getRegistryName());
    }

    private static void kitchenCounter(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider counter, IItemProvider log, IItemProvider planks)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(counter, 8).patternLine("LLL").patternLine("PPP").patternLine("PPP").key('L', log).key('P', planks).setGroup("kitchen_counter").addCriterion("has_log", hasItem(log)).addCriterion("has_planks", hasItem(planks))::build).generateAdvancement().build(recipeConsumer, counter.asItem().getRegistryName());
    }

    private static void kitchenDrawer(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider counter, IItemProvider log, IItemProvider planks)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(log.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(counter, 4).patternLine("LLL").patternLine("PCP").patternLine("PPP").key('L', log).key('P', planks).key('C', Tags.Items.CHESTS_WOODEN).setGroup("kitchen_drawer").addCriterion("has_log", hasItem(log)).addCriterion("has_planks", hasItem(planks)).addCriterion("has_chest", hasItem(Tags.Items.CHESTS_WOODEN))::build).generateAdvancement().build(recipeConsumer, counter.asItem().getRegistryName());
    }

    private static void kitchenSink(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider sink, IItemProvider top, IItemProvider bottom)
    {
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition(bottom.asItem().getRegistryName().getNamespace())).addRecipe(ShapedRecipeBuilder.shapedRecipe(sink, 2).patternLine("CIC").patternLine("PBP").patternLine("PPP").key('C', top).key('I', Tags.Items.INGOTS_IRON).key('P', bottom).key('B', Items.BUCKET).setGroup("kitchen_sink").addCriterion("has_top", hasItem(top)).addCriterion("has_bottom", hasItem(bottom)).addCriterion("has_bucket", hasItem(Items.BUCKET))::build).generateAdvancement().build(recipeConsumer, sink.asItem().getRegistryName());
    }
}