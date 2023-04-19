package com.harbinger.tropics.Core;

import com.harbinger.tropics.Tropics;
import com.harbinger.tropics.TrunkPlacers.SlantedTrunkPlacer;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TtrunkGenerator<P extends TrunkPlacer> extends TrunkPlacerType<P> {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Tropics.MODID);

    public static final RegistryObject<TrunkPlacerType<SlantedTrunkPlacer>> SLANTED_TRUNK_PLACER =
            TRUNK_PLACERS.register("slanted_trunk_placer", () -> new TrunkPlacerType<>(SlantedTrunkPlacer.CODEC));

    public TtrunkGenerator(Codec<P> pCodec) {
        super(pCodec);
    }

    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
    }
}