package sernoo.lust.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;
import sernoo.lust.fluid.LustFluids;

import java.util.concurrent.CompletableFuture;

public class FluidTagProvider extends FabricTagProvider.FluidTagProvider {
    public FluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getTagBuilder(FluidTags.WATER)
                .add(LustFluids.STILL_CUM_ID)
                .add(LustFluids.STILL_PEE_ID)
                .add(LustFluids.FLOWING_CUM_ID)
                .add(LustFluids.FLOWING_PEE_ID);
    }
}
