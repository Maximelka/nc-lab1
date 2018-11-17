package com.nc.lab;

import org.joda.time.LocalDate;

public class MainApp {

    public static void main(final String... args) {
        Person p1 = new Person("Max1", "male", new LocalDate(1997, 10, 21));
        Person p2 = new Person("Max2", "male", new LocalDate(1997, 10, 21));
        Person p3 = new Person("Max3", "male", new LocalDate(1997, 10, 21));
        //Repository repository = new Repository();
    }
}
