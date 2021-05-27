package com.mrcrayfish.morefurniture.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mrcrayfish.furniture.block.CoffeeTableBlock;
import com.mrcrayfish.morefurniture.Generator;
import com.mrcrayfish.morefurniture.Reference;
import com.mrcrayfish.morefurniture.init.ModBlocks;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.data.loot.ChestLootTables;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.data.loot.FishingLootTables;
import net.minecraft.data.loot.GiftLootTables;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.PiglinBarteringAddition;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.functions.CopyName;
import net.minecraft.loot.functions.CopyNbt;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ForgeLootTableProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Ocelot
 */
public class LootTableGen extends ForgeLootTableProvider
{
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> tables = ImmutableList.of(Pair.of(FishingProvider::new, LootParameterSets.FISHING), Pair.of(ChestProvider::new, LootParameterSets.CHEST), Pair.of(EntityProvider::new, LootParameterSets.ENTITY), Pair.of(BlockProvider::new, LootParameterSets.BLOCK), Pair.of(PiglinBarteringProvider::new, LootParameterSets.field_237453_h_), Pair.of(GiftProvider::new, LootParameterSets.GIFT));

    public LootTableGen(DataGenerator generator)
    {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
    {
        return tables;
    }

    private static class FishingProvider extends FishingLootTables
    {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registry)
        {
        }
    }

    private static class ChestProvider extends ChestLootTables
    {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registry)
        {
        }
    }

    private static class EntityProvider extends EntityLootTables
    {
        @Override
        protected void addTables()
        {
        }

        @Override
        protected Iterable<EntityType<?>> getKnownEntities()
        {
            return ForgeRegistries.ENTITIES.getValues().stream().filter(entityType -> entityType.getRegistryName() != null && Reference.MOD_ID.equals(entityType.getRegistryName().getNamespace())).collect(Collectors.toSet());
        }
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

    private static class BlockProvider extends BlockLootTables
    {
        @Override
        protected void addTables()
        {
            Generator generator = new Generator();
            for(Generator.FurnitureType type : Generator.FURNITURE_TYPES)
            {
                for(Generator.Variant variant : generator.getRegisteredVariants())
                {
                    Consumer<Block> register = type == Generator.COFFEE_TABLE ? this::registerCoffeeTable : this::registerDropSelfLootTable;
                    register.accept(getResultBlock(variant, type, false));
                    if(variant.getStrippedLog() != null)
                    {
                        register.accept(getResultBlock(variant, type, true));
                    }
                }
            }
        }

        public void registerCoffeeTable(Block block)
        {
            this.registerLootTable(block, coffeeTable -> LootTable.builder().addLootPool(LootPool.builder().rolls(ConstantRange.of(1)).addEntry(withSurvivesExplosion(block, ItemLootEntry.builder(coffeeTable).acceptFunction(SetCount.builder(ConstantRange.of(2)).acceptCondition(BlockStateProperty.builder(coffeeTable).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withBoolProp(CoffeeTableBlock.TALL, true))))))));
        }

        @Override
        protected Iterable<Block> getKnownBlocks()
        {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(entityType -> entityType.getRegistryName() != null && Reference.MOD_ID.equals(entityType.getRegistryName().getNamespace())).collect(Collectors.toSet());
        }
    }

    private static class PiglinBarteringProvider extends PiglinBarteringAddition
    {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registry)
        {
        }
    }

    private static class GiftProvider extends GiftLootTables
    {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> registry)
        {
        }
    }
}