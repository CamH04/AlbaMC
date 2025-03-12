package net.alba.albamod.albamc.item;

import net.alba.albamod.albamc.Albamc;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public interface ModReg extends EquipmentAssetKeys {
    RegistryKey<EquipmentAsset> BARN_OWL_WINGS_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Albamc.MOD_ID, "barn_owl_wings"));
}
