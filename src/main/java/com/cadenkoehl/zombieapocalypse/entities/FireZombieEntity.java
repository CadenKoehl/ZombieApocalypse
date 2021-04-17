package com.cadenkoehl.zombieapocalypse.entities;

import com.cadenkoehl.zombieapocalypse.entities.goals.ZombieShootFireballGoal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class FireZombieEntity extends ZombieApocalypseEntity {

    public FireZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new ZombieShootFireballGoal(this));
    }

    @Override
    protected boolean burnsInDaylight() {
        return false;
    }

    @Override
    protected boolean canConvertInWater() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.isSubmergedInWater()) {
            this.damage(DamageSource.DROWN, 20);
        }
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean attack = super.tryAttack(target);
        if(attack) {
            target.setOnFireFor(10);
        }
        return attack;
    }
}