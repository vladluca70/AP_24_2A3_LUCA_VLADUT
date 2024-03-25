package org.example;

import com.github.javafaker.Faker;
import org.graph4j.generate.GraphGenerator;
import org.graph4j.*;
import org.graph4j.util.CheckArguments;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args)
    {
        Faker faker= new Faker();
        Random random= new Random();

        Graph graph = GraphGenerator.randomGnp(10000, 0.1);

        int drivers=0;
        int passengers=0;
        int age;

        for(int i=1; i<=10000; i++)
        {
            if((drivers<=5000) && (passengers<=5000))
                age=random.nextInt(101);
            else
                if(drivers<=5000)
                    age=random.nextInt(83) + 18;
                else
                    age=random.nextInt(18);

            Person p= new Person(faker.name().firstName(), age, faker.address().city());
            graph.addVertex(i,p);
        }

        int [][]array= graph.adjacencyMatrix();

       for(int i=1; i<=10000; i++)
        {
            int []x=graph.neighbors(i);

        }


    }
}



