package com.cadenkoehl.zombieapocalypse.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class TNTZombieEntity extends ZombieApocalypseEntity {

    private int shootTNTCooldown;

    public TNTZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
        this.shootTNTCooldown = 300;
    }

    @Override
    public void tick() {
        super.tick();
        shootTNTCooldown--;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        Entity attacker = source.getAttacker();
        if(attacker instanceof LivingEntity && source == DamageSource.explosion((LivingEntity) attacker)) {
            return false;
        }
        return super.damage(source, amount);
    }


    static class ShootTNTGoal extends Goal {

        private final TNTZombieEntity zombie;

        public ShootTNTGoal(TNTZombieEntity zombie) {
            this.zombie = zombie;
        }

        @Override
        public void start() {
            zombie.shootTNTCooldown = 300;
        }

        @Override
        public boolean canStart() {
            return zombie.getTarget() != null && zombie.shootTNTCooldown < 1;
        }
    }
}
