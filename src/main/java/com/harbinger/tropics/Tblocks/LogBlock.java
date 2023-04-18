package com.harbinger.tropics.Tblocks;

import com.harbinger.tropics.Core.Tblocks;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class LogBlock extends FlammableRotatedPillarBlock{
    public LogBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(toolAction == ToolAction.get("axe_strip")) {
                if (state.is(Tblocks.AVOCADO_LOGS.get())){
                    return Tblocks.STRIPPED_AVOCADO_LOGS.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }else if (state.is(Tblocks.PALM_LOGS.get())) {
                    return Tblocks.STRIPPED_PALM_LOGS.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }else if (state.is(Tblocks.LEMON_LOGS.get())) {
                    return Tblocks.STRIPPED_LEMON_LOGS.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }else if (state.is(Tblocks.ORANGE_LOGS.get())) {
                    return Tblocks.STRIPPED_ORANGE_LOGS.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
                }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
