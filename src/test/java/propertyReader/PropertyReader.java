package propertyReader;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

    protected Properties properties;

    public PropertyReader(){
        try{
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/"
                    +System.getProperty("env")+".properties");
            properties = new Properties();
            properties.load(fileInputStream);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
