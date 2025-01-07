
package restassured.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaders {
            private static Properties properties = new Properties();

 static {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/ConfigurationsAndProperties/Configurations.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file.");
        }
    }

 public static String getProperty(String key) {
        return properties.getProperty(key);
    
}
}
