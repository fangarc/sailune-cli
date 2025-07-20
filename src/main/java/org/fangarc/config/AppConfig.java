package org.fangarc.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class AppConfig {
    private static final SailuneConfig config = new SailuneConfig();

    public static void initializeDatabase(){
        String dbPath = config.getDatabasePath();

        // Connect later
    }
}
