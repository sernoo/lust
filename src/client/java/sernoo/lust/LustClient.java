package sernoo.lust;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import sernoo.lust.block.LustBlocks;
import sernoo.lust.fluid.LustFluids;
import sernoo.lust.item.LustBucketItem;

public class LustClient implements ClientModInitializer {
	private static void registerClientFluid(FlowableFluid still, FlowableFluid flowing, String name) {
		FluidRenderHandlerRegistry.INSTANCE.register(still, flowing, new SimpleFluidRenderHandler(
				new Identifier(Lust.MOD_ID, String.format("block/%s_still", name)),
				new Identifier(Lust.MOD_ID, String.format("block/%s_flow", name))
		));

		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), still, flowing);
	}

	private static void registerClientFluids() {
		Lust.LOGGER.info("Registering client fluids for " + Lust.MOD_ID);

		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((LustBucketItem) stack.getItem()).getColor(tintIndex),
				LustFluids.CUM_BUCKET, LustFluids.PEE_BUCKET);

		registerClientFluid(LustFluids.STILL_CUM, LustFluids.FLOWING_CUM, "cum");
		registerClientFluid(LustFluids.STILL_PEE, LustFluids.FLOWING_PEE, "pee");
	}

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(LustBlocks.SAFFRON, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(LustBlocks.POTTED_SAFFRON, RenderLayer.getCutout());

		registerClientFluids();
	}
}