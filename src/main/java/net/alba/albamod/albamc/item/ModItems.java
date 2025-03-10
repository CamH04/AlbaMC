package net.alba.albamod.albamc.item;
import net.alba.albamod.albamc.Albamc;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import java.util.function.Function;


public class ModItems {
    private ModItems(){}
    public static final Item BARN_OWL_FEATHER = register("barn_owl_feather", Item::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("albamc", path));
        return Items.register(registryKey, factory, settings);
    }
    public static void registerModItems() {
        Albamc.LOGGER.info("Registering Mod Items for " + Albamc.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BARN_OWL_FEATHER);
        });
    }
}