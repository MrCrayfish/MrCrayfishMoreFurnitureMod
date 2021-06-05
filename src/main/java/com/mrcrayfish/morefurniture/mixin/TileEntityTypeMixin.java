package com.mrcrayfish.morefurniture.mixin;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

/**
 * Author: MrCrayfish
 */
@Mixin(TileEntityType.class)
public interface TileEntityTypeMixin
{
    @Final
    @Accessor(value = "validBlocks")
    Set<Block> getValidBlocks();

    @Final
    @Mutable
    @Accessor(value = "validBlocks")
    void setValidBlocks(Set<Block> validBlocks);
}
