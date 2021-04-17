package com.cadenkoehl.zombieapocalypse;

import com.cadenkoehl.zombieapocalypse.enchantment.ModEnchantments;
import com.cadenkoehl.zombieapocalypse.effect.ModStatusEffects;
import com.cadenkoehl.zombieapocalypse.items.ModItems;
import com.cadenkoehl.zombieapocalypse.entities.ModEntities;
import net.fabricmc.api.ModInitializer;

public class ZombieApocalypse implements ModInitializer {

    public static final String MOD_ID = "zombies";

    @Override
    public void onInitialize() {
        ModEntities.registerEntities();
        ModStatusEffects.registerEffects();
        ModItems.registerItems();
        ModEnchantments.registerEnchants();
    }
}