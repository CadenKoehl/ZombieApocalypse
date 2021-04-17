package com.cadenkoehl.zombieapocalypse.entities;

import com.cadenkoehl.zombieapocalypse.effect.ModStatusEffects;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class IceZombieEntity extends ZombieApocalypseEntity {

    public IceZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean attack = super.tryAttack(target);
        if(attack) {
            if(target instanceof LivingEntity) {
                LivingEntity entity = (LivingEntity) target;
                entity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.FROST, 100));
            }
        }
        return attack;
    }
}
