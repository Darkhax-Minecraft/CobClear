package net.darkhax.cobclear.mixin;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockBehaviour.class)
public interface AccessorBlockBehaviour {

    @Mutable
    @Accessor("soundType")
    void cobclear$setSoundType(SoundType soundType);
}
