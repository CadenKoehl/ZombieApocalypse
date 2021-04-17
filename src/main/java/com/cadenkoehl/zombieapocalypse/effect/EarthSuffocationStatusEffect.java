package com.cadenkoehl.zombieapocalypse.effect;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class EarthSuffocationStatusEffect extends StatusEffect {

    protected EarthSuffocationStatusEffect(StatusEffectType type, int color) {
        super(type, color);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);
        entity.setVelocity(entity.getVelocity().x, 3, entity.getVelocity().y);
        entity.playSound(SoundEvents.ENTITY_EVOKER_FANGS_ATTACK, 5.0f, 1.0f);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration > 0;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getEntityWorld();
        BlockPos pos = entity.getBlockPos();

        entity.playSound(SoundEvents.BLOCK_GRASS_PLACE, 1.0f, 1.0f);
        world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), Blocks.DIRT.getDefaultState());
        world.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.DIRT.getDefaultState());
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        World world = entity.getEntityWorld();
        Vec3d pos = entity.getPos();

        world.createExplosion(
                null,
                DamageSource.MAGIC,
                null,
                pos.getX(),
                pos.getY(),
                pos.getZ(),
                1.0f,
                true,
                Explosion.DestructionType.BREAK
        );
    }
}
