package dev.mayaqq.infix.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;

public class InfixConfig {

    public static Config CONFIG = new Config();

    private static final File configFile = new File(FabricLoader.getInstance().getConfigDir() + "/infix.json");
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void load() {
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
                save();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                CONFIG = gson.fromJson(new FileReader(configFile), Config.class);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void save() {
        try {
            FileWriter writer = new FileWriter(configFile);
            gson.toJson(CONFIG, writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Config {
        //the thing to write in the config file
        public boolean allInfinity = true;
        public boolean mendingWithInfinity = true;

        public Config() {}
    }
}
