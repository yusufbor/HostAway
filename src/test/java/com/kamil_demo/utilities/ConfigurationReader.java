package com.kamil_demo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();


    //static block run before everything and run one time
    static {

        try {
            FileInputStream file = new FileInputStream("configuration.properties");

            properties.load(file);
            file.close();

        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class");
            e.printStackTrace();
        }

    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }

}


