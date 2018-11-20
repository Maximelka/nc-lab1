package com.nc.lab;

import org.joda.time.LocalDate;

public class MainApp {

    public static void main(final String... args) {
        Person p1 = new Person("A", "male", new LocalDate(1997, 2, 1));
        Person p2 = new Person("C", "male", new LocalDate(1996, 1, 1));
        Person p3 = new Person("B", "male", new LocalDate(1997, 3, 1));

        Repository repository = new Repository(3);

        repository.addPerson(p1);
        repository.addPerson(p2);
        repository.addPerson(p3);

        repository.sort(Person.NameComparator);
        System.out.printf(repository.toString());
        System.out.printf("====================================================\n");
        repository.sort(Person.AgeComparator);
        System.out.printf(repository.toString());
        System.out.printf("====================================================\n");
        repository.sort(Person.BirthdayComparator);
        System.out.printf(repository.toString());
        System.out.printf("====================================================\n");

        repository.find(21,Person.CheckAge);
    }
}
