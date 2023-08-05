package com.harbinger.tropics.FoliagePlacer;

import com.harbinger.tropics.Core.TfoliageGenerator;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class FancyJungleFoliagePlacer extends FoliagePlacer {
    public static final Codec<FancyJungleFoliagePlacer> CODEC = RecordCodecBuilder.create((placer) -> foliagePlacerParts(placer).apply(placer, FancyJungleFoliagePlacer::new));

    public FancyJungleFoliagePlacer(IntProvider pRadius, IntProvider pOffset) {
        super(pRadius, pOffset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return TfoliageGenerator.FANCY_JUNGLE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        BlockPos startingPos = pAttachment.pos();
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, startingPos ,0,0, pAttachment.doubleTrunk());
        createQuadrant(Direction.NORTH, startingPos, pLevel, pBlockSetter, pRandom, pConfig,pAttachment);
        createQuadrant(Direction.EAST, startingPos, pLevel, pBlockSetter, pRandom, pConfig,pAttachment);
        createQuadrant(Direction.SOUTH, startingPos, pLevel, pBlockSetter, pRandom, pConfig,pAttachment);
        createQuadrant(Direction.WEST, startingPos, pLevel, pBlockSetter, pRandom, pConfig,pAttachment);

        createSecondQuadrant(Direction.NORTH, startingPos, pLevel, pBlockSetter, pRandom, pConfig,pAttachment);
        createSecondQuadrant(Direction.EAST, startingPos, pLevel, pBlockSetter, pRandom, pConfig,pAttachment);
        createSecondQuadrant(Direction.SOUTH, startingPos, pLevel, pBlockSetter, pRandom, pConfig,pAttachment);
        createSecondQuadrant(Direction.WEST, startingPos, pLevel, pBlockSetter, pRandom, pConfig,pAttachment);
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }

    private void createQuadrant(Direction direction, BlockPos startingPos, LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,FoliageAttachment pAttachment) {
        BlockPos.MutableBlockPos pos = startingPos.mutable();

        pos.move(direction);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pos,0,0, pAttachment.doubleTrunk());

        for (int i = 0; i < 3; i++) {
            pos.move(direction);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pos,0,0, pAttachment.doubleTrunk());
            pos.move(Direction.DOWN);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pos,0,0, pAttachment.doubleTrunk());
        }

        pos.set(startingPos);
        pos.move(direction).move(direction.getCounterClockWise());
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pos,0,0, pAttachment.doubleTrunk());
        pos.move(Direction.DOWN).move(direction.getCounterClockWise());
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pos,0,0, pAttachment.doubleTrunk());
        pos.move(direction);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pos,0,0, pAttachment.doubleTrunk());


    }

    private void createSecondQuadrant(Direction direction, BlockPos startingPos, LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,FoliageAttachment pAttachment) {
        BlockPos.MutableBlockPos pos = startingPos.mutable();

        pos.move(direction);
        placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pos,0,0, pAttachment.doubleTrunk());

        for (int i = 0; i < 3; i++) {
            pos.move(direction);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pos,0,0, pAttachment.doubleTrunk());
            pos.move(Direction.UP);
            placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pos,0,0, pAttachment.doubleTrunk());
        }

    }

}