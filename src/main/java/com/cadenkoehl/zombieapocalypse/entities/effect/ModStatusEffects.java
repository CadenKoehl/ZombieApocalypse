package com.cadenkoehl.zombieapocalypse.entities.effect;

import com.cadenkoehl.zombieapocalypse.ZombieApocalypse;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModStatusEffects {

    public static final StatusEffect FROST = new StatusEffect(StatusEffectType.HARMFUL, 0x00EAFF){};

    public static void registerEffects() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(ZombieApocalypse.MOD_ID, "frost"), FROST);
    }
}
