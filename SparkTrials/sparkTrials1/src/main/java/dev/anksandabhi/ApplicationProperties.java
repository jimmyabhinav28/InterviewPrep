package dev.anksandabhi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {

    private static Properties properties = null;

    private static void loadProperties() {
        if (properties == null) {
            InputStream inputStream = ApplicationProperties.class.getClassLoader().getResourceAsStream("app.properties");
            if (inputStream != null) {
                properties = new Properties();
                try {
                    properties.load(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static String getProperty(String key) {
        loadProperties();
//        properties=new Properties();
        return properties.getProperty(key);
    }
}
