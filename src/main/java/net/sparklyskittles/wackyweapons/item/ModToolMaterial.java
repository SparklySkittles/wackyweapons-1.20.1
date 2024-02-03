package net.sparklyskittles.wackyweapons.item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    SLIME(800, 0.0f, 1f, 4, 26, () -> Ingredient.ofItems(Items.SLIME_BALL));
    
    private final int durability;
    private final float miningSpeed;
    private final float damage;
    private final int miningLevel;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int durability, float miningSpeed, float damage, int miningLevel, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.damage = damage;
        this.miningLevel = miningLevel;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.damage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
