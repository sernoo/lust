package sernoo.lust;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import sernoo.lust.block.LustBlocks;

public class LustClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(LustBlocks.SAFFRON, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(LustBlocks.POTTED_SAFFRON, RenderLayer.getCutout());
	}
}