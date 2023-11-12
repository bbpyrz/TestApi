package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;
    public static void setProperty(String key) throws IOException {
        String path = "src/test/configuration.properties";
        FileInputStream input = new FileInputStream(path);
        properties = new Properties();
        properties.load(input);
        input.close();
    }

    public static String getProperty(String key) {
        try {
            setProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
}
