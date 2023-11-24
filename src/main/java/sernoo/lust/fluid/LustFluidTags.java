package sernoo.lust.fluid;

import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public final class LustFluidTags {
    public static final TagKey<Fluid> CUM = TagKey.of(RegistryKeys.FLUID, LustFluids.STILL_CUM_ID);
    public static final TagKey<Fluid> PEE = TagKey.of(RegistryKeys.FLUID, LustFluids.STILL_PEE_ID);
}
