package sernoo.lust.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;
import sernoo.lust.fluid.LustFluidTags;
import sernoo.lust.fluid.LustFluids;

import java.util.concurrent.CompletableFuture;

public class FluidTagProvider extends FabricTagProvider.FluidTagProvider {
    public FluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(LustFluidTags.CUM)
                .add(LustFluids.STILL_CUM_ID)
                .add(LustFluids.FLOWING_CUM_ID);
        getOrCreateTagBuilder(LustFluidTags.PEE)
                .add(LustFluids.STILL_PEE_ID)
                .add(LustFluids.FLOWING_PEE_ID);

        getTagBuilder(FluidTags.WATER)
                .addTag(LustFluidTags.CUM.id())
                .addTag(LustFluidTags.PEE.id());
    }
}
