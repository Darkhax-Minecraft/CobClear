package net.darkhax.cobclear.fabric;

import net.darkhax.cobclear.common.CobClear;
import net.fabricmc.api.ModInitializer;

public class CobClearFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        CobClear.LOG.debug("Initializing CobClear: {}", CobClear.CONFIG.speed);
    }
}