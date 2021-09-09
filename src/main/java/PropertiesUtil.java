import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    public static String getKey(String key) {
        Properties properties = new Properties();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/properties/config.properties"));
            properties.load(bufferedReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

    public static Long getLongKey(String key) {
        Properties properties = new Properties();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/properties/config.properties"));
            properties.load(bufferedReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Long.valueOf(properties.getProperty(key));
    }
}
