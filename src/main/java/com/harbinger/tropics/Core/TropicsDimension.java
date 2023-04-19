package com.harbinger.tropics.Core;

import com.harbinger.tropics.Tropics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class TropicsDimension {
    public static final ResourceKey<Level> TROPICS_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(Tropics.MODID, "tropics"));
    public static final ResourceKey<DimensionType> TROPICS_TYPE_KEY = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(Tropics.MODID, "tropics"));

    public static void register() {
        System.out.println("Registering " + Tropics.MODID + " Dimensions");
    }
}
