package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args)
    {
        /*
         * Clasa Faker pentru a genera random nume/prenume/adresa*/
        Faker faker= new Faker();

//        Person person1 = new Person(faker.name().firstName(), 30, faker.address().city());
//        Person person2 = new Person(faker.name().firstName(), 25, faker.address().city());
//        Person person3 = new Person(faker.name().firstName(), 39, faker.address().city());
//        Person person4 = new Person(faker.name().firstName(), 17, faker.address().city());
//        Person person5 = new Person(faker.name().firstName(), 18, faker.address().city());

        /*
        crearea de instante ale clase Person*/
        Person person1 = new Person(faker.name().firstName(), 30, "Romania");
        Person person2 = new Person(faker.name().firstName(), 25, "Belgia");
        Person person3 = new Person(faker.name().firstName(), 39, "Germania");
        Person person4 = new Person(faker.name().firstName(), 17, "Romania");
        Person person5 = new Person(faker.name().firstName(), 18, "Belgia");
        Person person6 = new Person(faker.name().firstName(), 18, "Romania");

        /*
        instantele clasei Person vor fi adaugate intr-o lista
        * Aceasta lista va fi necesara pentru stream*/
        List <Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);

        /*
        folosind un stream, cream o lista cu soferii(persoane peste 25 ani)*/
        List<Person> drivers = persons.stream()
                .filter(person -> person.getAge() >= 25)
                .collect(Collectors.toList());

        /*
        pasagerii vor fi cei cu varsta pana in 25 de ani*/
        Set<Person> passengers = persons.stream()
                .filter(person -> person.getAge() < 25)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))));


        drivers.sort(Comparator.comparingInt(Person::getAge));


//        System.out.println("Drivers:");
//        for (Person driver : drivers) {
//            System.out.println(driver);
//        }

//        System.out.println();
//        System.out.println("Passengers:");
//        for (Person passenger : passengers) {
//            System.out.println(passenger);
//        }

        /*
        cream o lista cu toate destinatiile pe care soferii le viziteaza*/
        List<String> allDestinations = persons.stream()
                .filter(person -> person.getAge() >= 25)
                .map(Person::getDestination)
                .collect(Collectors.toList());

        /*facem o mapare dintre orase si persoanele care vor sa viziteze orasele resprective
         * */
        Map<String, List<Person>> destinationMap = persons.stream()
                .collect(Collectors.groupingBy(
                        person -> person.getDestination()
                ));

        /*
         * afisare lista*/
        System.out.println("All the destinations that the drivers pass through: \n");
        for(String i: allDestinations)
            System.out.println(i);

        /*
         * afisare mapare*/
        System.out.println("\nDestinations and people who want to go there\n" );
        destinationMap.forEach((destination, people) -> {
            System.out.println(destination + ": " + people);
        });
    }
}

