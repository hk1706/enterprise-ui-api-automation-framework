package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private static Properties envProperties;

    static {
        try (FileInputStream envFile = new FileInputStream("src/test/resources/config.properties")) {
            envProperties = new Properties();
            envProperties.load(envFile);

            String env = envProperties.getProperty("env");
            if (env == null || env.trim().isEmpty()) {
            throw new IllegalStateException(
                "Missing 'env' in src/test/resources/config.properties. "
                    + "Set it to qa, sit, or uat.");
            }

            properties = new Properties();
            try (FileInputStream configFile = new FileInputStream(
                "src/test/resources/" + env.trim().toLowerCase() + ".properties")) {
            properties.load(configFile);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    // Get property from environment specific file (qa.properties / sit.properties etc.)
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalStateException("Missing required property '" + key
                    + "' in the selected environment properties file.");
        }
        return value.trim();
    }

    // Get property from main config.properties
    public static String getConfigProperty(String key) {
        return envProperties.getProperty(key);
    }
}