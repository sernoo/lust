package sernoo.lust.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.passive.AnimalEntity;

public class ChastityStatusEffect extends StatusEffect {
    protected ChastityStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xF48FB1);
    }

    @Override
    public void onApplied(LivingEntity target, int amplifier) {
        target.removeStatusEffect(LustEffects.LUST);
        if (target instanceof AnimalEntity animal) {
            animal.resetLoveTicks();
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
