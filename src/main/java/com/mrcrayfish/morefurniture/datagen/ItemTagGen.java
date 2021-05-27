package com.mrcrayfish.morefurniture.datagen;

import com.mrcrayfish.furniture.common.ModTags;
import com.mrcrayfish.morefurniture.Generator;
import com.mrcrayfish.morefurniture.Reference;
import com.mrcrayfish.morefurniture.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.data.TagsProvider;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ItemTagGen extends ItemTagsProvider
{
    public ItemTagGen(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper)
    {
        super(generator, blockTagsProvider, Reference.MOD_ID, existingFileHelper);
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
    protected void registerTags()
    {
        Generator generator = new Generator();

        TagsProvider.Builder<Item> bedroomTag = this.getOrCreateBuilder(ModTags.Items.BEDROOM).replace(false);
        for(Generator.Variant variant : generator.getRegisteredVariants())
        {
            bedroomTag.addOptional(getResultBlock(variant, Generator.BEDSIDE_CABINET, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                bedroomTag.addOptional(getResultBlock(variant, Generator.BEDSIDE_CABINET, true).getRegistryName());
            }

            bedroomTag.addOptional(getResultBlock(variant, Generator.DESK, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                bedroomTag.addOptional(getResultBlock(variant, Generator.DESK, true).getRegistryName());
            }

            bedroomTag.addOptional(getResultBlock(variant, Generator.DESK_CABINET, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                bedroomTag.addOptional(getResultBlock(variant, Generator.DESK_CABINET, true).getRegistryName());
            }

            bedroomTag.addOptional(getResultBlock(variant, Generator.BLINDS, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                bedroomTag.addOptional(getResultBlock(variant, Generator.BLINDS, true).getRegistryName());
            }
        }

        TagsProvider.Builder<Item> generalTag = this.getOrCreateBuilder(ModTags.Items.GENERAL).replace(false);
        for(Generator.Variant variant : generator.getRegisteredVariants())
        {
            generalTag.addOptional(getResultBlock(variant, Generator.TABLE, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                generalTag.addOptional(getResultBlock(variant, Generator.TABLE, true).getRegistryName());
            }

            generalTag.addOptional(getResultBlock(variant, Generator.CHAIR, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                generalTag.addOptional(getResultBlock(variant, Generator.CHAIR, true).getRegistryName());
            }

            generalTag.addOptional(getResultBlock(variant, Generator.COFFEE_TABLE, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                generalTag.addOptional(getResultBlock(variant, Generator.COFFEE_TABLE, true).getRegistryName());
            }
        }

        TagsProvider.Builder<Item> kitchenTag = this.getOrCreateBuilder(ModTags.Items.KITCHEN).replace(false);
        for(Generator.Variant variant : generator.getRegisteredVariants())
        {
            kitchenTag.addOptional(getResultBlock(variant, Generator.KITCHEN_COUNTER, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                kitchenTag.addOptional(getResultBlock(variant, Generator.KITCHEN_COUNTER, true).getRegistryName());
            }

            kitchenTag.addOptional(getResultBlock(variant, Generator.KITCHEN_DRAWER, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                kitchenTag.addOptional(getResultBlock(variant, Generator.KITCHEN_DRAWER, true).getRegistryName());
            }

            kitchenTag.addOptional(getResultBlock(variant, Generator.KITCHEN_SINK_LIGHT, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                kitchenTag.addOptional(getResultBlock(variant, Generator.KITCHEN_SINK_LIGHT, true).getRegistryName());
            }

            kitchenTag.addOptional(getResultBlock(variant, Generator.KITCHEN_SINK_DARK, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                kitchenTag.addOptional(getResultBlock(variant, Generator.KITCHEN_SINK_DARK, true).getRegistryName());
            }
        }

        TagsProvider.Builder<Item> outdoorTag = this.getOrCreateBuilder(ModTags.Items.OUTDOORS).replace(false);
        for(Generator.Variant variant : generator.getRegisteredVariants())
        {
            outdoorTag.addOptional(getResultBlock(variant, Generator.PARK_BENCH, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                outdoorTag.addOptional(getResultBlock(variant, Generator.PARK_BENCH, true).getRegistryName());
            }

            outdoorTag.addOptional(getResultBlock(variant, Generator.MAIL_BOX, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                outdoorTag.addOptional(getResultBlock(variant, Generator.MAIL_BOX, true).getRegistryName());
            }

            outdoorTag.addOptional(getResultBlock(variant, Generator.MAIL_BOX, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                outdoorTag.addOptional(getResultBlock(variant, Generator.MAIL_BOX, true).getRegistryName());
            }
        }

        TagsProvider.Builder<Item> storageTag = this.getOrCreateBuilder(ModTags.Items.STORAGE).replace(false);
        for(Generator.Variant variant : generator.getRegisteredVariants())
        {
            storageTag.addOptional(getResultBlock(variant, Generator.CABINET, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                storageTag.addOptional(getResultBlock(variant, Generator.CABINET, true).getRegistryName());
            }

            storageTag.addOptional(getResultBlock(variant, Generator.BEDSIDE_CABINET, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                storageTag.addOptional(getResultBlock(variant, Generator.BEDSIDE_CABINET, true).getRegistryName());
            }

            storageTag.addOptional(getResultBlock(variant, Generator.DESK_CABINET, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                storageTag.addOptional(getResultBlock(variant, Generator.DESK_CABINET, true).getRegistryName());
            }

            storageTag.addOptional(getResultBlock(variant, Generator.CRATE, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                storageTag.addOptional(getResultBlock(variant, Generator.CRATE, true).getRegistryName());
            }

            storageTag.addOptional(getResultBlock(variant, Generator.MAIL_BOX, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                storageTag.addOptional(getResultBlock(variant, Generator.MAIL_BOX, true).getRegistryName());
            }

            storageTag.addOptional(getResultBlock(variant, Generator.KITCHEN_DRAWER, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                storageTag.addOptional(getResultBlock(variant, Generator.KITCHEN_DRAWER, true).getRegistryName());
            }

            storageTag.addOptional(getResultBlock(variant, Generator.KITCHEN_SINK_LIGHT, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                storageTag.addOptional(getResultBlock(variant, Generator.KITCHEN_SINK_LIGHT, true).getRegistryName());
            }

            storageTag.addOptional(getResultBlock(variant, Generator.KITCHEN_SINK_DARK, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                storageTag.addOptional(getResultBlock(variant, Generator.KITCHEN_SINK_DARK, true).getRegistryName());
            }
        }
    }
}
