package br.com.nexus.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                System.out.println("Sorry, unable to find 'config.properties'.");
            } else {
                properties.load(inputStream);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static String get(String key) {
        return properties.getProperty(key);
    }
}
