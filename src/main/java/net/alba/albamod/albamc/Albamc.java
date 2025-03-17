package net.alba.albamod.albamc;
import net.alba.albamod.albamc.entity.ModEntitys;
import net.alba.albamod.albamc.item.ModItems;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ModInitializer;

public class Albamc implements ModInitializer {
    public static final String MOD_ID = "albamc";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Identifier identifier(String path) {
        return Identifier.of(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModEntitys.registerModEntitys();
    }


}
