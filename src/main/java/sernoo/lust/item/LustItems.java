package sernoo.lust.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sernoo.lust.Lust;

public class LustItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Lust.MOD_ID, name), item);
    }

    public static void register() {
        Lust.LOGGER.info("Registering items for " + Lust.MOD_ID);
    }
}
