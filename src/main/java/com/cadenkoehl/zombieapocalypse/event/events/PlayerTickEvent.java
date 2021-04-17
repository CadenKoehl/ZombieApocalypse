package com.cadenkoehl.zombieapocalypse.event.events;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class PlayerTickEvent {

    private final PlayerEntity player;
    private final CallbackInfo callbackInfo;

    public PlayerTickEvent(PlayerEntity player, CallbackInfo callbackInfo) {
        this.player = player;
        this.callbackInfo = callbackInfo;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public CallbackInfo getCallbackInfo() {
        return callbackInfo;
    }
}
