package net.blay09.mods.craftingtweaks.client;

import net.blay09.mods.balm.api.client.BalmClient;
import net.blay09.mods.craftingtweaks.CraftingTweaks;
import net.fabricmc.api.ClientModInitializer;

public class FabricCraftingTweaksClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BalmClient.initialize(CraftingTweaks.MOD_ID, CraftingTweaksClient::initialize);
    }
}
