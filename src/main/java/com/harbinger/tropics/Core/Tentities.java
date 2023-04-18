package com.harbinger.tropics.Core;

import com.harbinger.tropics.Tentities.PoisonousFrogs;
import com.harbinger.tropics.Tropics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Tentities {
    public static DeferredRegister<EntityType<?>> TROPICS_ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
            Tropics.MODID);
    public static void register(IEventBus eventBus) {
        TROPICS_ENTITIES.register(eventBus);
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return TROPICS_ENTITIES.register(registryname, () -> entityTypeBuilder.build(registryname));
    }

    public static final RegistryObject<EntityType<PoisonousFrogs>> POISONOUS_FROG = TROPICS_ENTITIES.register("poisonous_frog",
            () -> EntityType.Builder.of(PoisonousFrogs::new, MobCategory.CREATURE).sized(0.6f, 0.6f)
                    .build(new ResourceLocation(Tropics.MODID, "poisonous_frog").toString()));

}
