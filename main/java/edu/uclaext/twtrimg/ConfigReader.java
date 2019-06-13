package edu.uclaext.twtrimg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class ConfigReader {
    private static ConfigReader instance;
    public HashMap<String, String> config;

    private ConfigReader(){
        config = new HashMap<String, String>();
        init();
    }

    private void init() {
        InputStream inputStream = null;
        Properties prop = new Properties();

        String fxmlPath = "/fxml/main.fxml";

        URL path = getClass().getResource(fxmlPath);

        String propfile = "/config.properties";
        URL propfile_url = getClass().getResource(propfile);
        System.out.println(propfile_url);
        try {
            inputStream = new FileInputStream(propfile_url.getFile());
//        is = getClass().getClassLoader().getResourceAsStream(propfile);

            prop.load(inputStream);

            Enumeration<Object> keys = prop.keys();
            while ((keys).hasMoreElements()) {
                String key = (String)keys.nextElement();
                String value = prop.getProperty(key);
                config.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ConfigReader getInstance(){
        if(instance == null) {
            instance = new ConfigReader();
        }

        return instance;
    }
}
