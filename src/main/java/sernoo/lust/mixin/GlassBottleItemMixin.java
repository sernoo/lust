package sernoo.lust.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.stat.Stats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sernoo.lust.fluid.LustFluids;
import sernoo.lust.potion.LustPotions;

@Mixin(GlassBottleItem.class)
abstract class GlassBottleItemMixin {
    @Unique
    private static Potion result;

    @Redirect(method = "use", at = @At(value = "INVOKE",
              target = "Lnet/minecraft/fluid/FluidState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
    private boolean saveAssociatedPotion(FluidState instance, TagKey<Fluid> tag) {
        if (instance.isIn(tag)) {
            result = Potions.WATER;
            Item bucket = instance.getFluid().getBucketItem();

            if (bucket == LustFluids.CUM_BUCKET) {
                result = LustPotions.CUM;
            } else if (bucket == LustFluids.PEE_BUCKET) {
                result = LustPotions.PEE;
            } else if (bucket == LustFluids.LUBE_BUCKET) {
                result = LustPotions.LUBE;
            }

            return true;
        }

        result = null;
        return false;
    }

    @Inject(method = "fill", at = @At("HEAD"), cancellable = true)
    protected void givePotion(ItemStack stack, PlayerEntity player, ItemStack outputStack, CallbackInfoReturnable<ItemStack> cir) {
        player.incrementStat(Stats.USED.getOrCreateStat(player.getMainHandStack().getItem()));

        ItemStack potionOutput = PotionUtil.setPotion(new ItemStack(Items.POTION), result);
        cir.setReturnValue(ItemUsage.exchangeStack(stack, player, potionOutput));
        cir.cancel();
    }
}