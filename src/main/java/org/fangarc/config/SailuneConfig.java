package org.fangarc.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class SailuneConfig {
    private static final String CONFIG_DIR = ".sailune";
    private static final String CONFIG_FILE = "sailune.properties";
    private static final String DEFAULT_DB_FILE = "sailune.db";

    private final Properties config;

    public SailuneConfig(){
        this.config = loadOrCreateConfig();
    }

    private Properties loadOrCreateConfig(){
        Path configDir = Paths.get(System.getProperty("user.home"), CONFIG_DIR);
        Path configPath = configDir.resolve(CONFIG_FILE);
        Properties props = new Properties();

        try {
            Files.createDirectories(configDir);

            if (!Files.exists(configPath)) {
                props.setProperty("database.path", configDir.resolve(DEFAULT_DB_FILE).toString());
                try (OutputStream out = Files.newOutputStream(configPath)) {
                    props.store(out, "Sailune Configuration");
                } catch (IOException e) {
                    System.err.println("Error writing Sailune configuration: " + e.getMessage());
                }
            } else {
                try (InputStream in = Files.newInputStream(configPath)) {
                    props.load(in);
                } catch (IOException e) {
                    System.err.println("Error reading Sailune configuration: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize Sailune configuration", e);
        }

        return props;
    }

    public String getDatabasePath() {
        return config.getProperty("database.path");
    }
}
