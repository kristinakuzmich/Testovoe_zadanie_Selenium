import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    protected static InputStreamReader reader = null;
    static {
        try {
            InputStream stream = new FileInputStream("src/main/resources/conf.properties");
            reader = new InputStreamReader(stream,"UTF-8");
            PROPERTIES = new Properties();
            PROPERTIES.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}