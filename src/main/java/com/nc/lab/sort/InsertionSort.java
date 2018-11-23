package com.nc.lab.sort;

import com.nc.lab.Person;

import java.util.Comparator;

public class InsertionSort implements SortInterface {
    @Override
    public void sort(Person[] listOfPerson, Comparator<Person> c) {
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
