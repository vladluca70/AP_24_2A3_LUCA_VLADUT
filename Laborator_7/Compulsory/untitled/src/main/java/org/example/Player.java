package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Player extends Thread
{
    private Semaphore semaphore;
    private Bag bag;
    private List<Token> userSequence;
    private String userName;
    private int n;
    private int points;
    Player(String nUser, Bag b, int nr)
    {
        userName=nUser;
        bag=b;
        n=nr;
        points=0;
        userSequence=new ArrayList<>();
    }

    private boolean isClosedSequence()
    {
        if (userSequence.size() < 2) {
            return false;
        }
        Token lastToken = userSequence.get(userSequence.size() - 1);
        Token firstToken = userSequence.get(0);
        return lastToken.second == firstToken.first;
    }

    public void run()
    {
        int ok=1;
        while (ok==1)
        {
            try {
                Token token = bag.extractToken();
                if (token == null || userSequence.size() == n)
                {
                    ok=0;
                    break;
                }
                userSequence.add(token);
                if (isClosedSequence())
                {
                    points = Math.max(points, userSequence.size());
                    userSequence.clear();
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(userName + " finished with " + points + " points.");
    }
}


