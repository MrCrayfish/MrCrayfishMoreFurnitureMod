package com.mrcrayfish.morefurniture.client;

import com.mrcrayfish.morefurniture.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.RegistryObject;

/**
 * Author: MrCrayfish
 */
public class ClientHandler
{
    public static void setup()
    {
        MinecraftForge.EVENT_BUS.register(new CreativeScreenEvents());

        registerStrippedColorsOne(ModBlocks.AUTUMNITY_CRATE_STRIPPED_MAPLE);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_CRATE_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_CRATE_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_CRATE_STRIPPED_WISTERIA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_CRATE_STRIPPED_ROSEWOOD);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_CRATE_STRIPPED_MORADO);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_CRATE_STRIPPED_YUCCA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_CRATE_STRIPPED_KOUSA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_CRATE_STRIPPED_ASPEN);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_CRATE_STRIPPED_GRIMWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_FIR);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_REDWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_MAHOGANY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_JACARANDA);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_PALM);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_DEAD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_MAGIC);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_UMBRAN);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_HELLBARK);
        registerStrippedColorsOne(ModBlocks.AUTUMNITY_KITCHEN_COUNTER_STRIPPED_MAPLE);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_COUNTER_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_COUNTER_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_COUNTER_STRIPPED_WISTERIA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_COUNTER_STRIPPED_ROSEWOOD);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_COUNTER_STRIPPED_MORADO);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_COUNTER_STRIPPED_YUCCA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_COUNTER_STRIPPED_KOUSA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_COUNTER_STRIPPED_ASPEN);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_COUNTER_STRIPPED_GRIMWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_FIR);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_REDWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_MAHOGANY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_JACARANDA);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_PALM);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_DEAD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_MAGIC);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_UMBRAN);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_HELLBARK);
        registerStrippedColorsOne(ModBlocks.AUTUMNITY_KITCHEN_SINK_LIGHT_STRIPPED_MAPLE);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_LIGHT_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_LIGHT_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_LIGHT_STRIPPED_WISTERIA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_ROSEWOOD);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_MORADO);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_YUCCA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_KOUSA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_ASPEN);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_GRIMWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_FIR);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_REDWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_MAHOGANY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_JACARANDA);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_PALM);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_DEAD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_MAGIC);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_UMBRAN);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_HELLBARK);
        registerStrippedColorsOne(ModBlocks.AUTUMNITY_KITCHEN_SINK_DARK_STRIPPED_MAPLE);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_DARK_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_DARK_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_DARK_STRIPPED_WISTERIA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_ROSEWOOD);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_MORADO);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_YUCCA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_KOUSA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_ASPEN);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_GRIMWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_FIR);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_REDWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_MAHOGANY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_JACARANDA);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_PALM);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_DEAD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_MAGIC);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_UMBRAN);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_HELLBARK);
        registerStrippedColorsOne(ModBlocks.AUTUMNITY_CRATE_STRIPPED_MAPLE);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_CRATE_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_CRATE_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_CRATE_STRIPPED_WISTERIA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_CRATE_STRIPPED_ROSEWOOD);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_CRATE_STRIPPED_MORADO);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_CRATE_STRIPPED_YUCCA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_CRATE_STRIPPED_KOUSA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_CRATE_STRIPPED_ASPEN);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_CRATE_STRIPPED_GRIMWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_FIR);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_REDWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_MAHOGANY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_JACARANDA);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_PALM);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_DEAD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_MAGIC);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_UMBRAN);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_CRATE_STRIPPED_HELLBARK);
        registerStrippedColorsOne(ModBlocks.AUTUMNITY_KITCHEN_COUNTER_STRIPPED_MAPLE);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_COUNTER_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_COUNTER_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_COUNTER_STRIPPED_WISTERIA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_COUNTER_STRIPPED_ROSEWOOD);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_COUNTER_STRIPPED_MORADO);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_COUNTER_STRIPPED_YUCCA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_COUNTER_STRIPPED_KOUSA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_COUNTER_STRIPPED_ASPEN);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_COUNTER_STRIPPED_GRIMWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_FIR);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_REDWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_MAHOGANY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_JACARANDA);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_PALM);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_DEAD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_MAGIC);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_UMBRAN);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_COUNTER_STRIPPED_HELLBARK);
        registerStrippedColorsOne(ModBlocks.AUTUMNITY_KITCHEN_SINK_LIGHT_STRIPPED_MAPLE);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_LIGHT_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_LIGHT_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_LIGHT_STRIPPED_WISTERIA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_ROSEWOOD);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_MORADO);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_YUCCA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_KOUSA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_ASPEN);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_GRIMWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_FIR);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_REDWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_MAHOGANY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_JACARANDA);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_PALM);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_DEAD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_MAGIC);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_UMBRAN);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_HELLBARK);
        registerStrippedColorsOne(ModBlocks.AUTUMNITY_KITCHEN_SINK_DARK_STRIPPED_MAPLE);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_DARK_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_DARK_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_DARK_STRIPPED_WISTERIA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_ROSEWOOD);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_MORADO);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_YUCCA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_KOUSA);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_ASPEN);
        registerStrippedColorsOne(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_GRIMWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_FIR);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_REDWOOD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_CHERRY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_MAHOGANY);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_JACARANDA);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_PALM);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_WILLOW);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_DEAD);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_MAGIC);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_UMBRAN);
        registerStrippedColorsOne(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_HELLBARK);
        registerStrippedColorsTwo(ModBlocks.AUTUMNITY_PARK_BENCH_STRIPPED_MAPLE);
        registerStrippedColorsTwo(ModBlocks.ENVIRONMENTAL_PARK_BENCH_STRIPPED_WILLOW);
        registerStrippedColorsTwo(ModBlocks.ENVIRONMENTAL_PARK_BENCH_STRIPPED_CHERRY);
        registerStrippedColorsTwo(ModBlocks.ENVIRONMENTAL_PARK_BENCH_STRIPPED_WISTERIA);
        registerStrippedColorsTwo(ModBlocks.ATMOSPHERIC_PARK_BENCH_STRIPPED_ROSEWOOD);
        registerStrippedColorsTwo(ModBlocks.ATMOSPHERIC_PARK_BENCH_STRIPPED_MORADO);
        registerStrippedColorsTwo(ModBlocks.ATMOSPHERIC_PARK_BENCH_STRIPPED_YUCCA);
        registerStrippedColorsTwo(ModBlocks.ATMOSPHERIC_PARK_BENCH_STRIPPED_KOUSA);
        registerStrippedColorsTwo(ModBlocks.ATMOSPHERIC_PARK_BENCH_STRIPPED_ASPEN);
        registerStrippedColorsTwo(ModBlocks.ATMOSPHERIC_PARK_BENCH_STRIPPED_GRIMWOOD);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_FIR);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_REDWOOD);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_CHERRY);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_MAHOGANY);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_JACARANDA);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_PALM);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_WILLOW);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_DEAD);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_MAGIC);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_UMBRAN);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_HELLBARK);
        registerStrippedColorsTwo(ModBlocks.AUTUMNITY_PARK_BENCH_STRIPPED_MAPLE);
        registerStrippedColorsTwo(ModBlocks.ENVIRONMENTAL_PARK_BENCH_STRIPPED_WILLOW);
        registerStrippedColorsTwo(ModBlocks.ENVIRONMENTAL_PARK_BENCH_STRIPPED_CHERRY);
        registerStrippedColorsTwo(ModBlocks.ENVIRONMENTAL_PARK_BENCH_STRIPPED_WISTERIA);
        registerStrippedColorsTwo(ModBlocks.ATMOSPHERIC_PARK_BENCH_STRIPPED_ROSEWOOD);
        registerStrippedColorsTwo(ModBlocks.ATMOSPHERIC_PARK_BENCH_STRIPPED_MORADO);
        registerStrippedColorsTwo(ModBlocks.ATMOSPHERIC_PARK_BENCH_STRIPPED_YUCCA);
        registerStrippedColorsTwo(ModBlocks.ATMOSPHERIC_PARK_BENCH_STRIPPED_KOUSA);
        registerStrippedColorsTwo(ModBlocks.ATMOSPHERIC_PARK_BENCH_STRIPPED_ASPEN);
        registerStrippedColorsTwo(ModBlocks.ATMOSPHERIC_PARK_BENCH_STRIPPED_GRIMWOOD);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_FIR);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_REDWOOD);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_CHERRY);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_MAHOGANY);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_JACARANDA);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_PALM);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_WILLOW);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_DEAD);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_MAGIC);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_UMBRAN);
        registerStrippedColorsTwo(ModBlocks.BIOMESOPLENTY_PARK_BENCH_STRIPPED_HELLBARK);

    }

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
