package com.cadenkoehl.zombieapocalypse.mixins;

import com.cadenkoehl.zombieapocalypse.event.events.PlayerTickEvent;
import com.cadenkoehl.zombieapocalypse.event.handler.EventListener;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerTickMixin {

    @Shadow @Final public PlayerInventory inventory;

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info) {
        for(EventListener listener : EventListener.getListeners()) {
            listener.onPlayerTick(new PlayerTickEvent(inventory.player, info));

        }
    }
}
