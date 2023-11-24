package sernoo.lust.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sernoo.lust.Lust;
import sernoo.lust.item.LustBucketItem;

public class LustFluids {
    public static final Identifier STILL_CUM_ID = new Identifier(Lust.MOD_ID, "cum");
    public static final Identifier FLOWING_CUM_ID = new Identifier(Lust.MOD_ID, "flowing_cum");
    public static final Identifier STILL_PEE_ID = new Identifier(Lust.MOD_ID, "pee");
    public static final Identifier FLOWING_PEE_ID = new Identifier(Lust.MOD_ID, "flowing_pee");

    public static final FlowableFluid STILL_CUM = registerFluid(STILL_CUM_ID, new CumFluid.Still());
    public static final FlowableFluid FLOWING_CUM = registerFluid(FLOWING_CUM_ID, new CumFluid.Flowing());
    public static final Item CUM_BUCKET = registerBucket("cum_bucket", STILL_CUM, 0xFFFFFF);
    public static final FlowableFluid STILL_PEE = registerFluid(STILL_PEE_ID, new PeeFluid.Still());
    public static final FlowableFluid FLOWING_PEE = registerFluid(FLOWING_PEE_ID, new PeeFluid.Flowing());
    public static final Item PEE_BUCKET = registerBucket("pee_bucket", STILL_PEE, 0xFFFF00);

    private static FlowableFluid registerFluid(Identifier id, BaseFluid fluid) {
        return Registry.register(Registries.FLUID, id, fluid);
    }

    private static Item registerBucket(String name, FlowableFluid fluid, int tintColor) {
        return Registry.register(Registries.ITEM, new Identifier(Lust.MOD_ID, name),
                new LustBucketItem(fluid, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1), tintColor));
    }

    public static void register() {
        Lust.LOGGER.info("Registering items for " + Lust.MOD_ID);
    }
}
