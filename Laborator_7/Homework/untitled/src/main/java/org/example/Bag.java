package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.Random;
public class Bag  extends Thread{
    public List<Token> tokens;
    private Semaphore semaphore;
    public Bag(int n)
    {
        semaphore=new Semaphore(n);
        tokens = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (i != j)
                    tokens.add(new Token(i, j));

    }

    Token extractToken() throws InterruptedException
    {
        semaphore.acquire();
        if (tokens.isEmpty())
        {
            semaphore.release();
            return null;
        }
        Random random = new Random();
        if(tokens.size()>=1)
        {
            int index = random.nextInt(tokens.size() - 1);
            Token token = tokens.remove(index);
            semaphore.release();
            return token;
        }
        else
        {
            return  null;
        }
    }
}


