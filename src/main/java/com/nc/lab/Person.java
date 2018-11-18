package com.nc.lab;

import org.joda.time.LocalDate;

import java.util.Comparator;

/**
 * Класс Person
 *
 * @author Modest
 * @version 1
 * @
 */
public class Person implements Comparable<Person> {

    /*
    Статическое поле для автоматизации получения ID
     */
    static int countID = 1;

    /**
     * Поле идентификатор
     */
    private int id;

    /**
     * Поле имя
     */
    private String name;

    /**
     * Поле пол
     */
    private String sex;

    /**
     * Поле день рождения
     */
    private LocalDate birthday;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param name     - имя
     * @param sex      - пол
     * @param birthday - день рождения
     *                 //@see Person#Person()
     */
    public Person(final String name, final String sex, final LocalDate birthday) {
        this.id = countID;
        countID++;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    /**
     * Конструктор - создание нового объекта
     */
    public Person() {
        name = new String();
        sex = new String();
        birthday = new LocalDate();
        //CheckName = new CheckName();
    }

    /**
     * Функция получения значения поля {@link Person#id}
     *
     * @return идентификатор
     */
    public int getId() {
        return id;
    }

    /**
     * Процедура определения идентификатора {@link Person#id}
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Функция получения значения поля {@link Person#name}
     *
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Процедура определения имени {@link Person#name}
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Функция получения значения поля {@link Person#sex}
     *
     * @return пол
     */
    public String getMale() {
        return name;
    }

    /**
     * Процедура определения идентификатора {@link Person#sex}
     *
     * @param sex
     */
    public void setMale(String sex) {
        this.sex = sex;
    }

    /**
     * Функция получения значения поля {@link Person#birthday}
     *
     * @return день рождения
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Процедура определения дня рождения {@link Person#birthday}
     *
     * @param birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Функция получения возраста по дате рождения
     *
     * @return возраст
     */
    public int getAge() {
        int year = LocalDate.now().getYear() - birthday.getYear();
        if (LocalDate.now().getMonthOfYear() < birthday.getMonthOfYear()) {
            return year - 1;
        }
        if (LocalDate.now().getMonthOfYear() == birthday.getMonthOfYear()) {
            if (LocalDate.now().getDayOfMonth() < birthday.getDayOfMonth())
                return year - 1;
        }
        return year;
    }

   /* @Override
    public boolean equals(Object o)
    {
        return false;
    }*/


    /**
     * Функция конвертации данных класса в строку
     *
     * @return строка о личности
     */
    @Override
    public String toString() {
        return "ID " + id + "; Name: " + name + "; Male: " + sex + "; Birthday: " + birthday;
    }


    /*//Comparator для сортировки списка или массива объектов по зарплате
    public class CheckName {

        @Override
        public boolean equals(Object o) {
            return getName().equals(o);
        }
    };*/


    // компаратор сортирует список или массив объектов по имени
    public static Comparator<Person> NameComparator = new Comparator<Person>() {

        @Override
        public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };

    // компаратор сортирует список или массив объектов по возрасту
    public static Comparator<Person> AgeComparator = new Comparator<Person>() {

        @Override
        public int compare(Person p1, Person p2) {
            return p1.getAge() - p2.getAge();
        }
    };

    @Override
    public int compareTo(Person o) {
        return (this.id - o.id);
    }
}
