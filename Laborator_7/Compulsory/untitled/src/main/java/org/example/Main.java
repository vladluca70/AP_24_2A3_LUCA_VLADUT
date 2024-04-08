package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int n=6;
        Bag bag= new Bag(n);

        Player thread1= new Player("user1", bag, n);
        Player thread2= new Player("user2", bag, n);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}


