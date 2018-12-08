package com.nc.lab.sort;

import com.nc.lab.model.Person;

import java.util.Comparator;

public class QuickSort implements SortInterface {
    @Override
    public void sort(Person[] listOfPerson, Comparator<Person> c) {
        quickSort(listOfPerson, 0, listOfPerson.length - 1, c);
    }

    private void quickSort(Person[] listOfPerson, int low, int high, Comparator<Person> c) {
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
}
