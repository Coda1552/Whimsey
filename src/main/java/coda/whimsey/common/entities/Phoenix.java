package coda.whimsey.common.entities;

import coda.whimsey.registry.WItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class Phoenix extends Parrot {

    public Phoenix(EntityType<? extends Parrot> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public ItemStack getPickedResult(HitResult target) {
        return new ItemStack(WItems.PHOENIX_SPAWN_EGG.get());
    }
}
