package net.darkhax.cobclear.neoforge;

import net.darkhax.cobclear.common.CobClear;
import net.neoforged.fml.common.Mod;

@Mod(CobClear.MOD_ID)
public class CobClearNeoforge {

    public CobClearNeoforge() {
        CobClear.LOG.debug("Initializing CobClear: {}", CobClear.CONFIG.speed);
    }
}