package sernoo.lust.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class LustStatusEffect extends StatusEffect {
    protected LustStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xD81B60);
    }

    @Override
    public void onApplied(LivingEntity target, int amplifier) {
        target.removeStatusEffect(LustEffects.CHASTITY);
        if (target instanceof VillagerEntity villager) {
            SimpleInventory inventory = villager.getInventory();
            inventory.addStack(new ItemStack(Items.BREAD, 24));
            villager.eatForBreeding();
        }

        if (target instanceof AnimalEntity animal) {
            animal.lovePlayer(null);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
