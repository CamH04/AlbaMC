package net.alba.albamod.albamc.item;
import net.alba.albamod.albamc.Albamc;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class ModItems {
    public static final Item BARN_OWL_FEATHER = registerItem("barn_owl_feather", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Albamc.MOD_ID, name), item);
    }


    public static void registerModItems() {
        Albamc.LOGGER.info("Registering Mod Items for " + Albamc.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BARN_OWL_FEATHER);
        });
    }
}