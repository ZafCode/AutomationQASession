package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = new FileInputStream("configuration.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Properties file not found!");
        }
    }

    public static String getProperty(String keyName) {
        return properties.getProperty(keyName);
    }
}
