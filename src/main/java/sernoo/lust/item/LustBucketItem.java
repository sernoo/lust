package sernoo.lust.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;

public class LustBucketItem extends BucketItem {
    private final int fluidColor;

    public LustBucketItem(Fluid fluid, FabricItemSettings settings, int fluidColor) {
        super(fluid, settings);
        this.fluidColor = fluidColor;
    }

    public int getColor(int tintIndex) {
        return tintIndex == 1 ? fluidColor: -1;
    }
}
