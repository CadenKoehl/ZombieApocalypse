package com.cadenkoehl.zombieapocalypse.enchantment;

import com.cadenkoehl.zombieapocalypse.ZombieApocalypse;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {

    public static final Enchantment WINTER_ASPECT = new WinterAspectEnchantment();

    public static void registerEnchants() {
        Registry.register(Registry.ENCHANTMENT, new Identifier(ZombieApocalypse.MOD_ID, "winter_aspect"), WINTER_ASPECT);
    }
}
