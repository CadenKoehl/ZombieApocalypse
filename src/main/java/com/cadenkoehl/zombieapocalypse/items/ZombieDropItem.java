package com.cadenkoehl.zombieapocalypse.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public abstract class ZombieDropItem extends Item {

    public ZombieDropItem() {
        this(new Settings());
    }

    public ZombieDropItem(Settings settings) {
        super(settings.maxCount(1).group(ItemGroup.COMBAT).rarity(Rarity.RARE));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.getItemCooldownManager().set(this, 100);
        return super.use(world, user, hand);
    }
}
