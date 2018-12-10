package com.nc.lab.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    /**
     * Путь к файлу конфигураций
     */
    public static final String PATH_TO_PROPERTIES = "src/main/resources/config.properties";

    public static <T> T inject(T object) {
        FileInputStream fileInputStream;
        //Инициализируем специальный объект Properties
        Properties prop = new Properties();
        try {
            //обращаемся к файлу и получаем данные
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            //Получаем класс
            Class<?> c = object.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    //Получаем значению по ключу(типу переменной)
                    String value = prop.getProperty(field.getType().getName());
                    Class<?> clazz = Class.forName(value);
                    //Создаем новый объект по значению
                    Object date = clazz.newInstance();

                    boolean accessible = field.isAccessible();
                    field.setAccessible(true);
                    field.set(object, date);
                    field.setAccessible(accessible);
                }
            }
        } catch (Exception e) {
            System.err.println("ОШИБКА!");
        }
        return object;
    }
}
