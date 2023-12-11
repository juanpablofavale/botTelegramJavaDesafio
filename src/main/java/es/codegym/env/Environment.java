package es.codegym.env;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {
    public static String Token;
    public static String Nombre;

    public static void main() throws Exception{
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("config.properties"));
            Token = props.getProperty("API_KEY");
            Nombre = props.getProperty("BOT_NAME");
        } catch (IOException ex){
            System.out.println(ex);
        }
    }
}
