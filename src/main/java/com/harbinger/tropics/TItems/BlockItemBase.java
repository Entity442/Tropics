package com.harbinger.tropics.TItems;

import com.harbinger.tropics.Core.TItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block, Properties properties) {
        super(block, properties);
        TItems.TROPICAL_ITEMS.add(this);
    }
}
