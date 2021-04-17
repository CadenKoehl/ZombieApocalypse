package com.cadenkoehl.zombieapocalypse.items;

import com.cadenkoehl.zombieapocalypse.ZombieApocalypse;
import com.cadenkoehl.zombieapocalypse.entities.ModEntities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item LIGHTNING_ROD = new LightningRodItem();
    public static final Item INFERNO_ROD = new InfernoRodItem();
    public static final Item EARTH_STAFF = new EarthStaffItem();
    public static final Item TNT_GUN = new TNTGunItem();

    public static final Item FIRE_ZOMBIE_SPAWN_EGG = new SpawnEggItem(ModEntities.FIRE_ZOMBIE, 0xFF8C00, 0x4C2B14, new Item.Settings().group(ItemGroup.MISC));
    public static final Item ICE_ZOMBIE_SPAWN_EGG = new SpawnEggItem(ModEntities.ICE_ZOMBIE, 0x00EAFF, 0x1D4B7D, new Item.Settings().group(ItemGroup.MISC));
    public static final Item LIGHTNING_ZOMBIE_SPAWN_EGG = new SpawnEggItem(ModEntities.AIR_ZOMBIE, 0x6F6FDE, 0xC4EDFF, new Item.Settings().group(ItemGroup.MISC));
    public static final Item TNT_ZOMBIE_SPAWN_EGG = new SpawnEggItem(ModEntities.TNT_ZOMBIE, 0xFF0000, 0x000000, new Item.Settings().group(ItemGroup.MISC));
    public static final Item EARTH_ZOMBIE_SPAWN_EGG = new SpawnEggItem(ModEntities.EARTH_ZOMBIE, 0x069906, 0x83532E00, new Item.Settings().group(ItemGroup.MISC));

    public static void registerItems() {

        //Items
        register(LIGHTNING_ROD, "lightning_rod");
        register(INFERNO_ROD, "inferno_rod");
        register(EARTH_STAFF, "earth_staff");
        register(TNT_GUN, "tnt_gun");

        //Spawn Eggs
        register(FIRE_ZOMBIE_SPAWN_EGG, "fire_zombie_spawn_egg");
        register(ICE_ZOMBIE_SPAWN_EGG, "ice_zombie_spawn_egg");
        register(LIGHTNING_ZOMBIE_SPAWN_EGG, "lightning_zombie_spawn_egg");
        register(TNT_ZOMBIE_SPAWN_EGG, "tnt_zombie_spawn_egg");
        register(EARTH_ZOMBIE_SPAWN_EGG, "earth_zombie_spawn_egg");
    }

    private static void register(Item item, String id) {
        Registry.register(Registry.ITEM, new Identifier(ZombieApocalypse.MOD_ID, id), item);
    }
}
