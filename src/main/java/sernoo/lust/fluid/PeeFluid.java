package sernoo.lust.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import sernoo.lust.block.LustBlocks;

public abstract class PeeFluid extends BaseFluid {
    @Override
    public Fluid getStill() {
        return LustFluids.STILL_PEE;
    }

    @Override
    public Fluid getFlowing() {
        return LustFluids.FLOWING_PEE;
    }

    @Override
    public Item getBucketItem() {
        return LustFluids.PEE_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return LustBlocks.PEE.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    public static class Flowing extends PeeFluid {
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

    public static class Still extends PeeFluid {
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
