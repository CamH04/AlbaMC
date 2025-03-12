package net.alba.albamod.albamc.item;

import net.alba.albamod.albamc.Albamc;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;


/*
* NO MINE : THATROBIN ITEM BUILDER
* */
public class ItemBuilder<T extends Item> {
    private final Identifier id;
    private final List<RegistryKey<ItemGroup>> itemGroups = new LinkedList<>();
    private Item.Settings itemSettings = new Item.Settings();

    public static <T extends Item> ItemBuilder<T> create(String name) {
        return new ItemBuilder<>(name);
    }

    ItemBuilder(String name) {
        this.id = Albamc.identifier(name);
    }

    @SafeVarargs
    public final ItemBuilder<T> setItemGroup(RegistryKey<ItemGroup>... itemGroup) {
        this.itemGroups.addAll(Arrays.stream(itemGroup).toList());
        return this;
    }

    public ItemBuilder<T> withSettings(Function<Item.Settings,Item.Settings> settingsFunction) {
        this.itemSettings = settingsFunction.apply(this.itemSettings);
        return this;
    }

    public ItemBuilder<T> withSettings(Item.Settings settings) {
        this.itemSettings = settings;
        return this;
    }

    public Item buildAndRegister() {
        return this.buildAndRegister(Item::new);
    }

    public <T extends Item> T buildAndRegister(@NotNull Function<Item.Settings, T> itemFunction) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, this.id);
        T item = itemFunction.apply(this.itemSettings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        for (RegistryKey<ItemGroup> itemGroup : this.itemGroups) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register((fabricItemGroupEntries -> {
                fabricItemGroupEntries.add(item);
            }));
        }
        return item;
    }
}
