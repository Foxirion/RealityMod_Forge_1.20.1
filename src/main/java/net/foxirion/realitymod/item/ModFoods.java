package net.foxirion.realitymod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties COCONUT_MILK = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3F)
            .build();
}
