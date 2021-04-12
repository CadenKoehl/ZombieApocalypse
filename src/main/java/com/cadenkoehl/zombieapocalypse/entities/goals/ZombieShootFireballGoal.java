package com.cadenkoehl.zombieapocalypse.entities.goals;

import com.cadenkoehl.zombieapocalypse.entities.IceFireballEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class ZombieShootFireballGoal extends Goal {

    private final ZombieEntity zombie;
    private FireballEntity fireball;
    private final String fireballType;
    private int cooldown;

    public ZombieShootFireballGoal(ZombieEntity zombie, String fireballType) {
        this.zombie = zombie;
        this.fireballType = fireballType;
        this.cooldown = 0;
    }

    @Override
    public boolean canStart() {
        return zombie.getTarget() != null;
    }

    @Override
    public void tick() {
        if(this.canShoot()) {
            LivingEntity target = zombie.getTarget();
            if (target == null) {
                return;
            }
            World world = target.getEntityWorld();

            Vec3d vec3d = this.zombie.getRotationVec(1.0F);

            double x = target.getX() - (this.zombie.getX() + vec3d.x * 4.0D);
            double y = target.getBodyY(0.5D) - (0.5D + this.zombie.getBodyY(0.5D));
            double z = target.getZ() - (this.zombie.getZ() + vec3d.z * 4.0D);

            if(fireballType.equals("fire")) {
                fireball = new FireballEntity(world, zombie, x, y, z);
            }
            if(fireballType.equals("ice")) {
                fireball = IceFireballEntity.create(world, zombie, x, y, z);
            }

            fireball.explosionPower = 1;
            fireball.updatePosition(this.zombie.getX() + vec3d.x * 4.0D, this.zombie.getBodyY(0.5D) + 0.5D, fireball.getZ() + vec3d.z * 4.0D);
            world.spawnEntity(fireball);
        }
    }

    private boolean canShoot() {
        if(cooldown < 1) {
            cooldown = 100;
            return true;
        }
        cooldown--;
        return false;
    }
}
