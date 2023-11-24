package sernoo.lust.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sernoo.lust.Lust;

public class LustEffects {
    public static final StatusEffect CHASTITY = new ChastityStatusEffect();
    public static final StatusEffect LUST = new LustStatusEffect();

    private static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Lust.MOD_ID, name), effect);
    }

    public static void register() {
        Lust.LOGGER.info("Registering effects for " + Lust.MOD_ID);

        registerStatusEffect("chastity", CHASTITY);
        registerStatusEffect("lust", LUST);
    }
}
