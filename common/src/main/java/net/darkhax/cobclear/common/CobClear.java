package net.darkhax.cobclear.common;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.darkhax.pricklemc.common.api.config.ConfigManager;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CobClear {

    public static final String MOD_ID = "cobclear";
    public static final String MOD_NAME = "CobClear";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static final Config CONFIG = ConfigManager.load(MOD_ID, new Config());
    public static final TagKey<Enchantment> CLEARS_COBWEBS = TagKey.create(Registries.ENCHANTMENT, id("clears_cobwebs"));
    public static final TagKey<Block> SHOULD_MINE_FASTER = TagKey.create(Registries.BLOCK, id("bane_of_arthropods_mines_faster"));

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    public static int getClearLevel(BlockState state, ItemStack stack) {
        int level = 0;
        if (state.is(CobClear.SHOULD_MINE_FASTER)) {
            final ItemEnchantments enchantments = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
            for (Object2IntMap.Entry<Holder<Enchantment>> entry : enchantments.entrySet()) {
                if (entry.getKey().is(CLEARS_COBWEBS)) {
                    level += entry.getIntValue();
                }
            }
        }
        return level;
    }
}