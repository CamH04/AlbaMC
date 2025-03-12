package net.alba.albamod.albamc.item;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;

public interface ModReg extends EquipmentAssetKeys {
    RegistryKey<EquipmentAsset> BARN_OWL_WINGS = EquipmentAssetKeys.register("barn_owl_wings");
}
