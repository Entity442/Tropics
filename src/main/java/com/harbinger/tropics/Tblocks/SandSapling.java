package com.harbinger.tropics.Tblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class SandSapling extends SaplingBlock {
    public SandSapling(AbstractTreeGrower grower, Properties properties) {
        super(grower, properties);
    }


    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(BlockTags.SAND);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return level.getBlockState(blockpos).canSustainPlant(level, blockpos, Direction.UP, this);
        return this.mayPlaceOn(level.getBlockState(blockpos), level, blockpos);
    }
}
