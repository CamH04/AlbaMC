package net.alba.albamod.albamc.item;
import net.alba.albamod.albamc.Albamc;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.util.Rarity;
import net.minecraft.util.Unit;


public class ModItems {
    private ModItems(){}
    //region BARN OWL ====================================================================================
    //endregion
    public static final Item BARN_OWL_FEATHER = new ItemBuilder<Item>("barn_owl_feather")
            .setItemGroup(ItemGroups.INGREDIENTS)
            .withSettings(settings -> settings.maxCount(64))
            .buildAndRegister();
    public static final Item BARN_OWL_WINGS = new ItemBuilder<Item>("barn_owl_wings")
            .setItemGroup(ItemGroups.COMBAT)
            .withSettings(
                    settings -> settings.maxCount(1)
                    .rarity(Rarity.RARE)
                    .component(
                            DataComponentTypes.GLIDER,
                            Unit.INSTANCE
                    )
                    .component(
                            DataComponentTypes.EQUIPPABLE,
                            EquippableComponent.builder(EquipmentSlot.CHEST)
                                    .equipSound(SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA)
                                    .model(ModItemReg.BARN_OWL_WINGS_KEY)
                                    .damageOnHurt(false)
                                    .build()
                    )
                    .repairable(BARN_OWL_FEATHER)
            )
            .buildAndRegister();

    //region REGISTRY ====================================================================================
    //endregion
    public static void registerModItems() {
        Albamc.LOGGER.info("Registering Mod Items for " + Albamc.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(BARN_OWL_FEATHER);
            entries.add(BARN_OWL_WINGS);
        });
    }
}