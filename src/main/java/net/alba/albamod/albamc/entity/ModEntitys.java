package net.alba.albamod.albamc.entity;

import net.alba.albamod.albamc.Albamc;
import net.alba.albamod.albamc.entity.passive.BarnOwlEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntitys {
    public static final EntityType<BarnOwlEntity> BARN_OWL_ENTITY = registerEntity("barn_owl_entity", SpawnGroup.CREATURE, BarnOwlEntity::new);
    private static <T extends Entity> EntityType<T> registerEntity(String name, SpawnGroup spawnGroup, EntityType.EntityFactory<T> entityFactory) {
        return Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of(Albamc.MOD_ID, name),
                new EntityBuilder<BarnOwlEntity>(Albamc.MOD_ID)
                        .create(name, spawnGroup, BarnOwlEntity.class)
                        .withEntitySettings(entityTypeBuilder -> entityTypeBuilder
                                .dimensions(0.8F, 0.9F)
                        )
                        .withAttributeContainer(BarnOwlEntity.createBarnOwlAttributes())
                        .buildAndRegister(entityFactory)
        );
    }
    public static void registerModEntitys() {
        Albamc.LOGGER.info("Registering Mod Entitys for " + Albamc.MOD_ID);
    }
}
