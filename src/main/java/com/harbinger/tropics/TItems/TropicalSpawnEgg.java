package com.harbinger.tropics.TItems;

import com.harbinger.tropics.Core.TItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.common.ForgeSpawnEggItem;

import java.util.function.Supplier;

public class TropicalSpawnEgg extends ForgeSpawnEggItem {
    public TropicalSpawnEgg(Supplier<? extends EntityType<? extends Mob>> type, Properties props) {
        super(type, -1, -1, props);
        TItems.TROPICAL_ITEMS.add(this);
    }
}
