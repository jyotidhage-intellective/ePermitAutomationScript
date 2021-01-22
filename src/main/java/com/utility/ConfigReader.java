package com.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties p;
    private static final String filePath = "config.properties";

    /****
     * This method is used to load the config.properties file
     * @return
     */
    public  Properties readPropertiesFile() {

        try {
             p = new Properties();
            if (filePath != null && filePath.length() > 0) {
                InputStream in = null;
                try {
                    in = getStream(filePath);
                    p.load(in);
                    return p;
                } finally {
                    if (in != null) {
                        in.close();
                    }
                }
            } else {

            }
        } catch (IOException ex) {

        } catch (IllegalArgumentException ex) {

        }
        return null;
    }

    private static InputStream getStream(String name) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
    }

}
