package com.harbinger.tropics.TItems;

import com.harbinger.tropics.Core.TItems;
import net.minecraft.world.item.Item;

public class ItemBase extends Item {
    public ItemBase(Properties properties) {
        super(properties);
        TItems.TROPICAL_ITEMS.add(this);
    }
}
