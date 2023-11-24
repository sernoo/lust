package sernoo.lust.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import sernoo.lust.Lust;
import sernoo.lust.block.LustBlocks;

public class LustItemGroups {
    public static final ItemGroup LUST_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Lust.MOD_ID, "lust"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.lust"))
                    .icon(() -> new ItemStack(Items.END_ROD)).entries((displayContext, entries) -> {
                        entries.add(LustBlocks.SAFFRON);
                    }).build());

    public static void register() {
        Lust.LOGGER.info("Registering item groups for " + Lust.MOD_ID);
    }
}
