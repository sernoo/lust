package sernoo.lust.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sernoo.lust.Lust;
import sernoo.lust.block.LustBlocks;

public class LustPotions {
    public static final Potion APHRODISIAC_POTION = registerPotion("aphrodisiac",
            new Potion(new StatusEffectInstance(StatusEffects.SPEED, 3600, 0)));
    public static final Potion LONG_APHRODISIAC_POTION = registerPotion("long_aphrodisiac",
            new Potion("aphrodisiac", new StatusEffectInstance(StatusEffects.SPEED, 9600, 0)));
    public static final Potion STRONG_APHRODISIAC_POTION = registerPotion("strong_aphrodisiac",
            new Potion("aphrodisiac", new StatusEffectInstance(StatusEffects.SPEED, 1800, 1)));
    public static final Potion ANTAPHRODISIAC_POTION = registerPotion("antaphrodisiac",
            new Potion(new StatusEffectInstance(StatusEffects.SLOWNESS, 3600, 0)));
    public static final Potion LONG_ANTAPHRODISIAC_POTION = registerPotion("long_antaphrodisiac",
            new Potion("antaphrodisiac", new StatusEffectInstance(StatusEffects.SLOWNESS, 9600, 0)));
    public static final Potion STRONG_ANTAPHRODISIAC_POTION = registerPotion("strong_antaphrodisiac",
            new Potion("antaphrodisiac", new StatusEffectInstance(StatusEffects.SLOWNESS, 1800, 1)));

    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(Lust.MOD_ID, name), potion);
    }

    private static void registerPotionRecipe(Potion base, Item ingredient, Potion output) {
        BrewingRecipeRegistry.registerPotionRecipe(base, ingredient, output);
    }

    public static void register() {
        Lust.LOGGER.info("Registering potions for " + Lust.MOD_ID);

        registerPotionRecipe(Potions.WATER, LustBlocks.SAFFRON.asItem(), APHRODISIAC_POTION);
        registerPotionRecipe(ANTAPHRODISIAC_POTION, Items.FERMENTED_SPIDER_EYE, APHRODISIAC_POTION);
        registerPotionRecipe(APHRODISIAC_POTION, Items.REDSTONE, LONG_APHRODISIAC_POTION);
        registerPotionRecipe(APHRODISIAC_POTION, Items.GLOWSTONE_DUST, STRONG_APHRODISIAC_POTION);

        registerPotionRecipe(APHRODISIAC_POTION, Items.FERMENTED_SPIDER_EYE, ANTAPHRODISIAC_POTION);
        registerPotionRecipe(ANTAPHRODISIAC_POTION, Items.REDSTONE, LONG_ANTAPHRODISIAC_POTION);
        registerPotionRecipe(ANTAPHRODISIAC_POTION, Items.GLOWSTONE_DUST, STRONG_ANTAPHRODISIAC_POTION);
    }
}
