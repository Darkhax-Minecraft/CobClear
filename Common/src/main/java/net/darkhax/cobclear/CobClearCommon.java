package net.darkhax.cobclear;

import net.darkhax.cobclear.mixin.AccessorBlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

public class CobClearCommon {

    public static void init() {

        if (Blocks.COBWEB instanceof AccessorBlockBehaviour block) {
            block.cobclear$setSoundType(SoundType.WOOL);
        }
    }
}
