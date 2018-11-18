package com.nc.lab;

import java.util.Comparator;

public class SortedClass {

    public static void bubleSort(Person[] listOfPerson, Comparator<Person> c) {
        int i = 0;
        Person buf;
        char swap_cnt = 0;

        if (listOfPerson.length == 0)
            return;
        while (i < listOfPerson.length) {
            if (i + 1 != listOfPerson.length && c.compare(listOfPerson[i], listOfPerson[i + 1]) > 0) {
                buf = listOfPerson[i];
                listOfPerson[i] = listOfPerson[i + 1];
                listOfPerson[i + 1] = buf;
                swap_cnt = 1;
            }
            i++;
            if (i == listOfPerson.length && swap_cnt == 1) {
                swap_cnt = 0;
                i = 0;
            }
        }
    }

    public static void quickSort(Person[] listOfPerson, int low, int high, Comparator<Person> c) {
        if (listOfPerson.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        Person opora = listOfPerson[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (c.compare(listOfPerson[i], opora) > 0) {
                i++;
            }

            while (c.compare(listOfPerson[j], opora) < 0) {
                j--;
            }

            if (i <= j) {//меняем местами
                Person temp = listOfPerson[i];
                listOfPerson[i] = listOfPerson[j];
                listOfPerson[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(listOfPerson, low, j, c);

        if (high > i)
            quickSort(listOfPerson, i, high, c);
    }

    public static void insertionSort(Person[] listOfPerson, Comparator<Person> c) {
        if (listOfPerson.length == 0)
            return;
        Person key;
        for (int i = 1; i < listOfPerson.length; i++) {
            key = listOfPerson[i];
            int j = i - 1;
            while (j >= 0 && c.compare(listOfPerson[j], key) > 0) {
                listOfPerson[j + 1] = listOfPerson[j];
                j = j - 1;
            }
            listOfPerson[j + 1] = key;
        }
    }

}
