package com.nc.lab.sort;

import com.nc.lab.Person;

import java.util.Comparator;

public interface SortInterface {
    void sort(Person[] listOfPerson, Comparator<Person> c);
}
