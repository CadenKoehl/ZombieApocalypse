package com.cadenkoehl.zombieapocalypse.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class ZombieApocalypseEntity extends ZombieEntity {

    public ZombieApocalypseEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public EntityDimensions getDimensions(EntityPose pose) {
        return this.isBaby() ? EntityDimensions.fixed(1.0f, 1.0f) : EntityDimensions.fixed(1.0f, 2.0f);
    }

    @Override
    public void onKilledOther(ServerWorld serverWorld, LivingEntity livingEntity) {
        super.onKilledOther(serverWorld, livingEntity);
        ZombieEntity zombie = new ZombieEntity(EntityType.ZOMBIE, this.world);
        ItemStack item = new ItemStack(Items.PLAYER_HEAD);
        CompoundTag skullOwner = new CompoundTag();
        skullOwner.putUuid("SkullOwner", livingEntity.getUuid());
        item.setTag(skullOwner);
        zombie.equip(5, item);
        zombie.setPos(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
        this.world.spawnEntity(zombie);
    }

    @Override
    protected boolean burnsInDaylight() {
        return false;
    }
}
