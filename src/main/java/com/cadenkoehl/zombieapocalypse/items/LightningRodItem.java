package com.cadenkoehl.zombieapocalypse.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class LightningRodItem extends ZombieDropItem {

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        HitResult raycast = user.raycast(30.0D, 0.0F, true);

        Vec3d pos = raycast.getPos();
        LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        lightning.setPos(pos.x, pos.y, pos.z);
        world.spawnEntity(lightning);

        world.createExplosion(
                user,
                DamageSource.MAGIC,
                null,
                pos.getX(),
                pos.getY(),
                pos.getZ(),
                2.0f,
                true,
                Explosion.DestructionType.DESTROY
        );
        return super.use(world, user, hand);
    }
}
