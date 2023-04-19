package com.harbinger.tropics.Core;

import com.harbinger.tropics.TItems.AncientTotem;
import com.harbinger.tropics.Tropics;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Tropics.MODID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public  static final RegistryObject<Item> POISONFROG_SPAWNEGG = ITEMS.register("poisonfrog_spawnegg",
            () -> new ForgeSpawnEggItem(Tentities.POISONOUS_FROG,-1235818,-9423173, new Item.Properties()));
    public static final RegistryObject<Item> COCONUT = ITEMS.register("coconut",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AVOCADO = ITEMS.register("avocado",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1f).build())));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.2f).build())));
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.5f).build())));


    public static final RegistryObject<Item> ANCIENT_TOTEM = ITEMS.register("ancient_totem",
            AncientTotem::new);




    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static final RegistryObject<Item> PALM_LOGS = block(Tblocks.PALM_LOGS);
    public static final RegistryObject<Item> STRIPPED_PALM_LOGS = block(Tblocks.STRIPPED_PALM_LOGS);
    public static final RegistryObject<Item> PALM_LEAVES = block(Tblocks.PALM_LEAVES);
    public static final RegistryObject<Item> PALM_PLANKS = block(Tblocks.PALM_PLANKS);
    public static final RegistryObject<Item> PALM_SAPLING = block(Tblocks.PALM_SAPLING);

    public static final RegistryObject<Item> AVOCADO_LOGS = block(Tblocks.AVOCADO_LOGS);
    public static final RegistryObject<Item> STRIPPED_AVOCADO_LOGS = block(Tblocks.STRIPPED_AVOCADO_LOGS);
    public static final RegistryObject<Item> AVOCADO_LEAVES = block(Tblocks.AVOCADO_LEAVES);
    public static final RegistryObject<Item> BLOOMING_AVOCADO_LEAVES = block(Tblocks.BLOOMING_AVOCADO_LEAVES);
    public static final RegistryObject<Item> AVOCADO_PLANKS = block(Tblocks.AVOCADO_PLANKS);
    public static final RegistryObject<Item> AVOCADO_SAPLING = block(Tblocks.AVOCADO_SAPLING);

    public static final RegistryObject<Item> LEMON_LOGS = block(Tblocks.LEMON_LOGS);
    public static final RegistryObject<Item> STRIPPED_LEMON_LOGS = block(Tblocks.STRIPPED_LEMON_LOGS);
    public static final RegistryObject<Item> LEMON_LEAVES = block(Tblocks.LEMON_LEAVES);
    public static final RegistryObject<Item> BLOOMING_LEMON_LEAVES = block(Tblocks.BLOOMING_LEMON_LEAVES);
    public static final RegistryObject<Item> LEMON_PLANKS = block(Tblocks.LEMON_PLANKS);
    public static final RegistryObject<Item> LEMON_SAPLING = block(Tblocks.LEMON_SAPLING);

    public static final RegistryObject<Item> ORANGE_LOGS = block(Tblocks.ORANGE_LOGS);
    public static final RegistryObject<Item> STRIPPED_ORANGE_LOGS = block(Tblocks.STRIPPED_ORANGE_LOGS);
    public static final RegistryObject<Item> ORANGE_LEAVES = block(Tblocks.ORANGE_LEAVES);
    public static final RegistryObject<Item> BLOOMING_ORANGE_LEAVES = block(Tblocks.BLOOMING_ORANGE_LEAVES);
    public static final RegistryObject<Item> ORANGE_PLANKS = block(Tblocks.ORANGE_PLANKS);
    public static final RegistryObject<Item> ORANGE_SAPLING = block(Tblocks.ORANGE_SAPLING);
}
