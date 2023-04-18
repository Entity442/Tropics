package com.harbinger.tropics.Tevents;

import com.harbinger.tropics.Core.TItems;
import com.harbinger.tropics.Core.Tentities;
import com.harbinger.tropics.Tentities.PoisonousFrogs;
import com.harbinger.tropics.Tropics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Tropics.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LoadCreativeItems {
    public static CreativeModeTab TROPICS_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        TROPICS_TAB = event.registerCreativeModeTab(new ResourceLocation(Tropics.MODID, "tropics_tab"),
                builder -> builder.icon(() -> new ItemStack(TItems.PALM_LEAVES.get())).title(Component.translatable("itemGroup." + Tropics.MODID)).build());
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(Tentities.POISONOUS_FROG.get(), PoisonousFrogs.createAttributes().build());
    }
}
