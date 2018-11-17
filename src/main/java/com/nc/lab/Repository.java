package com.nc.lab;

import java.util.Arrays;

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
     * Конструктор - создание нового объекта
     */
    public Repository() {
        listOfPerson = new Person[0];
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
        return listOfPerson[n - 1];
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
            builder.append((i + 1) + ". ").append(listOfPerson[i].toString()).append("\r\n");
        }
        return builder.toString();
    }
}
