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
    }
}
