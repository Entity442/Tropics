package com.harbinger.tropics.Core;

import com.harbinger.tropics.Tblocks.*;
import com.harbinger.tropics.Trees.*;
import com.harbinger.tropics.Tropics;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Tblocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tropics.MODID);



    public static final RegistryObject<Block> PALM_LOGS = BLOCKS.register("palm_log", () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_PALM_LOGS = BLOCKS.register("stripped_palm_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> PALM_LEAVES = BLOCKS.register("palm_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> PALM_PLANKS = BLOCKS.register("palm_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> PALM_SAPLING = BLOCKS.register("palm_sapling", () -> new SandSapling(new PalmTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> COCONUT_PLANT = BLOCKS.register("coconut_plant", CoconutNutBlock::new);


    public static final RegistryObject<Block> AVOCADO_LOGS = BLOCKS.register("avocado_log", () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_AVOCADO_LOGS = BLOCKS.register("stripped_avocado_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> AVOCADO_LEAVES = BLOCKS.register("avocado_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> BLOOMING_AVOCADO_LEAVES = BLOCKS.register("blooming_avocado_leaves", FruitLeavesBlock::new);
    public static final RegistryObject<Block> AVOCADO_PLANKS = BLOCKS.register("avocado_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> AVOCADO_SAPLING = BLOCKS.register("avocado_sapling", () -> new SaplingBlock(new AvocadoTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> LEMON_LOGS = BLOCKS.register("lemon_log", () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_LEMON_LOGS = BLOCKS.register("stripped_lemon_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> LEMON_LEAVES = BLOCKS.register("lemon_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> BLOOMING_LEMON_LEAVES = BLOCKS.register("blooming_lemon_leaves", FruitLeavesBlock::new);
    public static final RegistryObject<Block> LEMON_PLANKS = BLOCKS.register("lemon_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> LEMON_SAPLING = BLOCKS.register("lemon_sapling", () -> new SaplingBlock(new LemonTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> ORANGE_LOGS = BLOCKS.register("orange_log", () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_ORANGE_LOGS = BLOCKS.register("stripped_orange_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> ORANGE_LEAVES = BLOCKS.register("orange_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> BLOOMING_ORANGE_LEAVES = BLOCKS.register("blooming_orange_leaves", FruitLeavesBlock::new);
    public static final RegistryObject<Block> ORANGE_PLANKS = BLOCKS.register("orange_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new SaplingBlock(new OrangeTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> MANGO_LOGS = BLOCKS.register("mango_log", () -> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_MANGO_LOGS = BLOCKS.register("stripped_mango_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> MANGO_LEAVES = BLOCKS.register("mango_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> BLOOMING_MANGO_LEAVES = BLOCKS.register("blooming_mango_leaves", FruitLeavesBlock::new);
    public static final RegistryObject<Block> MANGO_PLANKS = BLOCKS.register("mango_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> MANGO_SAPLING = BLOCKS.register("mango_sapling", () -> new SaplingBlock(new MangoTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));



    public static final RegistryObject<Block> TROPICAL_LILY_PAD = BLOCKS.register("tropical_lily", () -> new WaterlilyBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD).sound(SoundType.LILY_PAD).noOcclusion()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
