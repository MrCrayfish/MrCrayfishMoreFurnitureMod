package com.mrcrayfish.morefurniture.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mrcrayfish.morefurniture.Generator;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

/**
 * Author: MrCrayfish
 */
public class GenerateCommand
{
    public static void register(CommandDispatcher<CommandSource> dispatcher)
    {
        dispatcher.register(Commands.literal("generate").executes(context -> {
            new Generator().generate();
            return 1;
        }));
    }
}
