package com.cadenkoehl.zombieapocalypse.client;

import com.cadenkoehl.zombieapocalypse.entities.render.*;
import com.cadenkoehl.zombieapocalypse.entities.ModEntities;
import com.sun.org.apache.xpath.internal.operations.Mod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class ZombieApocalypseClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(ModEntities.FIRE_ZOMBIE, (dispatcher, context) -> new FireZombieEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(ModEntities.ICE_ZOMBIE, (dispatcher, context) -> new IceZombieEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(ModEntities.AIR_ZOMBIE, (dispatcher, context) -> new AirZombieEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(ModEntities.TNT_ZOMBIE, (dispatcher, context) -> new TNTZombieEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(ModEntities.ICE_FIREBALL, (dispatcher, context) -> new IceFireballEntityRenderer(dispatcher));
    }
}