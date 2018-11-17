package com.nc.lab;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void getAge1() {
        Person p1 = new Person("1", "male", new LocalDate(2000, 12, 31));
        int expected = p1.getAge();
        int actual = 17;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAge2() {
        Person p1 = new Person("1", "male", new LocalDate(2000, 1, 1));
        int expected = p1.getAge();
        int actual = 18;
        Assert.assertEquals(expected, actual);
    }
}