package org.example;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args)
    {
        Person person1 = new Person("Ana", 30, "Bacau");
        Person person2 = new Person("Martina", 25, "Maramures");
        Person person3 = new Person("Ciprian", 39, "Bucuresti");
        Person person4 = new Person("David", 17, "Maramures");
        Person person5 = new Person("Emilia", 18, "Bacau");

        List <Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);


        List<Person> drivers = persons.stream()
                .filter(person -> person.getAge() >= 25)
                .collect(Collectors.toList());

        Set<Person> passengers = persons.stream()
                .filter(person -> person.getAge() < 25)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))));


        drivers.sort(Comparator.comparingInt(Person::getAge));


        System.out.println("Drivers:");
        for (Person driver : drivers) {
            System.out.println(driver);
        }

        System.out.println();
        System.out.println("Passengers:");
        for (Person passenger : passengers) {
            System.out.println(passenger);
        }
    }
}
