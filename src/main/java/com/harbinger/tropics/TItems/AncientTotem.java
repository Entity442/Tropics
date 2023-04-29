package com.harbinger.tropics.TItems;

import com.harbinger.tropics.Core.SpawnHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AncientTotem extends Item {
    public AncientTotem() {
        super(new Item.Properties().stacksTo(1).durability(2));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (player instanceof ServerPlayer serverPlayer && !level.isClientSide){
            ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("tropics:tropics"));
            ResourceKey<Level> oldDestination = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("minecraft:overworld"));
            if (!(serverPlayer.level.dimension() == destinationType)){
                ServerLevel nextLevel = serverPlayer.server.getLevel(destinationType);
                    if (nextLevel != null) {
                        serverPlayer.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
                        serverPlayer.connection.send(new ClientboundPlayerAbilitiesPacket(serverPlayer.getAbilities()));
                        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(player.position().x(), player.position().y(), player.position().z());
                        SpawnHelper.getSpawn(nextLevel, pos);
                        serverPlayer.teleportTo(nextLevel, pos.getX(), pos.getY(), pos.getZ(), player.getYRot(), player.getXRot());
                    }
            }else if (serverPlayer.level.dimension() == destinationType){
                 ServerLevel nextLevel = serverPlayer.server.getLevel(oldDestination);
                if (nextLevel != null) {
                    serverPlayer.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
                    serverPlayer.connection.send(new ClientboundPlayerAbilitiesPacket(serverPlayer.getAbilities()));
                    BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(player.position().x(), player.position().y(), player.position().z());
                    SpawnHelper.getSpawn(nextLevel, pos);
                    serverPlayer.teleportTo(nextLevel, pos.getX(), pos.getY(), pos.getZ(), player.getYRot(), player.getXRot());
                }
            }
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION,60,0));
            itemStack.hurtAndBreak(1, player, (p_43414_) -> {
                p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }
        return super.use(level, player, hand);
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return 2;
    }
}
