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
public class Person {//implements Comparable<Person> {

    /**
     * Статическое поле для автоматизации получения ID
     */
    private static int countID = 0;
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
     */
    public Person(final String name, final String sex, final LocalDate birthday) {
        countID++;
        this.id = countID;
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

    /**
     * Функция конвертации данных класса в строку
     *
     * @return строка о личности
     */
    @Override
    public String toString() {
        return "ID " + id + "; Name: " + name + "; Male: " + sex + "; Birthday: " + birthday;
    }

    /**
     * компаратор сортирует список или массив объектов по имени
     */
    public static Comparator<Person> NameComparator = new Comparator<Person>() {

        @Override
        public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };

    /**
     * Компаратор сортирует список или массив объектов по возрасту
     */
    public static Comparator<Person> AgeComparator = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            return p2.getAge() - p1.getAge();
        }
    };

    /**
     * Компаратор сортирует список или массив объектов по дате рождения
     */
    public static Comparator<Person> BirthdayComparator = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.getBirthday().getYear() != p2.getBirthday().getYear())
                return p1.getBirthday().getYear() - p2.getBirthday().getYear();
            if (p1.getBirthday().getMonthOfYear() != p2.getBirthday().getMonthOfYear())
                return p1.getBirthday().getMonthOfYear() - p2.getBirthday().getMonthOfYear();
            return p1.getBirthday().getDayOfMonth() - p2.getBirthday().getDayOfMonth();
        }
    };

   /* @Override
    public int compareTo(Person o) {
        return (this.id - o.id);
    }*/

    /**
     * Проверка по имени
     */
    public static CheckInterface CheckName = new CheckInterface() {
        @Override
        public boolean check(Person p, Object o) {
            return p.getName().equals(o);
        }
    };

    /**
     * Проверка по дню рождения
     */
    public static CheckInterface CheckBirthday = new CheckInterface() {
        @Override
        public boolean check(Person p, Object o) {
            return p.getBirthday().equals(o);
        }
    };

    /**
     * Проверка по возрасту
     */
    public static CheckInterface CheckAge = new CheckInterface() {
        @Override
        public boolean check(Person p, Object o) {
            return p.getAge() == (Integer) o;
        }
    };


}
