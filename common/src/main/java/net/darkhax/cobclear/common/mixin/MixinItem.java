package net.darkhax.cobclear.common.mixin;

import net.darkhax.cobclear.common.CobClear;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class MixinItem {

    @Inject(method = "getDestroySpeed(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/block/state/BlockState;)F", at = @At("RETURN"), cancellable = true)
    private void modifyDestroySpeed(ItemStack itemStack, BlockState state, CallbackInfoReturnable<Float> cbi) {
        int clearLevel = CobClear.getClearLevel(state, itemStack);
        if (clearLevel > 0) {
            cbi.setReturnValue(cbi.getReturnValueF() * (1f + (clearLevel * CobClear.CONFIG.speed)));
        }
    }
}