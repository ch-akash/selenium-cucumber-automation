package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    private static InputStream inputStream;

    public static String getPropertyValue(String keyName, String propertyFileName) throws IOException {
        Properties prop = new Properties();
        inputStream = PropertyUtil.class.getClassLoader().getResourceAsStream(propertyFileName);

        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propertyFileName + "' not found in the classpath");
        }
        return prop.getProperty(keyName);
    }
}
