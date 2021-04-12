package com.cadenkoehl.zombieapocalypse.entities.render;

import com.cadenkoehl.zombieapocalypse.ZombieApocalypse;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

public class IceZombieEntityRenderer extends ZombieEntityRenderer {

    public static final Identifier TEXTURE = new Identifier(ZombieApocalypse.MOD_ID, "textures/entity/ice_zombie.png");

    public IceZombieEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher);
    }

    @Override
    public Identifier getTexture(ZombieEntity zombieEntity) {
        return TEXTURE;
    }
}
