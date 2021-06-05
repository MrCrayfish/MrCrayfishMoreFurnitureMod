package com.mrcrayfish.morefurniture;

import biomesoplenty.api.block.BOPBlocks;
import com.minecraftabnormals.atmospheric.core.registry.AtmosphericBlocks;
import com.minecraftabnormals.autumnity.core.registry.AutumnityBlocks;
import com.minecraftabnormals.endergetic.core.registry.EEBlocks;
import com.minecraftabnormals.environmental.core.registry.EnvironmentalBlocks;
import com.minecraftabnormals.upgrade_aquatic.core.registry.UABlocks;
import corgiaoc.byg.core.BYGBlocks;
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

        // Upgrade Aquatic
        this.registerVariant("driftwood", UABlocks.DRIFTWOOD_LOG.get(), UABlocks.DRIFTWOOD_PLANKS.get(), UABlocks.STRIPPED_DRIFTWOOD_LOG.get());
        this.registerVariant("river", UABlocks.RIVER_LOG.get(), UABlocks.RIVER_PLANKS.get(), UABlocks.STRIPPED_RIVER_LOG.get());

        // The Endergetic Expansion
        this.registerVariant("poise", EEBlocks.POISE_STEM.get(), EEBlocks.POISE_PLANKS.get(), EEBlocks.STRIPPED_POISE_STEM.get(), true);

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
        
        //Oh The Biomes You'll Go
        this.registerVariant("aspen", BYGBlocks.ASPEN_LOG, BYGBlocks.ASPEN_PLANKS, BYGBlocks.STRIPPED_ASPEN_LOG);
        this.registerVariant("baobab", BYGBlocks.BAOBAB_LOG, BYGBlocks.BAOBAB_PLANKS, BYGBlocks.STRIPPED_BAOBAB_LOG);
        this.registerVariant("blue_enchanted", BYGBlocks.BLUE_ENCHANTED_LOG, BYGBlocks.BLUE_ENCHANTED_PLANKS, BYGBlocks.STRIPPED_BLUE_ENCHANTED_LOG);
        this.registerVariant("cherry", BYGBlocks.CHERRY_LOG, BYGBlocks.CHERRY_PLANKS, BYGBlocks.STRIPPED_CHERRY_LOG);
        this.registerVariant("cika", BYGBlocks.CIKA_LOG, BYGBlocks.CIKA_PLANKS, BYGBlocks.STRIPPED_CIKA_LOG);
        this.registerVariant("cypress", BYGBlocks.CYPRESS_LOG, BYGBlocks.CYPRESS_PLANKS, BYGBlocks.STRIPPED_CYPRESS_LOG);
        this.registerVariant("ebony", BYGBlocks.EBONY_LOG, BYGBlocks.EBONY_PLANKS, BYGBlocks.STRIPPED_EBONY_LOG);
        this.registerVariant("fir", BYGBlocks.FIR_LOG, BYGBlocks.FIR_PLANKS, BYGBlocks.STRIPPED_FIR_LOG);
        this.registerVariant("green_enchanted", BYGBlocks.GREEN_ENCHANTED_LOG, BYGBlocks.GREEN_ENCHANTED_PLANKS, BYGBlocks.STRIPPED_GREEN_ENCHANTED_LOG);
        this.registerVariant("holly", BYGBlocks.HOLLY_LOG, BYGBlocks.HOLLY_PLANKS, BYGBlocks.STRIPPED_HOLLY_LOG);
        this.registerVariant("jacaranda", BYGBlocks.JACARANDA_LOG, BYGBlocks.JACARANDA_PLANKS, BYGBlocks.STRIPPED_JACARANDA_LOG);
        this.registerVariant("mahogany", BYGBlocks.MAHOGANY_LOG, BYGBlocks.MAHOGANY_PLANKS, BYGBlocks.STRIPPED_MAHOGANY_LOG);
        this.registerVariant("mangrove", BYGBlocks.MANGROVE_LOG, BYGBlocks.MANGROVE_PLANKS, BYGBlocks.STRIPPED_MANGROVE_LOG);
        this.registerVariant("maple", BYGBlocks.MAPLE_LOG, BYGBlocks.MAPLE_PLANKS, BYGBlocks.STRIPPED_MAPLE_LOG);
        this.registerVariant("pine", BYGBlocks.PINE_LOG, BYGBlocks.PINE_PLANKS, BYGBlocks.STRIPPED_PINE_LOG);
        this.registerVariant("rainbow_eucalyptus", BYGBlocks.RAINBOW_EUCALYPTUS_LOG, BYGBlocks.RAINBOW_EUCALYPTUS_PLANKS, BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG);
        this.registerVariant("redwood", BYGBlocks.REDWOOD_LOG, BYGBlocks.REDWOOD_PLANKS, BYGBlocks.STRIPPED_REDWOOD_LOG);
        this.registerVariant("skyris", BYGBlocks.SKYRIS_LOG, BYGBlocks.SKYRIS_PLANKS, BYGBlocks.STRIPPED_SKYRIS_LOG);
        this.registerVariant("willow", BYGBlocks.WILLOW_LOG, BYGBlocks.WILLOW_PLANKS, BYGBlocks.STRIPPED_WILLOW_LOG);
        this.registerVariant("witch_hazel", BYGBlocks.WITCH_HAZEL_LOG, BYGBlocks.WITCH_HAZEL_PLANKS, BYGBlocks.STRIPPED_WITCH_HAZEL_LOG);
        this.registerVariant("zelkova", BYGBlocks.ZELKOVA_LOG, BYGBlocks.ZELKOVA_PLANKS, BYGBlocks.STRIPPED_ZELKOVA_LOG);
        this.registerVariant("palm", BYGBlocks.PALM_LOG, BYGBlocks.PALM_PLANKS, BYGBlocks.STRIPPED_PALM_LOG);
        this.registerVariant("lament", BYGBlocks.LAMENT_LOG, BYGBlocks.LAMENT_PLANKS, BYGBlocks.STRIPPED_LAMENT_LOG);
        this.registerVariant("nightshade", BYGBlocks.NIGHTSHADE_LOG, BYGBlocks.NIGHTSHADE_PLANKS, BYGBlocks.STRIPPED_NIGHTSHADE_LOG);
        this.registerVariant("ether", BYGBlocks.ETHER_LOG, BYGBlocks.ETHER_PLANKS, BYGBlocks.STRIPPED_ETHER_LOG);
        this.registerVariant("sythian", BYGBlocks.SYTHIAN_STEM, BYGBlocks.SYTHIAN_PLANKS, BYGBlocks.STRIPPED_SYTHIAN_STEM, true);
        this.registerVariant("bulbis", BYGBlocks.BULBIS_STEM, BYGBlocks.BULBIS_PLANKS, null, true);
        this.registerVariant("imparius", BYGBlocks.IMPARIUS_STEM, BYGBlocks.IMPARIUS_PLANKS, null, true);
    }

    public void registerVariant(String id, Block log, Block planks, @Nullable Block strippedLog)
    {
        this.registeredVariants.add(new Variant(id, log, planks, strippedLog));
    }

    public void registerVariant(String id, Block log, Block planks, @Nullable Block strippedLog, boolean stem)
    {
        this.registeredVariants.add(new Variant(id, log, planks, strippedLog, stem));
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

        /* ||||||||||||||| Generate Colors code ||||||||||||||| */
        try(BufferedWriter writer = IOUtils.buffer(new FileWriter("Colors.txt")))
        {
            FurnitureType[] types = {CRATE, KITCHEN_COUNTER, KITCHEN_SINK_LIGHT, KITCHEN_SINK_DARK};
            for(FurnitureType type : types)
            {
                for(Variant variant : this.registeredVariants)
                {
                    if(variant.getStrippedLog() == null)
                        continue;
                    String blockRegistryObject = String.format("registerStrippedColorsOne(ModBlocks.%s_%s_STRIPPED_%s);", variant.log.getRegistryName().getNamespace().toUpperCase(), type.id.toUpperCase(), variant.id.toUpperCase());
                    writer.write(blockRegistryObject);
                    writer.newLine();
                }
            }

            for(FurnitureType type : types)
            {
                for(Variant variant : this.registeredVariants)
                {
                    if(variant.getStrippedLog() == null)
                        continue;
                    String blockRegistryObject = String.format("registerStrippedColorsOne(ModBlocks.%s_%s_STRIPPED_%s);", variant.log.getRegistryName().getNamespace().toUpperCase(), type.id.toUpperCase(), variant.id.toUpperCase());
                    writer.write(blockRegistryObject);
                    writer.write("\n");
                }
            }

            for(Variant variant : this.registeredVariants)
            {
                if(variant.getStrippedLog() == null)
                    continue;
                String blockRegistryObject = String.format("registerStrippedColorsTwo(ModBlocks.%s_%s_STRIPPED_%s);", variant.log.getRegistryName().getNamespace().toUpperCase(), PARK_BENCH.id.toUpperCase(), variant.id.toUpperCase());
                writer.write(blockRegistryObject);
                writer.write("\n");
            }

            for(Variant variant : this.registeredVariants)
            {
                if(variant.getStrippedLog() == null)
                    continue;
                String blockRegistryObject = String.format("registerStrippedColorsTwo(ModBlocks.%s_%s_STRIPPED_%s);", variant.log.getRegistryName().getNamespace().toUpperCase(), PARK_BENCH.id.toUpperCase(), variant.id.toUpperCase());
                writer.write(blockRegistryObject);
                writer.write("\n");
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

        this.clearGeneratedFiles(new File("resources/output/"));

        for(Variant variant : this.registeredVariants)
        {
            String modId = variant.getLog().getRegistryName().getNamespace();
            String variantId = variant.id;
            boolean stripped = variant.getStrippedLog() != null;
            boolean stem = variant.isStem();
            this.generateFiles("blockstates", modId, variantId, stripped, stem);
            this.generateFiles("models/block", modId, variantId, stripped, stem);
            this.generateFiles("models/item", modId, variantId, stripped, stem);
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

    private void generateFiles(String folder, String modId, String variant, boolean stripped, boolean stem)
    {
        if(variant.equals("bulbis"))
            System.out.println("YEP");

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
                            continue;
                        if(file.getName().contains("stripped") && !stripped)
                            continue;

                        String contents = new String(Files.readAllBytes(Paths.get(file.toURI())));
                        String newFileName = file.getName().replace("{color}", variant).replace("{modid}", modId);
                        String newContents = contents;
                        if(stem)
                        {
                            if(!stripped)
                            {
                                newContents = newContents.replace("stripped_{color}_log", "{color}_planks");
                            }
                            newContents = newContents.replace("_log", "_stem");
                        }
                        newContents = newContents.replace("{color}", variant).replace("{modid}", modId);

                        // An except to Endergetic since it doesn't follow standard naming of textures
                        if(modId.equals("endergetic"))
                        {
                            newContents = newContents.replace("block/stripped_poise_stem", "block/poise_stem_stripped");
                        }

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
        private final String id;
        private final Block log;
        private final Block planks;
        @Nullable
        private final Block strippedLog;
        private final boolean stem;

        public Variant(String id, Block log, Block planks, @Nullable Block strippedLog)
        {
            this(id, log, planks, strippedLog, false);
        }

        public Variant(String id, Block log, Block planks, @Nullable Block strippedLog, boolean stem)
        {
            this.id = id;
            this.log = log;
            this.planks = planks;
            this.strippedLog = strippedLog;
            this.stem = stem;
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

        public boolean isStem()
        {
            return this.stem;
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
