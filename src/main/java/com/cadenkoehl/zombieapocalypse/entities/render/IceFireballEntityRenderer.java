package com.cadenkoehl.zombieapocalypse.entities.render;

import com.cadenkoehl.zombieapocalypse.ZombieApocalypse;
import net.minecraft.client.render.entity.DragonFireballEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.util.Identifier;

public class IceFireballEntityRenderer extends DragonFireballEntityRenderer {

    public static final Identifier TEXTURE = new Identifier(ZombieApocalypse.MOD_ID, "textures/entity/ice_fireball.png");

    public IceFireballEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public Identifier getTexture(DragonFireballEntity dragonFireballEntity) {
        return TEXTURE;
    }
}
