package net.darkhax.cobclear;

import net.fabricmc.api.ModInitializer;

public class CobClearFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        CobClearCommon.init();
    }
}