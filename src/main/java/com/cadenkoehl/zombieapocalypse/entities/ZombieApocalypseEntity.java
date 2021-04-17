package com.cadenkoehl.zombieapocalypse.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class ZombieApocalypseEntity extends ZombieEntity {

    public ZombieApocalypseEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.getEntityWorld().isNight()) {
            this.kill();
        }
    }

    @Override
    public EntityDimensions getDimensions(EntityPose pose) {
        return this.isBaby() ? EntityDimensions.fixed(1.0f, 1.0f) : EntityDimensions.fixed(1.0f, 2.0f);
    }

    @Override
    protected boolean burnsInDaylight() {
        return false;
    }

    @Override
    protected boolean canConvertInWater() {
        return false;
    }
}
