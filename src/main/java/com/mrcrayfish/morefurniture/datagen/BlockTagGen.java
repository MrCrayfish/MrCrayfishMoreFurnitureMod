package com.mrcrayfish.morefurniture.datagen;

import com.mrcrayfish.furniture.common.ModTags;
import com.mrcrayfish.morefurniture.Generator;
import com.mrcrayfish.morefurniture.Reference;
import com.mrcrayfish.morefurniture.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.TagsProvider;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class BlockTagGen extends BlockTagsProvider
{
    public BlockTagGen(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, Reference.MOD_ID, existingFileHelper);
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

        TagsProvider.Builder<Block> upgradedFences = this.getOrCreateBuilder(ModTags.Blocks.UPGRADED_FENCES).replace(false);
        for(Generator.Variant variant : generator.getRegisteredVariants())
        {
            upgradedFences.addOptional(getResultBlock(variant, Generator.UPGRADED_FENCE, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                upgradedFences.addOptional(getResultBlock(variant, Generator.UPGRADED_FENCE, true).getRegistryName());
            }
        }

        TagsProvider.Builder<Block> upgradedGates = this.getOrCreateBuilder(ModTags.Blocks.UPGRADED_FENCE_GATES).replace(false);
        for(Generator.Variant variant : generator.getRegisteredVariants())
        {
            upgradedGates.addOptional(getResultBlock(variant, Generator.UPGRADED_GATE, false).getRegistryName());
            if(variant.getStrippedLog() != null)
            {
                upgradedGates.addOptional(getResultBlock(variant, Generator.UPGRADED_GATE, true).getRegistryName());
            }
        }
    }
}
