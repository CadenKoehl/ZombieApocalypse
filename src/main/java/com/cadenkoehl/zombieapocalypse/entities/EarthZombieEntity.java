package com.cadenkoehl.zombieapocalypse.entities;

import com.cadenkoehl.zombieapocalypse.effect.ModStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class EarthZombieEntity extends ZombieApocalypseEntity {

    private int suffocateAttackCooldown;

    public EarthZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        suffocateAttackCooldown--;
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean attack = super.tryAttack(target);
        if(attack) {
            if(target instanceof LivingEntity) {
                LivingEntity entity = (LivingEntity) target;
                if(suffocateAttackCooldown < 0) {
                    entity.applyStatusEffect(new StatusEffectInstance(ModStatusEffects.EARTH_SUFFOCATION, 60));
                    suffocateAttackCooldown = 300;
                }
            }
        }
        return attack;
    }
}