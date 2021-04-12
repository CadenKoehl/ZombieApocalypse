package com.cadenkoehl.zombieapocalypse.entities;

import com.cadenkoehl.zombieapocalypse.entities.effect.ModStatusEffects;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IceZombieEntity extends ZombieApocalypseEntity {

    public IceZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean attack = super.tryAttack(target);
        if(attack) {
            if(target instanceof LivingEntity) {
                LivingEntity entity = (LivingEntity) target;
                entity.addStatusEffect(new StatusEffectInstance(ModStatusEffects.FROST, 100));
            }
        }
        return attack;
    }

    @Override
    public void tick() {
        super.tick();
        LivingEntity target = this.getTarget();
        if (target == null) {
            return;
        }
        if(target.hasStatusEffect(ModStatusEffects.FROST)) {
            BlockPos pos = target.getBlockPos();
            world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
            world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
        }
    }

    @Override
    protected boolean canConvertInWater() {
        return false;
    }
}
