package com.harbinger.tropics.Core;

import com.harbinger.tropics.FoliagePlacer.FancyJungleFoliagePlacer;
import com.harbinger.tropics.FoliagePlacer.PalmFoliagePlacer;
import com.harbinger.tropics.Tropics;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TfoliageGenerator <P extends FoliagePlacer> {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, Tropics.MODID);
    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }

    public static final RegistryObject<FoliagePlacerType<?>> PALM_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("palm_foliage_placer", () -> new FoliagePlacerType<>(PalmFoliagePlacer.CODEC));


    public static final RegistryObject<FoliagePlacerType<?>> FANCY_JUNGLE_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("fancy_jungle_foliage_placer", () -> new FoliagePlacerType<>(FancyJungleFoliagePlacer.CODEC));
}
