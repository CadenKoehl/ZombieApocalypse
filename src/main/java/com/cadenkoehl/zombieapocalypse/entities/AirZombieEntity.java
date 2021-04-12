package com.cadenkoehl.zombieapocalypse.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class AirZombieEntity extends FlyingZombieEntity {

    public AirZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean attack = super.tryAttack(target);
        if(attack) {
            if(target instanceof LivingEntity) {
                LivingEntity entity = (LivingEntity) target;
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 10 * 20, 5));
            }
        }
        return attack;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        boolean damage = super.damage(source, amount);
        if(damage) {
            Entity entity = source.getAttacker();
            if(entity == null) return true;

            if(entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 2 * 20, 5));
            }
        }
        return damage;
    }
}