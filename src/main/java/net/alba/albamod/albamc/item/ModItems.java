package net.alba.albamod.albamc.item;
import net.alba.albamod.albamc.Albamc;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class ModItems {
    private ModItems(){}
    public static final Item BARN_OWL_FEATHER = new ItemBuilder<Item>("barn_owl_feather")
            .setItemGroup(ItemGroups.INGREDIENTS)
            .withSettings(settings -> settings.maxCount(64))
            .buildAndRegister();
    public static final Item BARN_OWL_WINGS = new ItemBuilder<Item>("barn_owl_wings")
            .setItemGroup(ItemGroups.INGREDIENTS)
            .withSettings(settings -> settings.maxCount(1))
            .buildAndRegister();

    public static void registerModItems() {
        Albamc.LOGGER.info("Registering Mod Items for " + Albamc.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BARN_OWL_FEATHER);
            entries.add(BARN_OWL_WINGS);
        });
    }
}