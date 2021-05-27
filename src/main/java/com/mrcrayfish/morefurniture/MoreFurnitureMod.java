package com.mrcrayfish.morefurniture;

import com.mrcrayfish.furniture.FurnitureGroup;
import com.mrcrayfish.morefurniture.client.ClientHandler;
import com.mrcrayfish.morefurniture.common.CommonHandler;
import com.mrcrayfish.morefurniture.datagen.BlockTagGen;
import com.mrcrayfish.morefurniture.datagen.ItemTagGen;
import com.mrcrayfish.morefurniture.datagen.LootTableGen;
import com.mrcrayfish.morefurniture.datagen.RecipeGen;
import com.mrcrayfish.morefurniture.init.ModBlocks;
import com.mrcrayfish.morefurniture.init.ModCommands;
import com.mrcrayfish.morefurniture.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.commons.lang3.ObjectUtils;

/**
 * Author: MrCrayfish
 */
@Mod(Reference.MOD_ID)
public class MoreFurnitureMod
{
    public static final ItemGroup GROUP = new ItemGroup(Reference.MOD_ID)
    {
        @Override
        public ItemStack createIcon()
        {
            Block block = ObjectUtils.firstNonNull(ModBlocks.ATMOSPHERIC_CHAIR_ASPEN, ModBlocks.ENVIRONMENTAL_CHAIR_STRIPPED_WILLOW, ModBlocks.BIOMESOPLENTY_CHAIR_STRIPPED_CHERRY, com.mrcrayfish.furniture.core.ModBlocks.CHAIR_CRIMSON).get();
            return new ItemStack(block);
        }
    };

    public MoreFurnitureMod()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.REGISTER.register(eventBus);
        ModItems.REGISTER.register(eventBus);
        eventBus.addListener(this::onCommonSetup);
        eventBus.addListener(this::onClientSetup);
        eventBus.addListener(this::onDataSetup);
        MinecraftForge.EVENT_BUS.register(new ModCommands());
    }

    private void onCommonSetup(FMLCommonSetupEvent event)
    {
        CommonHandler.setup();
    }

    private void onClientSetup(FMLClientSetupEvent event)
    {
        ClientHandler.setup();
    }

    private void onDataSetup(GatherDataEvent event)
    {
        DataGenerator dataGenerator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        BlockTagGen blockTagGen = new BlockTagGen(dataGenerator, existingFileHelper);
        dataGenerator.addProvider(blockTagGen);
        dataGenerator.addProvider(new RecipeGen(dataGenerator));
        dataGenerator.addProvider(new LootTableGen(dataGenerator));
        dataGenerator.addProvider(new ItemTagGen(dataGenerator, blockTagGen, existingFileHelper));
    }
}
