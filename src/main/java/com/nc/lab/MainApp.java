package com.nc.lab;

import com.nc.lab.model.Person;
import com.nc.lab.model.Repository;
import com.nc.lab.reflection.InjectAnnotationAnalyzer;
import org.joda.time.LocalDate;

public class MainApp {

    public static void main(final String... args) throws Exception{
        InjectAnnotationAnalyzer analyzer = new InjectAnnotationAnalyzer();
        analyzer.parse(Repository.class);

        Person p1 = new Person("A", "male", new LocalDate(1997, 2, 1));
        Person p2 = new Person("C", "male", new LocalDate(1996, 1, 1));
        Person p3 = new Person("B", "male", new LocalDate(1997, 3, 1));

        Repository repository1 = new Repository();

        repository1.addPerson(p1);
        repository1.addPerson(p2);
        repository1.addPerson(p3);

        repository1.getOfPerson(5);

       /* repository1.sort(Person.NameComparator);
        System.out.printf(repository1.toString());
        System.out.printf("====================================================\n");
        repository1.sort(Person.AgeComparator);
        System.out.printf(repository1.toString());
        System.out.printf("====================================================\n");
        repository1.sort(Person.BirthdayComparator);
        System.out.printf(repository1.toString());
        System.out.printf("====================================================\n");

        repository1.search(21, Person.CheckAge);

        for (Person person : repository1.search(21, Person.CheckAge)) {
            System.out.printf(person.toString());
        }
        Repository repository2 = new Repository(new QuickSort());
        repository2.addPerson(p1);
        repository2.addPerson(p2);
        repository2.addPerson(p3);
        repository1.sort(Person.NameComparator);
        System.out.printf(repository1.toString());
        System.out.printf("====================================================\n");

        Repository repository3 = new Repository(new InsertionSort());
        repository3.addPerson(p1);
        repository3.addPerson(p2);
        repository3.addPerson(p3);
        repository1.sort(Person.NameComparator);
        System.out.printf(repository1.toString());
        System.out.printf("====================================================\n");*/
    }
}
