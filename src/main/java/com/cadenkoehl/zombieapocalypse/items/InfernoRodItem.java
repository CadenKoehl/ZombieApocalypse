package com.cadenkoehl.zombieapocalypse.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class InfernoRodItem extends ZombieDropItem {

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        Vec3d vec3d = user.getRotationVec(1.0F);

        HitResult raycast = user.raycast(30.0D, 0.0F, true);

        Vec3d pos = raycast.getPos();

        double x = pos.x - (user.getX() + vec3d.x * 4.0D);
        double y = pos.y - (0.5D + pos.y);
        double z = pos.z - (user.getZ() + vec3d.z * 4.0D);

        FireballEntity fireball = new FireballEntity(world, user, x, y, z);

        fireball.explosionPower = 5;
        fireball.updatePosition(user.getX() + vec3d.x * 4.0D, user.getY(), fireball.getZ() + vec3d.z * 4.0D);
        world.spawnEntity(fireball);

        return super.use(world, user, hand);
    }
}