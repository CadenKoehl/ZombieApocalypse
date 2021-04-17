package com.cadenkoehl.zombieapocalypse.mixins;

import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BedBlock.class)
public abstract class BedBlockMixin {
    @Inject(at = @At("HEAD"), method = "onUse")
    public void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        if(world.isClient) return;

        world.createExplosion(
                null,
                DamageSource.badRespawnPoint(),
                null,
                (double)pos.getX() + 0.5D,
                (double)pos.getY() + 0.5D,
                (double)pos.getZ() + 0.5D,
                5.0f,
                true,
                Explosion.DestructionType.DESTROY
        );

        player.damage(DamageSource.badRespawnPoint(), 20);
    }
}
