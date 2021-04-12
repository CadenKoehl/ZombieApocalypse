package com.cadenkoehl.zombieapocalypse.items;

import com.cadenkoehl.zombieapocalypse.ZombieApocalypse;
import com.cadenkoehl.zombieapocalypse.entities.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item FIRE_ZOMBIE_SPAWN_EGG = new SpawnEggItem(ModEntities.FIRE_ZOMBIE, 0xFF8C00, 0x4C2B14, new Item.Settings().group(ItemGroup.MISC));
    public static final Item ICE_ZOMBIE_SPAWN_EGG = new SpawnEggItem(ModEntities.ICE_ZOMBIE, 0x00EAFF, 0x1D4B7D, new Item.Settings().group(ItemGroup.MISC));
    public static final Item AIR_ZOMBIE_SPAWN_EGG = new SpawnEggItem(ModEntities.AIR_ZOMBIE, 0x6F6FDE, 0xC4EDFF, new Item.Settings().group(ItemGroup.MISC));
    public static final Item TNT_ZOMBIE_SPAWN_EGG = new SpawnEggItem(ModEntities.TNT_ZOMBIE, 0xFF0000, 0x000000, new Item.Settings().group(ItemGroup.MISC));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(ZombieApocalypse.MOD_ID, "fire_zombie_spawn_egg"), FIRE_ZOMBIE_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(ZombieApocalypse.MOD_ID, "ice_zombie_spawn_egg"), ICE_ZOMBIE_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(ZombieApocalypse.MOD_ID, "air_zombie_spawn_egg"), AIR_ZOMBIE_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(ZombieApocalypse.MOD_ID, "tnt_zombie_spawn_egg"), TNT_ZOMBIE_SPAWN_EGG);
    }
}
