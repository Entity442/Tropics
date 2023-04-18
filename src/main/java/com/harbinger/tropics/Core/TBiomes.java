package com.harbinger.tropics.Core;

import com.harbinger.tropics.Tropics;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TBiomes {
    public static final DeferredRegister<Biome> BIOME = DeferredRegister.create(ForgeRegistries.BIOMES, Tropics.MODID);
    public static void register(IEventBus eventBus) {
        BIOME.register(eventBus);
    }

}
