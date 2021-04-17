package com.cadenkoehl.zombieapocalypse.effect;

import com.cadenkoehl.zombieapocalypse.ZombieApocalypse;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModStatusEffects {

    public static final StatusEffect FROST = new FrostStatusEffect(StatusEffectType.HARMFUL, 0x00EAFF);
    public static final StatusEffect EARTH_SUFFOCATION = new EarthSuffocationStatusEffect(StatusEffectType.HARMFUL, 0x5E3800);

    public static void registerEffects() {
        Registry.register(Registry.STATUS_EFFECT, new Identifier(ZombieApocalypse.MOD_ID, "frost"), FROST);
        Registry.register(Registry.STATUS_EFFECT, new Identifier(ZombieApocalypse.MOD_ID, "earth_suffocation"), EARTH_SUFFOCATION);
    }
}
