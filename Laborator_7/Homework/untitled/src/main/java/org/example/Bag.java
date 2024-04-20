package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.Random;

public class Bag {
    private List<Token> tokens;
    private Semaphore semaphore;

    /*constructor
     * are rolul de a genera toate tokenurile posibile*/
    public Bag(int n)
    {
        semaphore = new Semaphore(n);
        tokens = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (i != j) {
                    tokens.add(new Token(i, j));
                }
            }
        }
    }

    public Token extractToken() throws InterruptedException
    {
        /*pentru a extrage fiecare jucator cate un token pe rand, follosim un lacat*/
        semaphore.acquire();
        Token token = null;
        synchronized (tokens)
        {
            /*tokenii vor fi extrasi in mod random*/
            if (!tokens.isEmpty())
            {
                Random random = new Random();
                int index = random.nextInt(tokens.size());
                token = tokens.remove(index);
            }
        }
        semaphore.release();
        return token;
    }
}

