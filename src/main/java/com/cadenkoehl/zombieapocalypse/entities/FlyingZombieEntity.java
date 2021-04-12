package com.cadenkoehl.zombieapocalypse.entities;

import net.fabricmc.fabric.mixin.biome.modification.BiomeWeatherAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public abstract class FlyingZombieEntity extends ZombieApocalypseEntity {

    private int flyCooldown;

    public FlyingZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
        this.flyCooldown = 300;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        targetSelector.add(3, new FlyGoal(this));
    }

    public void attackTargetWithLightning() {
        LivingEntity target = this.getTarget();
        if (target == null) return;

        World world = target.getEntityWorld();
        LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        lightning.setPos(target.getX(), target.getY(), target.getZ());
        world.spawnEntity(lightning);
        Vec3d vel = target.getVelocity();
        target.setVelocity(vel.x, vel.y + 2, vel.z);
    }

    public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
        return false;
    }

    public void startFlying() {
        this.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 3 * 20, 2));
    }

    @Override
    public void tick() {
        super.tick();
        flyCooldown--;
    }

    public boolean isClimbing() {
        return false;
    }

    static class FlyGoal extends Goal {

        private final FlyingZombieEntity zombie;

        public FlyGoal(FlyingZombieEntity zombie) {
            this.zombie = zombie;
        }

        @Override
        public void start() {
            zombie.flyCooldown = 300;
            zombie.startFlying();
            zombie.attackTargetWithLightning();
            for (ServerWorld world : zombie.getServer().getWorlds()) {
                if(world.getDimension().hasCeiling()) continue;
                world.setWeather(0, 1000, true, false);
            }
        }

        @Override
        public void stop() {

        }

        @Override
        public boolean canStart() {
            return !zombie.hasStatusEffect(StatusEffects.LEVITATION) && zombie.flyCooldown < 1;
        }
    }
}
