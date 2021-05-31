package com.mrcrayfish.morefurniture.mixin;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mrcrayfish.morefurniture.Reference;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * A dirty hack to prevent console being spammed that a loot table is missing. Only works for blocks
 * in the mods and will still spit out warnings for other mods.
 *
 * Author: MrCrayfish
 */
@Mixin(ForgeHooks.class)
public class ForgeHooksMixin
{
    @Inject(method = "loadLootTable", at = @At(value = "HEAD"), cancellable = true, remap = false)
    private static void loadLootTableHead(Gson gson, ResourceLocation name, JsonElement data, boolean custom, LootTableManager lootTableManager, CallbackInfoReturnable<LootTable> cir)
    {
        if(name.getNamespace().equals(Reference.MOD_ID) && name.getPath().startsWith("blocks/"))
        {
            String blockName = name.getPath().substring(7);
            String modId = blockName.split("_")[0];
            if(!ModList.get().isLoaded(modId))
            {
                cir.setReturnValue(LootTable.EMPTY_LOOT_TABLE);
            }
        }
    }
}
