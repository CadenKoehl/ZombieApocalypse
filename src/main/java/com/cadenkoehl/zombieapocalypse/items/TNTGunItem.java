package com.cadenkoehl.zombieapocalypse.items;

import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TNTGunItem extends ZombieDropItem {

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        HitResult raycast = user.raycast(100.0D, 0.0F, true);

        Vec3d pos = raycast.getPos();

        TntEntity tnt = new TntEntity(world, pos.x, pos.y, pos.z, user);
        tnt.setFuse(20);
        world.spawnEntity(tnt);
        user.playSound(SoundEvents.BLOCK_END_PORTAL_FRAME_FILL, 5.0F, 0.4F);
        return super.use(world, user, hand);
    }
}
