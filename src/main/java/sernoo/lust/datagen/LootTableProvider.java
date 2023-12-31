package sernoo.lust.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import sernoo.lust.Lust;
import sernoo.lust.block.LustBlocks;

public class LootTableProvider extends FabricBlockLootTableProvider {
    public LootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(LustBlocks.SAFFRON);
        addDrop(LustBlocks.GINSENG);
        addPottedPlantDrops(LustBlocks.POTTED_SAFFRON);
        addPottedPlantDrops(LustBlocks.POTTED_GINSENG);
    }
}
