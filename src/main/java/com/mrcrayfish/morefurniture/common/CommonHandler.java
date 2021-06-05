package com.mrcrayfish.morefurniture.common;

import com.google.common.collect.ImmutableSet;
import com.mrcrayfish.furniture.core.ModTileEntities;
import com.mrcrayfish.morefurniture.init.ModBlocks;
import com.mrcrayfish.morefurniture.mixin.TileEntityTypeMixin;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class CommonHandler
{
    public static void injectBlocksIntoSinkTileEntity()
    {
        Set<Block> sinkBlocks = new HashSet<>();
        addNonnullBlockSupplierIntoSet(ModBlocks.AUTUMNITY_KITCHEN_SINK_LIGHT_MAPLE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_LIGHT_WILLOW, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_LIGHT_CHERRY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_LIGHT_WISTERIA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_ROSEWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_MORADO, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_YUCCA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_KOUSA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_ASPEN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_GRIMWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.UPGRADE_AQUATIC_KITCHEN_SINK_LIGHT_DRIFTWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.UPGRADE_AQUATIC_KITCHEN_SINK_LIGHT_RIVER, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENDERGETIC_KITCHEN_SINK_LIGHT_POISE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_FIR, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_REDWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_CHERRY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_MAHOGANY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_JACARANDA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_PALM, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_WILLOW, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_DEAD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_MAGIC, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_UMBRAN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_HELLBARK, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_ASPEN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_BAOBAB, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_BLUE_ENCHANTED, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_CHERRY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_CIKA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_CYPRESS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_EBONY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_FIR, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_GREEN_ENCHANTED, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_HOLLY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_JACARANDA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_MAHOGANY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_MANGROVE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_MAPLE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_PINE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_RAINBOW_EUCALYPTUS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_REDWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_SKYRIS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_WILLOW, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_WITCH_HAZEL, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_ZELKOVA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_PALM, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_LAMENT, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_NIGHTSHADE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_ETHER, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_SYTHIAN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_BULBIS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_IMPARIUS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.AUTUMNITY_KITCHEN_SINK_LIGHT_STRIPPED_MAPLE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_LIGHT_STRIPPED_WILLOW, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_LIGHT_STRIPPED_CHERRY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_LIGHT_STRIPPED_WISTERIA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_ROSEWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_MORADO, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_YUCCA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_KOUSA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_ASPEN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_LIGHT_STRIPPED_GRIMWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.UPGRADE_AQUATIC_KITCHEN_SINK_LIGHT_STRIPPED_DRIFTWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.UPGRADE_AQUATIC_KITCHEN_SINK_LIGHT_STRIPPED_RIVER, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENDERGETIC_KITCHEN_SINK_LIGHT_STRIPPED_POISE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_FIR, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_REDWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_CHERRY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_MAHOGANY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_JACARANDA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_PALM, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_WILLOW, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_DEAD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_MAGIC, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_UMBRAN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_LIGHT_STRIPPED_HELLBARK, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_ASPEN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_BAOBAB, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_BLUE_ENCHANTED, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_CHERRY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_CIKA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_CYPRESS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_EBONY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_FIR, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_GREEN_ENCHANTED, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_HOLLY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_JACARANDA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_MAHOGANY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_MANGROVE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_MAPLE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_PINE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_RAINBOW_EUCALYPTUS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_REDWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_SKYRIS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_WILLOW, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_WITCH_HAZEL, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_ZELKOVA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_PALM, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_LAMENT, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_NIGHTSHADE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_ETHER, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_LIGHT_STRIPPED_SYTHIAN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.AUTUMNITY_KITCHEN_SINK_DARK_MAPLE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_DARK_WILLOW, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_DARK_CHERRY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_DARK_WISTERIA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_ROSEWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_MORADO, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_YUCCA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_KOUSA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_ASPEN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_GRIMWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.UPGRADE_AQUATIC_KITCHEN_SINK_DARK_DRIFTWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.UPGRADE_AQUATIC_KITCHEN_SINK_DARK_RIVER, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENDERGETIC_KITCHEN_SINK_DARK_POISE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_FIR, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_REDWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_CHERRY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_MAHOGANY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_JACARANDA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_PALM, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_WILLOW, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_DEAD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_MAGIC, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_UMBRAN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_HELLBARK, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_ASPEN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_BAOBAB, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_BLUE_ENCHANTED, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_CHERRY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_CIKA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_CYPRESS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_EBONY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_FIR, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_GREEN_ENCHANTED, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_HOLLY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_JACARANDA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_MAHOGANY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_MANGROVE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_MAPLE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_PINE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_RAINBOW_EUCALYPTUS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_REDWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_SKYRIS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_WILLOW, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_WITCH_HAZEL, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_ZELKOVA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_PALM, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_LAMENT, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_NIGHTSHADE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_ETHER, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_SYTHIAN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_BULBIS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_IMPARIUS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.AUTUMNITY_KITCHEN_SINK_DARK_STRIPPED_MAPLE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_DARK_STRIPPED_WILLOW, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_DARK_STRIPPED_CHERRY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENVIRONMENTAL_KITCHEN_SINK_DARK_STRIPPED_WISTERIA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_ROSEWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_MORADO, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_YUCCA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_KOUSA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_ASPEN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ATMOSPHERIC_KITCHEN_SINK_DARK_STRIPPED_GRIMWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.UPGRADE_AQUATIC_KITCHEN_SINK_DARK_STRIPPED_DRIFTWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.UPGRADE_AQUATIC_KITCHEN_SINK_DARK_STRIPPED_RIVER, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.ENDERGETIC_KITCHEN_SINK_DARK_STRIPPED_POISE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_FIR, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_REDWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_CHERRY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_MAHOGANY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_JACARANDA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_PALM, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_WILLOW, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_DEAD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_MAGIC, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_UMBRAN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BIOMESOPLENTY_KITCHEN_SINK_DARK_STRIPPED_HELLBARK, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_ASPEN, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_BAOBAB, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_BLUE_ENCHANTED, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_CHERRY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_CIKA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_CYPRESS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_EBONY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_FIR, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_GREEN_ENCHANTED, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_HOLLY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_JACARANDA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_MAHOGANY, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_MANGROVE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_MAPLE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_PINE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_RAINBOW_EUCALYPTUS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_REDWOOD, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_SKYRIS, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_WILLOW, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_WITCH_HAZEL, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_ZELKOVA, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_PALM, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_LAMENT, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_NIGHTSHADE, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_ETHER, sinkBlocks);
        addNonnullBlockSupplierIntoSet(ModBlocks.BYG_KITCHEN_SINK_DARK_STRIPPED_SYTHIAN, sinkBlocks);
        addBlocksToTileEntityType(ModTileEntities.KITCHEN_SINK.get(), sinkBlocks);
    }

    private static void addNonnullBlockSupplierIntoSet(Supplier<Block> blockSupplier, Set<Block> blocks)
    {
        if(blockSupplier != null)
        {
            blocks.add(blockSupplier.get());
        }
    }

    private static void addBlocksToTileEntityType(TileEntityType<?> tileEntityType, Set<Block> blocks)
    {
        Set<Block> validBlocks = new HashSet<>(((TileEntityTypeMixin) tileEntityType).getValidBlocks()); // Need to create temp set since it's stored as an immutable set
        validBlocks.addAll(blocks);
        ((TileEntityTypeMixin) tileEntityType).setValidBlocks(ImmutableSet.copyOf(validBlocks)); // Reintroduce the immutable set
    }
}
