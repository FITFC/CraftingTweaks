package net.blay09.mods.craftingtweaks.addons;

import net.blay09.mods.craftingtweaks.api.CraftingTweaksAPI;
import net.blay09.mods.craftingtweaks.api.SimpleTweakProvider;
import net.blay09.mods.craftingtweaks.api.TweakProvider;
import net.blay09.mods.balm.BalmModList;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

public class CraftingTweaksAddons {

    public static final Logger logger = LogManager.getLogger();

    @SuppressWarnings("unchecked")
    @Nullable
    private static SimpleTweakProvider registerSimpleProvider(String modid, String className) {
        try {
            if (BalmModList.isLoaded(modid)) {
                return CraftingTweaksAPI.registerSimpleProvider(modid, (Class<? extends AbstractContainerMenu>) Class.forName(className));
            }
        } catch (ClassNotFoundException e) {
            logger.error("Could not register Crafting Tweaks addon for {} - internal names have changed.", modid);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private static void registerProvider(String className, TweakProvider provider) {
        try {
            CraftingTweaksAPI.registerProvider((Class<? extends AbstractContainerMenu>) Class.forName(className), provider);
        } catch (ClassNotFoundException e) {
            logger.error("Could not register Crafting Tweaks addon for {} - internal names have changed.", provider.getModId());
        }
    }
}
