package com.cadenkoehl.zombieapocalypse.entities;

import com.cadenkoehl.zombieapocalypse.ZombieApocalypse;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {

    public static final EntityType<FireZombieEntity> FIRE_ZOMBIE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ZombieApocalypse.MOD_ID, "fire_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireZombieEntity::new).dimensions(EntityDimensions.fixed(1.0f, 2.0f)).build());

    public static final EntityType<IceZombieEntity> ICE_ZOMBIE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ZombieApocalypse.MOD_ID, "ice_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, IceZombieEntity::new).dimensions(EntityDimensions.fixed(1.0f, 2.0f)).build());

    public static final EntityType<AirZombieEntity> AIR_ZOMBIE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ZombieApocalypse.MOD_ID, "air_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AirZombieEntity::new).dimensions(EntityDimensions.fixed(1.0f, 2.0f)).build());

    public static final EntityType<TNTZombieEntity> TNT_ZOMBIE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ZombieApocalypse.MOD_ID, "tnt_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, TNTZombieEntity::new).dimensions(EntityDimensions.fixed(1.0f, 2.0f)).build());

    public static final EntityType<IceFireballEntity> ICE_FIREBALL = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(ZombieApocalypse.MOD_ID, "ice_fireball"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, IceFireballEntity::new).build());

    public static void registerEntities() {

        //Entity registry
        FabricDefaultAttributeRegistry.register(FIRE_ZOMBIE, ZombieEntity.createZombieAttributes());
        FabricDefaultAttributeRegistry.register(ICE_ZOMBIE, ZombieEntity.createZombieAttributes());
        FabricDefaultAttributeRegistry.register(AIR_ZOMBIE, ZombieEntity.createZombieAttributes());
        FabricDefaultAttributeRegistry.register(TNT_ZOMBIE, ZombieEntity.createZombieAttributes());

        //Overworld spawns
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER, FIRE_ZOMBIE, 10, 1, 5);
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER, ICE_ZOMBIE, 10, 1, 5);
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER, AIR_ZOMBIE, 10, 1, 5);
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER, TNT_ZOMBIE, 10, 1, 5);

        //Nether spawns
        BiomeModifications.addSpawn(BiomeSelectors.foundInTheNether(), SpawnGroup.MONSTER, FIRE_ZOMBIE, 10, 1, 5);
    }
}
