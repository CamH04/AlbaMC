package net.alba.albamod.albamc.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.alba.albamod.albamc.entity.render.BarnOwlEntityRenderer;

public class ModRenderer {
    public static void RenderModsLol(){
        EntityRendererRegistry.register(ModEntitys.BARN_OWL_ENTITY, BarnOwlEntityRenderer::new);
    }
}
