package com.imjustdoom.ohsnap.fabric;

import com.imjustdoom.ohsnap.OhSnap;
import net.fabricmc.api.ModInitializer;

public class OhSnapFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        OhSnap.init();
    }
}
