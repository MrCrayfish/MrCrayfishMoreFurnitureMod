package com.mrcrayfish.morefurniture;

import biomesoplenty.api.block.BOPBlocks;
import com.minecraftabnormals.autumnity.core.registry.AutumnityBlocks;
import com.minecraftabnormals.environmental.core.registry.EnvironmentalBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import javax.annotation.Nullable;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A helper class to generate code :)
 * <p>
 * Author: MrCrayfish
 */
public class Generator
{
    public static final FurnitureType TABLE = new FurnitureType("table", "TableBlock", "Block.Properties.create(WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)");
    public static final FurnitureType CHAIR = new FurnitureType("chair", "ChairBlock", "Block.Properties.create(WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)");
    public static final FurnitureType COFFEE_TABLE = new FurnitureType("coffee_table", "CoffeeTableBlock", "Block.Properties.create(WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)");
    public static final FurnitureType CABINET = new FurnitureType("cabinet", "CabinetBlock", "Block.Properties.create(WOOD).hardnessAndResistance(1.0F).sound(SoundType.WOOD)");
    public static final FurnitureType BEDSIDE_CABINET = new FurnitureType("bedside_cabinet", "BedsideCabinetBlock", "Block.Properties.create(WOOD).hardnessAndResistance(1.0F).sound(SoundType.WOOD)");
    public static final FurnitureType DESK = new FurnitureType("desk", "DeskBlock", "Block.Properties.create(WOOD).hardnessAndResistance(1.0F).sound(SoundType.WOOD)", "DeskBlock.MaterialType.OAK");
    public static final FurnitureType DESK_CABINET = new FurnitureType("desk_cabinet", "DeskCabinetBlock", "Block.Properties.create(WOOD).hardnessAndResistance(1.0F).sound(SoundType.WOOD)", "DeskBlock.MaterialType.OAK");
    public static final FurnitureType BLINDS = new FurnitureType("blinds", "BlindsBlock", "Block.Properties.create(WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)");
    public static final FurnitureType UPGRADED_FENCE = new FurnitureType("upgraded_fence", "UpgradedFenceBlock", "Block.Properties.create(WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)");
    public static final FurnitureType UPGRADED_GATE = new FurnitureType("upgraded_gate", "UpgradedGateBlock", "Block.Properties.create(WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)");
    public static final FurnitureType CRATE = new FurnitureType("crate", "CrateBlock", "Block.Properties.create(WOOD).hardnessAndResistance(2.0F, 10.0F).sound(SoundType.WOOD)");
    public static final FurnitureType PARK_BENCH = new FurnitureType("park_bench", "ParkBenchBlock", "Block.Properties.create(WOOD).hardnessAndResistance(2.0F, 10.0F).sound(SoundType.WOOD)");
    public static final FurnitureType MAIL_BOX = new FurnitureType("mail_box", "MailBoxBlock", "Block.Properties.from(Blocks.OAK_PLANKS)");
    public static final FurnitureType KITCHEN_COUNTER = new FurnitureType("kitchen_counter", "KitchenCounterBlock", "Block.Properties.from(Blocks.OAK_PLANKS)");
    public static final FurnitureType KITCHEN_DRAWER = new FurnitureType("kitchen_drawer", "KitchenDrawerBlock", "Block.Properties.from(Blocks.OAK_PLANKS)");
    public static final FurnitureType KITCHEN_SINK_LIGHT = new FurnitureType("kitchen_sink_light", "KitchenSinkBlock", "Block.Properties.from(Blocks.OAK_PLANKS)", "true");
    public static final FurnitureType KITCHEN_SINK_DARK = new FurnitureType("kitchen_sink_dark", "KitchenSinkBlock", "Block.Properties.from(Blocks.OAK_PLANKS)", "true");
    public static final FurnitureType[] FURNITURE_TYPES = {TABLE, CHAIR, COFFEE_TABLE, CABINET, BEDSIDE_CABINET, DESK, DESK_CABINET, BLINDS, UPGRADED_FENCE, UPGRADED_GATE, CRATE, PARK_BENCH, MAIL_BOX, KITCHEN_COUNTER, KITCHEN_DRAWER, KITCHEN_SINK_LIGHT, KITCHEN_SINK_DARK};

    private List<Variant> registeredVariants = new ArrayList<>();

    public Generator()
    {
        this.registerVariant("maple", AutumnityBlocks.MAPLE_LOG.get(), AutumnityBlocks.MAPLE_PLANKS.get(), AutumnityBlocks.STRIPPED_MAPLE_LOG.get());
        this.registerVariant("willow", EnvironmentalBlocks.WILLOW_LOG.get(), EnvironmentalBlocks.WILLOW_PLANKS.get(), EnvironmentalBlocks.STRIPPED_WILLOW_LOG.get());
        this.registerVariant("cherry", EnvironmentalBlocks.CHERRY_LOG.get(), EnvironmentalBlocks.CHERRY_PLANKS.get(), EnvironmentalBlocks.STRIPPED_CHERRY_LOG.get());
        this.registerVariant("wisteria", EnvironmentalBlocks.WISTERIA_LOG.get(), EnvironmentalBlocks.WISTERIA_PLANKS.get(), EnvironmentalBlocks.STRIPPED_WISTERIA_LOG.get());
        this.registerVariant("fir", BOPBlocks.fir_log, BOPBlocks.fir_planks, BOPBlocks.stripped_fir_log);
        this.registerVariant("redwood", BOPBlocks.redwood_log, BOPBlocks.redwood_planks, BOPBlocks.stripped_redwood_log);
        this.registerVariant("cherry", BOPBlocks.cherry_log, BOPBlocks.cherry_planks, BOPBlocks.stripped_cherry_log);
        this.registerVariant("mahogany", BOPBlocks.mahogany_log, BOPBlocks.mahogany_planks, BOPBlocks.stripped_mahogany_log);
        this.registerVariant("jacaranda", BOPBlocks.jacaranda_log, BOPBlocks.jacaranda_planks, BOPBlocks.stripped_jacaranda_log);
        this.registerVariant("palm", BOPBlocks.palm_log, BOPBlocks.palm_planks, BOPBlocks.stripped_palm_log);
        this.registerVariant("willow", BOPBlocks.willow_log, BOPBlocks.willow_planks, BOPBlocks.stripped_willow_log);
        this.registerVariant("dead", BOPBlocks.dead_log, BOPBlocks.dead_planks, BOPBlocks.stripped_dead_log);
        this.registerVariant("magic", BOPBlocks.magic_log, BOPBlocks.magic_planks, BOPBlocks.stripped_magic_log);
        this.registerVariant("umbran", BOPBlocks.umbran_log, BOPBlocks.umbran_planks, BOPBlocks.stripped_umbran_log);
        this.registerVariant("hellbark", BOPBlocks.hellbark_log, BOPBlocks.hellbark_planks, BOPBlocks.stripped_hellbark_log);
    }

    public void registerVariant(String id, Block log, Block planks, @Nullable Block strippedLog)
    {
        this.registeredVariants.add(new Variant(id, log, planks, strippedLog));
    }

    public void generate()
    {
        try(BufferedWriter writer = IOUtils.buffer(new FileWriter("ModBlocks.txt")))
        {
            for(FurnitureType type : FURNITURE_TYPES)
            {
                for(Variant variant : this.registeredVariants)
                {
                    String blockArgs = String.join(",", type.args);
                    String blockRegistryObject = String.format("public static final RegistryObject<Block> %1$s_%2$s_%3$s = register(\"%4$s_%5$s_%6$s\", new %7$s(%8$s));", variant.log.getRegistryName().getNamespace().toUpperCase(), type.id.toUpperCase(), variant.id.toUpperCase(), variant.log.getRegistryName().getNamespace(), variant.id, type.id, type.className, blockArgs);
                    writer.write(blockRegistryObject);
                    writer.write("\n");
                }

                for(Variant variant : this.registeredVariants)
                {
                    if(variant.strippedLog != null)
                    {
                        String blockArgs = String.join(",", type.args);
                        String blockRegistryObject = String.format("public static final RegistryObject<Block> %1$s_%2$s_STRIPPED_%3$s = register(\"%4$s_stripped_%5$s_%6$s\", new %7$s(%8$s));", variant.log.getRegistryName().getNamespace().toUpperCase(), type.id.toUpperCase(), variant.id.toUpperCase(), variant.log.getRegistryName().getNamespace(), variant.id, type.id, type.className, blockArgs);
                        writer.write(blockRegistryObject);
                        writer.write("\n");
                    }
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        try(BufferedWriter writer = IOUtils.buffer(new FileWriter("en_us.json")))
        {
            writer.write("{\n");
            for(FurnitureType type : FURNITURE_TYPES)
            {
                for(Variant variant : this.registeredVariants)
                {
                    String variantName = I18n.format(variant.log.getTranslationKey()).split("\\s++")[0];
                    String furnitureName = variantName + " " + WordUtils.capitalize(type.id.replace("_", " "));
                    writer.write(String.format("    \"block.%1$s.%2$s_%3$s_%4$s\": \"%5$s\",", Reference.MOD_ID, variant.log.getRegistryName().getNamespace(), variant.id, type.id, furnitureName));
                    writer.write("\n");
                }

                for(Variant variant : this.registeredVariants)
                {
                    if(variant.strippedLog != null)
                    {
                        String variantName = I18n.format(variant.log.getTranslationKey()).split("\\s++")[0];
                        String furnitureName = "Stripped " + variantName + " " + WordUtils.capitalize(type.id.replace("_", " "));
                        writer.write(String.format("    \"block.%1$s.%2$s_stripped_%3$s_%4$s\": \"%5$s\",", Reference.MOD_ID, variant.log.getRegistryName().getNamespace(), variant.id, type.id, furnitureName));
                        writer.write("\n");
                    }
                }
            }
            writer.write("}");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static class Variant
    {
        private String id;
        private Block log;
        private Block planks;
        @Nullable
        private Block strippedLog;

        public Variant(String id, Block log, Block planks, @Nullable Block strippedLog)
        {
            this.id = id;
            this.log = log;
            this.planks = planks;
            this.strippedLog = strippedLog;
        }
    }

    public static class FurnitureType
    {
        private String id;
        private String className;
        private String[] args;

        public FurnitureType(String id, String className, String ... args)
        {
            this.id = id;
            this.className = className;
            this.args = args;
        }
    }
}
