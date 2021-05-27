package com.mrcrayfish.morefurniture.client;

import net.minecraftforge.common.MinecraftForge;

/**
 * Author: MrCrayfish
 */
public class ClientHandler
{
    public static void setup()
    {
        MinecraftForge.EVENT_BUS.register(new CreativeScreenEvents());

    private static void registerStrippedColorsOne(RegistryObject<Block> blockObject)
    {
        // Need this since some blocks could be null if the optional mod isnt loaded
        if(blockObject == null)
            return;
        Minecraft.getInstance().getBlockColors().register((state, reader, pos, i) -> i == 1 ? 0xBBBBBB : 0, blockObject.get());
        Minecraft.getInstance().getItemColors().register((stack, i) -> i == 1 ? 0xBBBBBB : 0, blockObject.get());
    }

    private static void registerStrippedColorsTwo(RegistryObject<Block> blockObject)
    {
        // Need this since some blocks could be null if the optional mod isnt loaded
        if(blockObject == null)
            return;
        Minecraft.getInstance().getBlockColors().register((state, reader, pos, i) -> i == 1 ? 0x999999 : 0, blockObject.get());
        Minecraft.getInstance().getItemColors().register((stack, i) -> i == 1 ? 0x999999 : 0, blockObject.get());
    }
}
