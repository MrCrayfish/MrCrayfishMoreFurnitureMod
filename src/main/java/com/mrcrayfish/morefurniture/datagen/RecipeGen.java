package com.mrcrayfish.morefurniture.datagen;

import com.mrcrayfish.morefurniture.Generator;
import com.mrcrayfish.morefurniture.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Consumer;

/**
 * @author Ocelot
 */
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

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        Generator generator = new Generator();
        generator.getRegisteredVariants().forEach(variant ->
        {
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
            mailBox(consumer, getResultBlock(variant, Generator.MAIL_BOX, false), variant.getLog());
            kitchenCounter(consumer, getResultBlock(variant, Generator.KITCHEN_COUNTER, false), variant.getLog(), variant.getPlanks());
            kitchenDrawer(consumer, getResultBlock(variant, Generator.KITCHEN_DRAWER, false), variant.getLog(), variant.getPlanks());
            kitchenSink(consumer, getResultBlock(variant, Generator.KITCHEN_SINK_LIGHT, false), Blocks.WHITE_CONCRETE, variant.getPlanks());
            kitchenSink(consumer, getResultBlock(variant, Generator.KITCHEN_SINK_DARK, false), Blocks.GRAY_CONCRETE, variant.getPlanks());

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

                // Needs it's own block getter thingo
                mailBox(consumer, getResultBlock(variant, Generator.MAIL_BOX, true), variant.getStrippedLog());

                kitchenCounter(consumer, getResultBlock(variant, Generator.KITCHEN_COUNTER, true), variant.getLog(), variant.getStrippedLog());
                kitchenDrawer(consumer, getResultBlock(variant, Generator.KITCHEN_DRAWER, true), variant.getLog(), variant.getStrippedLog());
                kitchenSink(consumer, getResultBlock(variant, Generator.KITCHEN_SINK_LIGHT, true), Blocks.WHITE_CONCRETE, variant.getStrippedLog());
                kitchenSink(consumer, getResultBlock(variant, Generator.KITCHEN_SINK_DARK, true), Blocks.GRAY_CONCRETE, variant.getStrippedLog());

            }
        });
    }

    private static void table(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider table, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(table, 4)
                .patternLine("LLL")
                .patternLine(" P ")
                .patternLine(" P ")
                .key('L', log)
                .key('P', planks)
                .setGroup("table")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void chair(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider chair, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(chair, 4)
                .patternLine("L  ")
                .patternLine("LLL")
                .patternLine("P P")
                .key('L', log)
                .key('P', planks)
                .setGroup("chair")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void coffeeTable(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider table, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(table, 4)
                .patternLine("LLL")
                .patternLine("P P")
                .key('L', log)
                .key('P', planks)
                .setGroup("coffee_table")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void cabinet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider cabinet, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(cabinet, 2)
                .patternLine("PPL")
                .patternLine("P L")
                .patternLine("PPL")
                .key('L', log)
                .key('P', planks)
                .setGroup("cabinet")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void bedsideCabinet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider cabinet, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(cabinet, 2)
                .patternLine("LLL")
                .patternLine("P P")
                .patternLine("PPP")
                .key('L', log)
                .key('P', planks)
                .setGroup("bedside_cabinet")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void desk(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider desk, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(desk, 2)
                .patternLine("LLL")
                .patternLine("P P")
                .patternLine("P P")
                .key('L', log)
                .key('P', planks)
                .setGroup("desk")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void deskCabinet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider desk, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(desk, 2)
                .patternLine("LLL")
                .patternLine("PPP")
                .patternLine("P P")
                .key('L', log)
                .key('P', planks)
                .setGroup("desk_cabinet")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void sofa(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider sofa, IItemProvider wool)
    {
        ShapedRecipeBuilder.shapedRecipe(sofa, 2)
                .patternLine("W  ")
                .patternLine("WWW")
                .patternLine("LLL")
                .key('W', wool)
                .key('L', ItemTags.LOGS)
                .setGroup("sofa")
                .addCriterion("has_wool", hasItem(wool))
                .build(recipeConsumer);
    }

    private static void blinds(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider blinds, IItemProvider log)
    {
        ShapedRecipeBuilder.shapedRecipe(blinds, 2)
                .patternLine("LLL")
                .patternLine("SSS")
                .patternLine("SSS")
                .key('L', log)
                .key('S', Tags.Items.RODS_WOODEN)
                .setGroup("blinds")
                .addCriterion("has_log", hasItem(log))
                .build(recipeConsumer);
    }

    private static void upgradedFence(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider fence, IItemProvider log)
    {
        ShapedRecipeBuilder.shapedRecipe(fence, 12)
                .patternLine("LSL")
                .patternLine("LSL")
                .key('L', log)
                .key('S', Tags.Items.RODS_WOODEN)
                .setGroup("upgraded_fence")
                .addCriterion("has_log", hasItem(log))
                .build(recipeConsumer);
    }

    private static void upgradedGate(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider gate, IItemProvider log)
    {
        ShapedRecipeBuilder.shapedRecipe(gate, 2)
                .patternLine("LGL")
                .key('L', log)
                .key('G', Tags.Items.FENCE_GATES_WOODEN)
                .setGroup("upgraded_gate")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_gate", hasItem(Tags.Items.FENCE_GATES_WOODEN))
                .build(recipeConsumer);
    }

    private static void crate(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider crate, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(crate, 2)
                .patternLine("LPL")
                .patternLine("P P")
                .patternLine("LPL")
                .key('L', log)
                .key('P', planks)
                .setGroup("crate")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void parkBench(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider bench, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(bench, 4)
                .patternLine("PPP")
                .patternLine("PPP")
                .patternLine("L L")
                .key('L', log)
                .key('P', planks)
                .setGroup("park_bench")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void mailBox(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider mailbox, IItemProvider fence)
    {
        ShapedRecipeBuilder.shapedRecipe(mailbox)
                .patternLine("C")
                .patternLine("F")
                .patternLine("F")
                .key('C', Tags.Items.CHESTS_WOODEN)
                .key('F', fence)
                .setGroup("mail_box")
                .addCriterion("has_postbox", hasItem(com.mrcrayfish.furniture.core.ModBlocks.POST_BOX.get())) // Mailbox depends on post box so if you have a postbox unlock all mailboxes
                .addCriterion("has_chest", hasItem(Tags.Items.CHESTS_WOODEN))
                .build(recipeConsumer);
    }

    private static void kitchenCounter(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider counter, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(counter, 8)
                .patternLine("LLL")
                .patternLine("PPP")
                .patternLine("PPP")
                .key('L', log)
                .key('P', planks)
                .setGroup("kitchen_counter")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .build(recipeConsumer);
    }

    private static void coloredKitchenCounter(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider counter, ITag<Item> dye)
    {
        ShapedRecipeBuilder.shapedRecipe(counter, 8)
                .patternLine("SDS")
                .patternLine("CCC")
                .patternLine("CCC")
                .key('S', Tags.Items.STONE)
                .key('D', dye)
                .key('C', Blocks.TERRACOTTA)
                .setGroup("kitchen_counter")
                .addCriterion("has_stone", hasItem(Tags.Items.STONE))
                .addCriterion("has_terracotta", hasItem(Blocks.TERRACOTTA))
                .build(recipeConsumer);
    }

    private static void kitchenDrawer(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider counter, IItemProvider log, IItemProvider planks)
    {
        ShapedRecipeBuilder.shapedRecipe(counter, 4)
                .patternLine("LLL")
                .patternLine("PCP")
                .patternLine("PPP")
                .key('L', log)
                .key('P', planks)
                .key('C', Tags.Items.CHESTS_WOODEN)
                .setGroup("kitchen_drawer")
                .addCriterion("has_log", hasItem(log))
                .addCriterion("has_planks", hasItem(planks))
                .addCriterion("has_chest", hasItem(Tags.Items.CHESTS_WOODEN))
                .build(recipeConsumer);
    }

    private static void coloredKitchenDrawer(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider counter, ITag<Item> dye)
    {
        ShapedRecipeBuilder.shapedRecipe(counter, 4)
                .patternLine("SDS")
                .patternLine("CBC")
                .patternLine("CCC")
                .key('S', Tags.Items.STONE)
                .key('D', dye)
                .key('C', Blocks.TERRACOTTA)
                .key('B', Tags.Items.CHESTS_WOODEN)
                .setGroup("kitchen_drawer")
                .addCriterion("has_stone", hasItem(Tags.Items.STONE))
                .addCriterion("has_terracotta", hasItem(Blocks.TERRACOTTA))
                .addCriterion("has_chest", hasItem(Tags.Items.CHESTS_WOODEN))
                .build(recipeConsumer);
    }

    private static void kitchenSink(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider sink, IItemProvider top, IItemProvider bottom)
    {
        ShapedRecipeBuilder.shapedRecipe(sink, 2)
                .patternLine("CIC")
                .patternLine("PBP")
                .patternLine("PPP")
                .key('C', top)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('P', bottom)
                .key('B', Items.BUCKET)
                .setGroup("kitchen_sink")
                .addCriterion("has_top", hasItem(top))
                .addCriterion("has_bottom", hasItem(bottom))
                .addCriterion("has_bucket", hasItem(Items.BUCKET))
                .build(recipeConsumer);
    }

    private static void coloredKitchenSink(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider sink, IItemProvider top)
    {
        ShapedRecipeBuilder.shapedRecipe(sink, 2)
                .patternLine("CIC")
                .patternLine("PBP")
                .patternLine("PPP")
                .key('C', top)
                .key('I', Tags.Items.INGOTS_IRON)
                .key('P', Tags.Items.STONE)
                .key('B', Items.BUCKET)
                .setGroup("kitchen_sink")
                .addCriterion("has_top", hasItem(top))
                .addCriterion("has_stone", hasItem(Tags.Items.STONE))
                .addCriterion("has_bucket", hasItem(Items.BUCKET))
                .build(recipeConsumer);
    }
}