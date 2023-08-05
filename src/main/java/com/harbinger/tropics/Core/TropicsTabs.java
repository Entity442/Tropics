package com.harbinger.tropics.Core;

import com.harbinger.tropics.Tropics;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TropicsTabs {
    public static final DeferredRegister<CreativeModeTab> TROPICS_TAB = DeferredRegister.create(Registries.f_279569_, Tropics.MODID);
    public static void register(IEventBus eventBus) {
        TROPICS_TAB.register(eventBus);
    }



    public static final RegistryObject<CreativeModeTab> TROPICS = TROPICS_TAB.register("tropics",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.tropics"))
                    .icon(TItems.MANGO.get()::getDefaultInstance).displayItems((parameters, output) -> {
                        TItems.TROPICAL_ITEMS.forEach(item -> output.accept(item.asItem()));
                    }).build()
    );
}
