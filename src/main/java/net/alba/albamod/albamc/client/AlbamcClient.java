package net.alba.albamod.albamc.client;

import net.alba.albamod.albamc.entity.ModRenderer;
import net.fabricmc.api.ClientModInitializer;

public class AlbamcClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModRenderer.RenderModsLol();
    }
}
