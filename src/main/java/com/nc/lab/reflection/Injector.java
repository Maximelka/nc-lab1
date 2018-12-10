package com.nc.lab.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";

    public static <T> T inject (T object) {
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
        fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
        prop.load(fileInputStream);
            Class<?> c = object.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    String value = prop.getProperty(field.getName());
                    Class<?> clazz = Class.forName(value);
                    Object date = clazz.newInstance();
                    boolean accessible = field.isAccessible();
                    field.setAccessible(true);
                    field.set(object, date);
                    field.setAccessible(accessible);
                }
            }
        }
        catch (Exception e){
            System.err.println("ОШИБКА!");
        }
        return object;
    }
}
