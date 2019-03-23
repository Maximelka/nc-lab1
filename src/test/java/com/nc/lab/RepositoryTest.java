package com.nc.lab;

import com.nc.lab.model.Person;
import com.nc.lab.model.Repository;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class RepositoryTest {

    @Test
    public void addPerson() {
        Person p = new Person("1", "male", new LocalDate(2000, 12, 31));
        Repository repository = new Repository();
        repository.addPerson(p);
        int expected = repository.getListOfPerson().length;
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deletePerson_1() {
        Person p = new Person("1", "male", new LocalDate(2000, 12, 31));
        Repository repository = new Repository();
        repository.addPerson(p);
        int actual = repository.getListOfPerson().length;
        repository.deletePerson(10);
        int expected = repository.getListOfPerson().length;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deletePerson_2() {
        Person p = new Person("1", "male", new LocalDate(2000, 12, 31));
        Repository repository = new Repository();
        repository.addPerson(p);
        int actual = repository.getListOfPerson().length - 1;
        repository.deletePerson(1);
        int expected = repository.getListOfPerson().length;
        Assert.assertEquals(expected, actual);
    }
/*
    @Test
    public void search() {
        Person p = new Person("1", "male", new LocalDate(2000, 12, 31));
        Repository repository = new Repository();
        repository.addPerson(p);
        Person p4 = new Person("4", "male", new LocalDate(2000, 12, 31));
        repository.addPerson(p4);
        Person[] expected = repository.search("4", Person.CheckName);
        Person[] actual = new Person[]{p4};
        Assert.assertEquals(expected, actual);
    }*/

    @Test
    public void sort() {
        Person p1 = new Person("1", "male", new LocalDate(2000, 12, 31));
        Person p2 = new Person("3", "male", new LocalDate(2000, 12, 31));
        Person p3 = new Person("2", "male", new LocalDate(2000, 12, 31));
        Repository repository = new Repository();
        repository.addPerson(p1);
        repository.addPerson(p2);
        repository.addPerson(p3);
        repository.sort(Person.NameComparator);
        Person[] expected = repository.getListOfPerson();
        Person[] actual = new Person[]{p1, p3, p2};
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getOfPerson() {
        Repository repository = new Repository();
        Person expected = repository.getOfPerson(1);
        Assert.assertNotNull(expected);
    }
}