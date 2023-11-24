package sernoo.lust.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ChastityStatusEffect extends StatusEffect {
    protected ChastityStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xF48FB1);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
