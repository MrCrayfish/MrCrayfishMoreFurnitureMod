package com.mrcrayfish.morefurniture.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mrcrayfish.furniture.block.*;
import com.mrcrayfish.morefurniture.Generator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Author: MrCrayfish
 */
public class SpawnFurnitureCommand
{
    public static void register(CommandDispatcher<CommandSource> dispatcher)
    {
        dispatcher.register(Commands.literal("spawnfurniture").executes(context ->
        {
            Entity entity = context.getSource().getEntity();
            if(entity != null)
            {
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 0), block -> block instanceof TableBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 9), block -> block instanceof ChairBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 18), block -> block instanceof CoffeeTableBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 27), block -> block instanceof CabinetBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 36), block -> block instanceof BedsideCabinetBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 45), block -> block instanceof DeskBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 54), block -> block instanceof DeskCabinetBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 63), block -> block instanceof BlindsBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 72), block -> block instanceof UpgradedFenceBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 81), block -> block instanceof UpgradedGateBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 90), block -> block instanceof CrateBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 99), block -> block instanceof ParkBenchBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 108), block -> block instanceof MailBoxBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 117), block -> block instanceof KitchenCounterBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 126), block -> block instanceof KitchenDrawerBlock);
                setBlocks(entity.world, entity.getPosition().offset(Direction.WEST, 135), block -> block instanceof KitchenSinkBlock);
            }
            return 1;
        }));
    }

    private static void setBlocks(World world, BlockPos start, Predicate<Block> predicate)
    {
        int index = 0;
        for(Block block : ForgeRegistries.BLOCKS.getValues().stream().filter(predicate).collect(Collectors.toList()))
        {
            BlockState state = block.getDefaultState();
            if(state.hasProperty(FurnitureWaterloggedBlock.WATERLOGGED))
            {
                state = state.with(FurnitureWaterloggedBlock.WATERLOGGED, false);
            }
            world.setBlockState(start.offset(Direction.WEST, index % 9).offset(Direction.SOUTH, -index / 9), state);
            index++;
        }
    }
}
