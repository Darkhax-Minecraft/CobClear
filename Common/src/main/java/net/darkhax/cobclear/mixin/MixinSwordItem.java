package net.darkhax.cobclear.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SwordItem.class)
public class MixinSwordItem {

    @Inject(method = "getDestroySpeed(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/block/state/BlockState;)F", at = @At("RETURN"), cancellable = true)
    private void getDigSpeed(ItemStack stack, BlockState state, CallbackInfoReturnable<Float> cbi) {

        if (state.is(Blocks.COBWEB)) {

            final int enchLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, stack);

            if (enchLevel > 0) {

                cbi.setReturnValue(cbi.getReturnValueF() * (1 + enchLevel));
            }
        }
    }
}