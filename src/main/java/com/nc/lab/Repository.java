package com.nc.lab;

import com.nc.lab.sort.BubleSort;
import com.nc.lab.sort.SortInterface;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс Repository
 *
 * @author Modest
 * @version 1
 * @
 */
public class Repository {

    /**
     * Поле массив Person
     */
    private Person[] listOfPerson;
    /**
     * Для выбора сортировки
     */
    private SortInterface sortInt;

    /**
     * Конструктор - создание нового объекта
     */
    public Repository(SortInterface sortInt) {
        listOfPerson = new Person[0];
        this.sortInt = sortInt;
    }

    public Repository() {
        listOfPerson = new Person[0];
        sortInt = new BubleSort();
    }


    /**
     * Функция получения значения поля {@link Repository#listOfPerson}
     *
     * @return
     */
    public Person[] getListOfPerson() {
        return listOfPerson;
    }

    /**
     * Функция возврата Person по номеру
     *
     * @param n - номер
     * @return
     */
    public Person getOfPerson(int n) {
//        if (n <= 0 || n >= listOfPerson.length)
//            return null;
//        else
        try {
            return listOfPerson[n - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("Выход за границы массива");
        }
        finally {
            return new Person();
        }
    }

    /**
     * Функция добавление в массив Person
     *
     * @param p - person
     */
    public void addPerson(Person p) {
        listOfPerson = Arrays.copyOf(listOfPerson, listOfPerson.length + 1);
        listOfPerson[listOfPerson.length - 1] = p;
    }

    /**
     * Функция удаления из массива Person по номеру
     *
     * @param d
     */
    public void deletePerson(int d) {
        for (int i = d - 1; i < listOfPerson.length - 1; i++) {
            listOfPerson[i] = listOfPerson[i + 1];
        }
        listOfPerson = Arrays.copyOf(listOfPerson, listOfPerson.length - 1);
    }

    /**
     * Функция конвертации данных класса в строку
     *
     * @return строка о всех данных массива
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("List of persons:").append("\r\n");
        for (int i = 0; i < listOfPerson.length; i++) {
            builder.append((i + 1) + ". ").append(listOfPerson[i].toString());
        }
        return builder.toString();
    }

    /**
     * Метод поиска объекта
     *
     * @param o        - ищем по этому параметру
     * @param checkInt - передаем интерфейс
     * @return
     */
    public Person[] search(Object o, CheckInterface checkInt) {
        Person[] list = new Person[listOfPerson.length];
        int k = 0;
        for (Person p : listOfPerson) {
            if (checkInt.check(p, o)) {
                list[k] = p;
                k++;
            }
        }
        list = Arrays.copyOf(list, k);
        return list;
    }


    /**
     * Сортировка выбирающаяся по флагу
     *
     * @param c - объект компоратора
     */
    public void sort(Comparator<Person> c) {
        sortInt.sort(listOfPerson, c);
    }
}
