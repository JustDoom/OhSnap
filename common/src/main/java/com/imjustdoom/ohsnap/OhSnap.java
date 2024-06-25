package com.imjustdoom.ohsnap;

import com.imjustdoom.ohsnap.config.Config;

import java.io.IOException;

public class OhSnap {
    public static final String MOD_ID = "ohsnap";

    public static void init() {
        try {
            Config.init();
        } catch (IOException exception) {
            System.err.println("There was an error setting up or saving the config file for OhSnap :(");
            exception.printStackTrace();
        }
    }
}
