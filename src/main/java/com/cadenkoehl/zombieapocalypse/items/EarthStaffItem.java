package com.cadenkoehl.zombieapocalypse.items;

import com.cadenkoehl.zombieapocalypse.effect.ModStatusEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EarthStaffItem extends ZombieDropItem {

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        float cooldownProgress = user.getItemCooldownManager().getCooldownProgress(this, MinecraftClient.getInstance().getTickDelta());

        if(cooldownProgress == 0) {
            user.getItemCooldownManager().set(this, 100);
            entity.applyStatusEffect(new StatusEffectInstance(ModStatusEffects.EARTH_SUFFOCATION, 60));
        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}
