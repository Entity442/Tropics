package com.harbinger.tropics;

import com.harbinger.tropics.Core.TBiomes;
import com.harbinger.tropics.Core.TItems;
import com.harbinger.tropics.Core.Tblocks;
import com.harbinger.tropics.Core.Tentities;
import com.harbinger.tropics.Tevents.LoadCreativeItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

@Mod(Tropics.MODID)
public class Tropics
{

    public static final String MODID = "tropics";

    private static final Logger LOGGER = LogUtils.getLogger();
    public Tropics()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        TItems.register(modEventBus);
        Tblocks.register(modEventBus);
        Tentities.register(modEventBus);
        TBiomes.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        GeckoLib.initialize();
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == LoadCreativeItems.TROPICS_TAB) {
            event.accept(TItems.POISONFROG_SPAWNEGG);
            event.accept(TItems.PALM_LOGS.get());
            event.accept(TItems.AVOCADO_LOGS.get());
            event.accept(TItems.ORANGE_LOGS.get());
            event.accept(TItems.LEMON_LOGS.get());
            event.accept(TItems.STRIPPED_PALM_LOGS.get());
            event.accept(TItems.STRIPPED_AVOCADO_LOGS.get());
            event.accept(TItems.STRIPPED_ORANGE_LOGS.get());
            event.accept(TItems.STRIPPED_LEMON_LOGS.get());
            event.accept(TItems.PALM_PLANKS.get());
            event.accept(TItems.AVOCADO_PLANKS.get());
            event.accept(TItems.ORANGE_PLANKS.get());
            event.accept(TItems.LEMON_PLANKS.get());
            event.accept(TItems.STRIPPED_ORANGE_LOGS.get());
            event.accept(TItems.STRIPPED_LEMON_LOGS.get());
            event.accept(TItems.PALM_LEAVES.get());
            event.accept(TItems.AVOCADO_LEAVES.get());
            event.accept(TItems.ORANGE_LEAVES.get());
            event.accept(TItems.LEMON_LEAVES.get());
            event.accept(TItems.BLOOMING_AVOCADO_LEAVES.get());
            event.accept(TItems.BLOOMING_LEMON_LEAVES.get());
            event.accept(TItems.BLOOMING_ORANGE_LEAVES.get());
            event.accept(TItems.PALM_SAPLING.get());
            event.accept(TItems.AVOCADO_SAPLING.get());
            event.accept(TItems.ORANGE_SAPLING.get());
            event.accept(TItems.LEMON_SAPLING.get());
            event.accept(TItems.AVOCADO.get());
            event.accept(TItems.LEMON.get());
            event.accept(TItems.ORANGE.get());
        }
    }
}
