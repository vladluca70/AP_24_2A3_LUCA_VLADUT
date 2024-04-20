package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        /*
         * rulam in background un thread daemon care indica timpul*/
        TimeKeeper timer= new TimeKeeper();
        timer.setDaemon(true);
        timer.start();

        int n=6;
        Bag bag= new Bag(n);

        Player thread1= new Player("user1", bag, n);
        Player thread2= new Player("user2", bag, n);
        Player thread3= new Player("user3", bag, n);
        Player thread4= new Player("user4", bag, n);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        timer.stopTime();

        System.out.println("User1 has "+ thread1.getPoints()+ " points");
        System.out.println("User2 has "+ thread2.getPoints()+ " points");
        System.out.println("User3 has "+ thread3.getPoints()+ " points");
        System.out.println("User4 has "+ thread4.getPoints()+ " points");
    }
}


