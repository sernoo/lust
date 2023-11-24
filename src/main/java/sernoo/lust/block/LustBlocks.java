package sernoo.lust.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sernoo.lust.Lust;
import sernoo.lust.effect.LustEffects;
import sernoo.lust.fluid.LustFluids;

public class LustBlocks {
    public static final Block SAFFRON = registerBlockWithItem("saffron",
            new FlowerBlock(LustEffects.LUST, 10,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_SAFFRON = registerBlock("potted_saffron",
            new FlowerPotBlock(SAFFRON, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    public static final Block CUM = registerFluidBlock(LustFluids.STILL_CUM_ID, LustFluids.STILL_CUM);
    public static final Block PEE = registerFluidBlock(LustFluids.STILL_PEE_ID, LustFluids.STILL_PEE);

    private static Block registerFluidBlock(Identifier id, FlowableFluid fluid) {
        return Registry.register(Registries.BLOCK, id, new FluidBlock(fluid, FabricBlockSettings.copy(Blocks.WATER)){});
    }

    private static Block registerBlockWithItem(String name, Block block) {
        registerBlockItem(name, block);
        return registerBlock(name, block);
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Lust.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Lust.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void register() {
        Lust.LOGGER.info("Registering blocks for " + Lust.MOD_ID);
    }
}
