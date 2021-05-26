package com.mrcrayfish.morefurniture.init;

import com.mrcrayfish.furniture.FurnitureMod;
import com.mrcrayfish.morefurniture.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class ModBlocks
{
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);

    private static RegistryObject<Block> register(String name, Block block)
    {
        return register(name, block, new Item.Properties().group(FurnitureMod.GROUP));
    }

    private static RegistryObject<Block> register(String name, Block block, Item.Properties properties)
    {
        return register(name, block, () -> new BlockItem(block, properties));
    }

    private static RegistryObject<Block> register(String name, Block block, @Nullable Supplier<BlockItem> supplier)
    {
        if(supplier != null)
        {
            ModItems.REGISTER.register(name, supplier);
        }
        return REGISTER.register(name, () -> block);
    }

    private static RegistryObject<Block> register(String name, Block block, @Nullable Function<Block, BlockItem> function)
    {
        if(function != null)
        {
            ModItems.REGISTER.register(name, () -> function.apply(block));
        }
        return REGISTER.register(name, () -> block);
    }
}
