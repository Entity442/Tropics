package com.harbinger.tropics.Tblocks;

import com.harbinger.tropics.Core.TItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CoconutNutBlock extends FruitBlock{
    private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 8.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    private static final VoxelShape MID_GROWTH_SHAPE = Block.box(2.0D, 3.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public CoconutNutBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOD).strength(1f,1f).sound(SoundType.WOOD).randomTicks().noCollission());
    }

    @Override
    public void playHarvest(Level level, BlockPos pos) {
        level.playSound(null, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
    }



    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext collisionContext) {
        if (state.getValue(AGE) == 0) {
            return SAPLING_SHAPE;
        } else {
            return state.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(state, getter, pos, collisionContext);
        }
    }

    public ItemStack getCloneItemStack(BlockGetter p_57256_, BlockPos p_57257_, BlockState p_57258_) {
        return new ItemStack(TItems.COCONUT.get());
    }

    @Override
    public void getFruit(Level level, BlockPos pos) {
        popResource(level, pos, new ItemStack(TItems.COCONUT.get(), 1));
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos blockPos, Entity entity) {
        if(state.getValue(AGE) == MAX_AGE && entity instanceof Projectile){
            BlockState blockstate = state.setValue(AGE, 0);
            level.setBlock(blockPos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(null, blockstate));
            ItemEntity item = new ItemEntity(level,blockPos.getX(),blockPos.getY(),blockPos.getZ() , new ItemStack(TItems.COCONUT.get()));
            level.addFreshEntity(item);
        }
        super.entityInside(state, level, blockPos, entity);
    }
}
