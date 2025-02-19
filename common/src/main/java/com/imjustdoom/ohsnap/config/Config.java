package com.imjustdoom.ohsnap.config;

import com.imjustdoom.ohsnap.platform.Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class Config {

    private static Path FILE_PATH;
    private static Properties PROPERTIES;

    public static float VOLUME;
    public static float PITCH;
    public static String SOUND;

    public static void init() throws IOException {
        PROPERTIES = new Properties();
        FILE_PATH = Path.of(Services.PLATFORM.getConfigPath() + "/ohsnap.properties");
        if (!FILE_PATH.toFile().exists()) {
            new File(FILE_PATH.toString()).createNewFile();
        }
        PROPERTIES.load(new FileInputStream(FILE_PATH.toFile()));

        VOLUME = getFloat("volume", "1.0");
        PITCH = getFloat("pitch", "1.25");
        SOUND = getString("sound", "minecraft:entity.leash_knot.break");

        save();
    }

    private static String getString(final String setting, final String defaultValue) {
        String value = PROPERTIES.getProperty(setting);
        if (value == null) {
            PROPERTIES.setProperty(setting, defaultValue);
            value = defaultValue;
        }
        return value;
    }

    private static int getInt(final String setting, final String defaultValue) {
        String value = PROPERTIES.getProperty(setting);
        if (value == null) {
            PROPERTIES.setProperty(setting, defaultValue);
            value = defaultValue;
        }
        return Integer.parseInt(value);
    }

    private static float getFloat(final String setting, final String defaultValue) {
        String value = PROPERTIES.getProperty(setting);
        if (value == null) {
            PROPERTIES.setProperty(setting, defaultValue);
            value = defaultValue;
        }
        return Float.parseFloat(value);
    }

    private static boolean getBoolean(final String setting, final String defaultValue) {
        String value = PROPERTIES.getProperty(setting);
        if (value == null) {
            PROPERTIES.setProperty(setting, defaultValue);
            value = defaultValue;
        }
        return Boolean.parseBoolean(value);
    }

    public static void save() throws IOException {
        PROPERTIES.store(new FileWriter(FILE_PATH.toFile()),
                """
                        Config for OhSnap
                        'volume' The volume for the snap sound
                        'pitch' The pitch for the sound
                        'sound' The sound to play when it snaps. id:sound (minecraft:entity.leash_knot.break). Supports custom sounds
                        """);
    }
}