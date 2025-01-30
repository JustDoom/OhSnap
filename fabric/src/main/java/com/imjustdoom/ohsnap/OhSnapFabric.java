package com.imjustdoom.ohsnap;

import net.fabricmc.api.ModInitializer;

public class OhSnapFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        OhSnap.init();
    }
}
