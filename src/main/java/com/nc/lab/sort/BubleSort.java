package com.nc.lab.sort;

import com.nc.lab.model.Person;

import java.util.Comparator;

public class BubleSort implements SortInterface {
    @Override
    public void sort(Person[] listOfPerson, Comparator<Person> c) {
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
}
