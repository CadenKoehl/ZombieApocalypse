package com.cadenkoehl.zombieapocalypse.effect;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FrostStatusEffect extends StatusEffect {

    protected FrostStatusEffect(StatusEffectType type, int color) {
        super(type, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getEntityWorld();
        Vec3d pos = entity.getPos();

        world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
        world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.BLUE_ICE.getDefaultState());
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }
}
