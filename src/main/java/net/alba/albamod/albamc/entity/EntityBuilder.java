package net.alba.albamod.albamc.entity;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
/*
 * NO MINE : THATROBIN Entity BUILDER
 * */
public class EntityBuilder<T extends Entity> {
    private final String namespace;
    private Identifier id;
    private Class<?> entityTypeClass;

    private Function<EntityType.Builder<?>,EntityType.Builder<?>> entitySettings = (builder) -> builder;
    private SpawnGroup spawnGroup;
    private DefaultAttributeContainer.Builder attributeContainer;

    private Item.Settings itemSettings = new Item.Settings();
    private final List<RegistryKey<ItemGroup>> itemGroups = new LinkedList<>();

    public EntityBuilder<T> create(String name, SpawnGroup spawnGroup) {
        return create(name, spawnGroup, null);
    }

    public EntityBuilder<T> create(String name, SpawnGroup spawnGroup, Class<? extends Entity> entityTypeClass) {
        this.id = Identifier.of(this.namespace, name);
        this.entityTypeClass = entityTypeClass;
        this.spawnGroup = spawnGroup;
        this.itemGroups.add(ItemGroups.SPAWN_EGGS);
        return this;
    }

    public EntityBuilder(String namespace) {
        this.namespace = namespace;
    }

    public final EntityBuilder<T> setSpawnGroup() {
        // Add the items to the list of item groups
        return this;
    }

    @SafeVarargs
    public final EntityBuilder<T> setItemGroup(RegistryKey<ItemGroup>... itemGroup) {
        // Add the items to the list of item groups
        this.itemGroups.addAll(Arrays.stream(itemGroup).toList());
        return this;
    }

    public EntityBuilder<T> withItemSettings(Function<Item.Settings,Item.Settings> settingsFunction) {
        // modify the current item settings to include the parameters provided by the function
        this.itemSettings = settingsFunction.apply(this.itemSettings);
        return this;
    }

    public EntityBuilder<T> withItemSettings(Item.Settings settings) {
        // Set the item settings to this
        this.itemSettings = settings;
        return this;
    }

    public EntityBuilder<T> withEntitySettings(Function<EntityType.Builder<?>,EntityType.Builder<?>> settingsFunction) {
        // modify the current item settings to include the parameters provided by the function
        this.entitySettings = this.entitySettings.andThen(settingsFunction);
        return this;
    }

    public EntityBuilder<T> withAttributeContainer(DefaultAttributeContainer.Builder attributeContainer) {
        this.attributeContainer = attributeContainer;
        return this;
    }

    public <T extends Entity> EntityType<T> buildAndRegister(@NotNull EntityType.EntityFactory<T> entityFunction) {
        // Create RegistryKey for the block
        RegistryKey<EntityType<?>> entityKey = RegistryKey.of(RegistryKeys.ENTITY_TYPE, this.id);

        // Create and register the block
        EntityType<?> entityType = this.entitySettings.apply(EntityType.Builder.create(entityFunction, this.spawnGroup)).dropsNothing().makeFireImmune().dimensions(.98F, .98F).eyeHeight(0.15F).maxTrackingRange(10).trackingTickInterval(10).build(entityKey);

        if(entityTypeClass != null && MobEntity.class.isAssignableFrom(entityTypeClass)) {
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, this.id);
            this.itemSettings.registryKey(itemKey);
            SpawnEggItem spawnEggItem = new SpawnEggItem((EntityType<? extends MobEntity>) entityType, this.itemSettings);
            Registry.register(Registries.ITEM, itemKey, spawnEggItem);

            for (RegistryKey<ItemGroup> itemGroup : this.itemGroups) {
                ItemGroupEvents.modifyEntriesEvent(itemGroup).register((fabricItemGroupEntries -> {
                    fabricItemGroupEntries.add(spawnEggItem);
                }));
            }
        }

        if(this.attributeContainer != null && LivingEntity.class.isAssignableFrom(entityTypeClass)) {
            FabricDefaultAttributeRegistry.register((EntityType<? extends LivingEntity>) entityType, this.attributeContainer);
        }

        return (EntityType<T>) Registry.register(Registries.ENTITY_TYPE, entityKey, entityType);
    }
}