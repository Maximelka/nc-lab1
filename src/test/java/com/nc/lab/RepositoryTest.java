package com.nc.lab;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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
    public void deletePerson() {
        Person p1 = new Person("1", "male", new LocalDate(2000, 12, 31));
        Person p2 = new Person("2", "male", new LocalDate(2000, 12, 31));
        Repository repository = new Repository();
        repository.addPerson(p1);
        repository.addPerson(p2);
        repository.deletePerson(1);
    }

    @Test
    public void search() {
    }

    @Test
    public void sort() {
    }

    @Test
    public void getOfPerson() {
        Repository repository = new Repository();
        Person expected = repository.getOfPerson(1);
        Assert.assertNotNull(expected);
    }
}