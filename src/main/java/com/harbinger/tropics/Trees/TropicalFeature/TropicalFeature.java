package com.harbinger.tropics.Trees.TropicalFeature;

import com.harbinger.tropics.Tropics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class TropicalFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_TREE = registerKey("palm_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AVOCADO_TREE = registerKey("avocado_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_TREE = registerKey("orange_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_TREE = registerKey("lemon_tree");






    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Tropics.MODID, name));
    }
}
