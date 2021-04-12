package com.cadenkoehl.zombieapocalypse.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class TNTZombieEntity extends ZombieApocalypseEntity {

    private int shootTNTCooldown;

    public TNTZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
        this.shootTNTCooldown = 100;
    }


    @Override
    protected void initGoals() {
        super.initGoals();
        goalSelector.add(1, new ShootTNTGoal(this));
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

    public void shootTNT() {

        LivingEntity target = this.getTarget();
        if (target == null) {
            return;
        }

        World world = target.getEntityWorld();

        Vec3d vec3d = this.getRotationVec(1.0F);

        double x = target.getX() - (this.getX() + vec3d.x * 4.0D);
        double y = target.getBodyY(0.5D) - (0.5D + this.getBodyY(0.5D));
        double z = target.getZ() - (this.getZ() + vec3d.z * 4.0D);

        TntEntity tnt = new TntEntity(world, this.getX(), this.getY(), this.getZ(), this) {
            @Override
            public void onPlayerCollision(PlayerEntity player) {
                super.onPlayerCollision(player);
                this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 4.0F, Explosion.DestructionType.BREAK);
            }
        };

        tnt.setFuse(20);
        tnt.setVelocity(x, y, z);
        world.spawnEntity(tnt);
    }


    static class ShootTNTGoal extends Goal {

        private final TNTZombieEntity zombie;

        public ShootTNTGoal(TNTZombieEntity zombie) {
            this.zombie = zombie;
        }

        @Override
        public void start() {
            zombie.shootTNTCooldown = 100;
            zombie.shootTNT();
        }

        @Override
        public boolean canStart() {
            return zombie.getTarget() != null && zombie.shootTNTCooldown < 1;
        }
    }
}
