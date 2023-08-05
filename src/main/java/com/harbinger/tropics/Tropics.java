package com.harbinger.tropics;

import com.harbinger.tropics.Core.*;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
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
    public  static Tropics instance;
    public Tropics()
    {
        instance = this;
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        TItems.register(modEventBus);
        Tblocks.register(modEventBus);
        Tentities.register(modEventBus);
        TtrunkGenerator.register(modEventBus);
        TfoliageGenerator.register(modEventBus);
        TropicsTabs.register(modEventBus);



        TBiomes.register();
        TropicsDimension.register();
        GeckoLib.initialize();
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

}
