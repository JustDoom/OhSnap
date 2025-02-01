package com.imjustdoom.ohsnap;

import com.imjustdoom.ohsnap.config.Config;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class OhSnap {
    public static final String MOD_ID = "ohsnap";
    public static final Logger LOG = LoggerFactory.getLogger("OhSnap");
    public static SoundEvent SOUND;

    public static void init() {
        try {
            Config.init();

            SOUND = BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse(Config.SOUND));

            if (SOUND == null) {
                System.err.println("Unable to find the sound for the id `" + Config.SOUND + "`");
            }
        } catch (IOException exception) {
            System.err.println("There was an error setting up or saving the config file for OhSnap :(");
            exception.printStackTrace();
        }
    }
}
