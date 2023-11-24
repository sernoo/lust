package sernoo.lust.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import sernoo.lust.block.LustBlocks;

public abstract class CumFluid extends BaseFluid {
    @Override
    public Fluid getStill() {
        return LustFluids.STILL_CUM;
    }

    @Override
    public Fluid getFlowing() {
        return LustFluids.FLOWING_CUM;
    }

    @Override
    public Item getBucketItem() {
        return LustFluids.CUM_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return LustBlocks.CUM.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    public static class Flowing extends CumFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends CumFluid {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}
