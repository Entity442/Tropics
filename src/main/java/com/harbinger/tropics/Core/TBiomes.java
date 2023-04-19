package com.harbinger.tropics.Core;

import com.harbinger.tropics.Tropics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TBiomes {
    public static final ResourceKey<Biome> TROPICAL_PLANE = ResourceKey.create(Registries.BIOME,
            new ResourceLocation(Tropics.MODID, "tropical_plane"));

    public static void register() {
        System.out.println("Registering " + Tropics.MODID + " Biomes");
    }
}
