package com.cadenkoehl.zombieapocalypse.enchantment;

import com.cadenkoehl.zombieapocalypse.effect.ModStatusEffects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class WinterAspectEnchantment extends Enchantment {

    protected WinterAspectEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(level == 0) return;

        if(target instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) target;
            entity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.FROST, level * 80));
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }
}
