package com.grocerystore.except;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by retman on 13.07.16.
 */
public class ExceptionUtil {

    public String getErrorLog(String nameOfTheLog) {
        Properties prop = new Properties();
        String propFileName = "comunicates.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        String property = "";
        if (inputStream != null) {
            try {
                prop.load(inputStream);
                property = prop.getProperty(nameOfTheLog);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return property;
    }
}
