package sernoo.lust.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class LustStatusEffect extends StatusEffect {
    protected LustStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xD81B60);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
