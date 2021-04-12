package com.cadenkoehl.zombieapocalypse.entities;

import com.cadenkoehl.zombieapocalypse.entities.effect.ModStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class IceFireballEntity extends FireballEntity {

    public IceFireballEntity(EntityType<? extends FireballEntity> entityType, World world) {
        super(entityType, world);
    }

    private IceFireballEntity(World world, LivingEntity owner, double velocityX, double velocityY, double velocityZ) {
        super(world, owner, velocityX, velocityY, velocityZ);
    }

    public static IceFireballEntity create(World world, LivingEntity owner, double velocityX, double velocityY, double velocityZ) {
        return new IceFireballEntity(world, owner, velocityX, velocityY, velocityZ);
    }

    @Override
    protected void onEntityHit(EntityHitResult result) {
        if(result.getEntity() instanceof ZombieEntity) return;
        super.onEntityHit(result);

        Entity entity = result.getEntity();

        if(entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            livingEntity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.FROST, 100));
        }
    }
}
