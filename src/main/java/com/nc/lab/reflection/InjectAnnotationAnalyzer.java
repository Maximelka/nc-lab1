package com.nc.lab.reflection;


import java.lang.reflect.Field;
import java.io.*;
import java.util.Properties;

public class InjectAnnotationAnalyzer {

    //путь к нашему файлу конфигураций
    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";
     //fileInputStream;


    public void parse(Class<?> c) throws Exception {


        //инициализируем специальный объект Properties
        //типа Hashtable для удобной работы с данными
        FileInputStream fileInputStream;
        //Properties prop = new Properties();
        try {

            //fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            //prop.load(fileInputStream);

            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {

                    //String value = prop.getProperty(field.getName());
                    Class<?> clazz = Class.forName("com.nc.lab.sort.BubleSort");
                    Object date = clazz.newInstance();
                    field.set(this, date);
                }
            }
        } catch (Exception e) {
        }

    }
}
