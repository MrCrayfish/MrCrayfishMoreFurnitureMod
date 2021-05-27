package com.mrcrayfish.morefurniture;

import biomesoplenty.api.block.BOPBlocks;
import com.minecraftabnormals.atmospheric.core.registry.AtmosphericBlocks;
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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * A helper class to generate code :)
 * <p>
 * Author: MrCrayfish
 */
public class Generator
{
    public static final FurnitureType TABLE = new FurnitureType("table", "TableBlock", new String[]{"Block.Properties.create(WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)"});
    public static final FurnitureType CHAIR = new FurnitureType("chair", "ChairBlock", new String[]{"Block.Properties.create(WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)"});
    public static final FurnitureType COFFEE_TABLE = new FurnitureType("coffee_table", "CoffeeTableBlock", new String[]{"Block.Properties.create(WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)"});
    public static final FurnitureType CABINET = new FurnitureType("cabinet", "CabinetBlock", new String[]{"Block.Properties.create(WOOD).hardnessAndResistance(1.0F).sound(SoundType.WOOD)"});
    public static final FurnitureType BEDSIDE_CABINET = new FurnitureType("bedside_cabinet", "BedsideCabinetBlock", new String[]{"Block.Properties.create(WOOD).hardnessAndResistance(1.0F).sound(SoundType.WOOD)"});
    public static final FurnitureType DESK = new FurnitureType("desk", "DeskBlock", new String[]{"Block.Properties.create(WOOD).hardnessAndResistance(1.0F).sound(SoundType.WOOD)", "DeskBlock.MaterialType.OAK"});
    public static final FurnitureType DESK_CABINET = new FurnitureType("desk_cabinet", "DeskCabinetBlock", new String[]{"Block.Properties.create(WOOD).hardnessAndResistance(1.0F).sound(SoundType.WOOD)", "DeskBlock.MaterialType.OAK"});
    public static final FurnitureType BLINDS = new FurnitureType("blinds", "BlindsBlock", new String[]{"Block.Properties.create(WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)"});
    public static final FurnitureType UPGRADED_FENCE = new FurnitureType("upgraded_fence", "UpgradedFenceBlock", new String[]{"Block.Properties.create(WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)"});
    public static final FurnitureType UPGRADED_GATE = new FurnitureType("upgraded_gate", "UpgradedGateBlock", new String[]{"Block.Properties.create(WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)"});
    public static final FurnitureType CRATE = new FurnitureType("crate", "CrateBlock", new String[]{"Block.Properties.create(WOOD).hardnessAndResistance(2.0F, 10.0F).sound(SoundType.WOOD)"});
    public static final FurnitureType PARK_BENCH = new FurnitureType("park_bench", "ParkBenchBlock", new String[]{"Block.Properties.create(WOOD).hardnessAndResistance(2.0F, 10.0F).sound(SoundType.WOOD)"});
    public static final FurnitureType MAIL_BOX = new FurnitureType("mail_box", "MailBoxBlock", new String[]{"Block.Properties.from(Blocks.OAK_PLANKS)"});
    public static final FurnitureType KITCHEN_COUNTER = new FurnitureType("kitchen_counter", "KitchenCounterBlock", new String[]{"Block.Properties.from(Blocks.OAK_PLANKS)"});
    public static final FurnitureType KITCHEN_DRAWER = new FurnitureType("kitchen_drawer", "KitchenDrawerBlock", new String[]{"Block.Properties.from(Blocks.OAK_PLANKS)"});
    public static final FurnitureType KITCHEN_SINK_LIGHT = new FurnitureType("kitchen_sink_light", "KitchenSinkBlock", new String[]{"Block.Properties.from(Blocks.OAK_PLANKS)", "true"});
    public static final FurnitureType KITCHEN_SINK_DARK = new FurnitureType("kitchen_sink_dark", "KitchenSinkBlock", new String[]{"Block.Properties.from(Blocks.OAK_PLANKS)", "true"});
    public static final FurnitureType[] FURNITURE_TYPES = {TABLE, CHAIR, COFFEE_TABLE, CABINET, BEDSIDE_CABINET, DESK, DESK_CABINET, BLINDS, UPGRADED_FENCE, UPGRADED_GATE, CRATE, PARK_BENCH, MAIL_BOX, KITCHEN_COUNTER, KITCHEN_DRAWER, KITCHEN_SINK_LIGHT, KITCHEN_SINK_DARK};

    private List<Variant> registeredVariants = new ArrayList<>();

    public Generator()
    {
        // Autumnity
        this.registerVariant("maple", AutumnityBlocks.MAPLE_LOG.get(), AutumnityBlocks.MAPLE_PLANKS.get(), AutumnityBlocks.STRIPPED_MAPLE_LOG.get());
        
        // Environmental
        this.registerVariant("willow", EnvironmentalBlocks.WILLOW_LOG.get(), EnvironmentalBlocks.WILLOW_PLANKS.get(), EnvironmentalBlocks.STRIPPED_WILLOW_LOG.get());
        this.registerVariant("cherry", EnvironmentalBlocks.CHERRY_LOG.get(), EnvironmentalBlocks.CHERRY_PLANKS.get(), EnvironmentalBlocks.STRIPPED_CHERRY_LOG.get());
        this.registerVariant("wisteria", EnvironmentalBlocks.WISTERIA_LOG.get(), EnvironmentalBlocks.WISTERIA_PLANKS.get(), EnvironmentalBlocks.STRIPPED_WISTERIA_LOG.get());
        
        // Atmospheric
        this.registerVariant("rosewood", AtmosphericBlocks.ROSEWOOD_LOG.get(), AtmosphericBlocks.ROSEWOOD_PLANKS.get(), AtmosphericBlocks.STRIPPED_ROSEWOOD_LOG.get());
        this.registerVariant("morado", AtmosphericBlocks.MORADO_LOG.get(), AtmosphericBlocks.MORADO_PLANKS.get(), AtmosphericBlocks.STRIPPED_MORADO_LOG.get());
        this.registerVariant("yucca", AtmosphericBlocks.YUCCA_LOG.get(), AtmosphericBlocks.YUCCA_PLANKS.get(), AtmosphericBlocks.STRIPPED_YUCCA_LOG.get());
        this.registerVariant("kousa", AtmosphericBlocks.KOUSA_LOG.get(), AtmosphericBlocks.KOUSA_PLANKS.get(), AtmosphericBlocks.STRIPPED_KOUSA_LOG.get());
        this.registerVariant("aspen", AtmosphericBlocks.ASPEN_LOG.get(), AtmosphericBlocks.ASPEN_PLANKS.get(), AtmosphericBlocks.STRIPPED_ASPEN_LOG.get());
        this.registerVariant("grimwood", AtmosphericBlocks.GRIMWOOD_LOG.get(), AtmosphericBlocks.GRIMWOOD_PLANKS.get(), AtmosphericBlocks.STRIPPED_GRIMWOOD_LOG.get());

        // Biomes O Plenty
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

    public List<Variant> getRegisteredVariants()
    {
        return this.registeredVariants;
    }

    public void generate()
    {
        /* ||||||||||||||| Generate ModBlocks code ||||||||||||||| */
        try(BufferedWriter writer = IOUtils.buffer(new FileWriter("ModBlocks.txt")))
        {
            for(FurnitureType type : FURNITURE_TYPES)
            {
                for(Variant variant : this.registeredVariants)
                {
                    String blockArgs = String.join(",", type.args);
                    String blockRegistryObject = String.format("public static final RegistryObject<Block> %1$s_%2$s_%3$s = registerOptional(\"%9$s\", \"%4$s_%5$s_%6$s\", new %7$s(%8$s));", variant.log.getRegistryName().getNamespace().toUpperCase(), type.id.toUpperCase(), variant.id.toUpperCase(), variant.log.getRegistryName().getNamespace(), variant.id, type.id, type.className, blockArgs, variant.log.getRegistryName().getNamespace());
                    writer.write(blockRegistryObject);
                    writer.write("\n");
                }

                for(Variant variant : this.registeredVariants)
                {
                    if(variant.strippedLog != null)
                    {
                        String blockArgs = String.join(",", type.args);
                        String blockRegistryObject = String.format("public static final RegistryObject<Block> %1$s_%2$s_STRIPPED_%3$s = registerOptional(\"%9$s\", \"%4$s_stripped_%5$s_%6$s\", new %7$s(%8$s));", variant.log.getRegistryName().getNamespace().toUpperCase(), type.id.toUpperCase(), variant.id.toUpperCase(), variant.log.getRegistryName().getNamespace(), variant.id, type.id, type.className, blockArgs, variant.log.getRegistryName().getNamespace());
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

        /* ||||||||||||||| Generate lang file ||||||||||||||| */
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

        /* ||||||||||||||| Generate recipe gen code ||||||||||||||| */
        try(BufferedWriter writer = IOUtils.buffer(new FileWriter("RecipeGen.txt")))
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

        this.clearGeneratedFiles(new File("resources/output/"));

        for(Variant variant : this.registeredVariants)
        {
            String modId = variant.getLog().getRegistryName().getNamespace();
            String variantId = variant.id;
            boolean stripped = variant.getStrippedLog() != null;
            this.generateFiles("blockstates", modId, variantId, stripped);
            this.generateFiles("models/block", modId, variantId, stripped);
            this.generateFiles("models/item", modId, variantId, stripped);
        }
    }

    private void clearGeneratedFiles(File folder)
    {
        for(File file : Objects.requireNonNull(folder.listFiles()))
        {
            if(file.isDirectory())
            {
                this.clearGeneratedFiles(file);
                continue;
            }
            file.delete();
        }
    }

    private void generateFiles(String folder, String modId, String variant, boolean stripped)
    {
        try
        {
            File input = new File("resources/input/" + folder);
            File output = new File("resources/output/" + folder);
            if(input.isDirectory() && output.isDirectory())
            {
                File[] inputFiles = input.listFiles();
                if(inputFiles != null)
                {
                    for(File file : inputFiles)
                    {
                        if(file.isDirectory())
                            return;
                        if(file.getName().contains("stripped") && !stripped)
                            return;
                        String contents = new String(Files.readAllBytes(Paths.get(file.toURI())));
                        String newFileName = file.getName().replace("{color}", variant).replace("{modid}", modId);
                        String newContents = contents.replace("{color}", variant).replace("{modid}", modId);
                        Files.write(Paths.get(new File(output, newFileName).toURI()), newContents.getBytes(), StandardOpenOption.CREATE);
                    }
                }
            }
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

        public String getId()
        {
            return this.id;
        }

        public Block getLog()
        {
            return this.log;
        }

        public Block getPlanks()
        {
            return this.planks;
        }

        @Nullable
        public Block getStrippedLog()
        {
            return this.strippedLog;
        }
    }

    public static class FurnitureType
    {
        private String id;
        private String className;
        private String[] args;

        public FurnitureType(String id, String className, String[] args)
        {
            this.id = id;
            this.className = className;
            this.args = args;
        }

        public String getId()
        {
            return id;
        }

        public String getClassName()
        {
            return className;
        }

        public String[] getArgs()
        {
            return args;
        }
    }
}
