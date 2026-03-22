package fr.sebaseg;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Properties vProp = new Properties();
        InputStream vInputStream = null;
        try {
            vInputStream = App.class.getResourceAsStream("/info.properties");
            vProp.load(vInputStream);
            
            if (vInputStream != null) {
                vInputStream.close();
            }
        } catch (IOException e) {
            System.err.println("Error loading info.properties: " + e.getMessage());
        }
        
        System.out.println("Application version : " + vProp.getProperty("fr.sebaseg.version", "?"));
    }
}
