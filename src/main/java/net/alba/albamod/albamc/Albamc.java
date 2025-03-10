package net.alba.albamod.albamc;
import net.alba.albamod.albamc.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ModInitializer;

public class Albamc implements ModInitializer {
    public static final String MOD_ID = "albamc";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        ModItems.registerModItems();
    }
}
