package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeKeeper extends Thread {
    private boolean running = true;
    private long startTime;

    @Override
    public void run()
    {
        startTime = System.currentTimeMillis();

        while (running) {
            try {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime;

                // Converteste timpul in minute si secunde
                long minutes = (elapsedTime / 1000) / 60;
                long seconds = (elapsedTime / 1000) % 60;

                // Afiseaza timpul sub forma de contor
                System.out.printf("Time: %02d:%02d%n", minutes, seconds);

                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Oprire thread
    public void stopTime() {
        running = false;
    }
}
