package sernoo.lust.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.util.Identifier;
import sernoo.lust.Lust;
import sernoo.lust.block.LustBlocks;
import sernoo.lust.fluid.LustFluids;

import java.util.Optional;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerFlowerPotPlant(LustBlocks.SAFFRON, LustBlocks.POTTED_SAFFRON, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(LustBlocks.GINSENG, LustBlocks.POTTED_GINSENG, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    public static Model item(String parent) {
        return new Model(Optional.of(new Identifier(Lust.MOD_ID, "item/" + parent)), Optional.empty());
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(LustFluids.CUM_BUCKET, item("template_bucket"));
        itemModelGenerator.register(LustFluids.PEE_BUCKET, item("template_bucket"));
        itemModelGenerator.register(LustFluids.LUBE_BUCKET, item("template_bucket"));
    }
}
