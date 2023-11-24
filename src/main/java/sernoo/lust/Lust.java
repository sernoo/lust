package sernoo.lust;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sernoo.lust.block.LustBlocks;
import sernoo.lust.effect.LustEffects;
import sernoo.lust.item.LustItemGroups;
import sernoo.lust.item.LustItems;
import sernoo.lust.potion.LustPotions;

public class Lust implements ModInitializer {
	public static final String MOD_ID = "lust";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LustEffects.register();
		LustItemGroups.register();
		LustItems.register();
		LustBlocks.register();
		LustPotions.register();
	}
}