package net.alba.albamod.albamc.entity;

import static net.alba.albamod.albamc.Albamc.MOD_ID;
import net.alba.albamod.albamc.Albamc;
import net.alba.albamod.albamc.entity.passive.BarnOwlEntity;
import net.alba.albamod.albamc.entity.render.BarnOwlEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

public class ModEntitys {
    public static EntityBuilder<?> ENTITY_BUILDER = new EntityBuilder<>(MOD_ID);

    public static EntityType<BarnOwlEntity> BARN_OWL_ENTITY = ENTITY_BUILDER.create("barn_owl", SpawnGroup.MISC, BarnOwlEntity.class)
            .withEntitySettings(entitySettings -> entitySettings.dropsNothing().dimensions(2,1))
            .withEntityRendererFactory(BarnOwlEntityRenderer::new)
            .withItemSettings(settings -> settings.maxCount(1))
            .withAttributeContainer(BarnOwlEntity.createBarnOwlAttributes())
            .buildAndRegister(BarnOwlEntity::new);

    public static void registerModEntitys() {
        Albamc.LOGGER.info("Registering Mod Entitys for " + MOD_ID);
    }
}
