package com.mrcrayfish.morefurniture.init;

import com.mojang.brigadier.CommandDispatcher;
import com.mrcrayfish.morefurniture.common.command.GenerateCommand;
import com.mrcrayfish.morefurniture.common.command.SpawnFurnitureCommand;
import net.minecraft.command.CommandSource;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.loading.FMLLoader;

/**
 * Author: MrCrayfish
 */
public class ModCommands
{
    @SubscribeEvent
    public void onServerStart(FMLServerAboutToStartEvent event)
    {
        CommandDispatcher<CommandSource> dispatcher = event.getServer().getCommandManager().getDispatcher();
        this.registerCommands(dispatcher, event.getServer().isDedicatedServer());
    }

    private void registerCommands(CommandDispatcher<CommandSource> dispatcher, boolean dedicated)
    {
        if(!FMLLoader.isProduction() && !dedicated)
        {
            GenerateCommand.register(dispatcher);
            SpawnFurnitureCommand.register(dispatcher);
        }
    }
}
