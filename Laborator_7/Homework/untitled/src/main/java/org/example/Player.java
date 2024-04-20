package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Player extends Thread {
    private Semaphore semaphore;
    private Bag bag;
    private List<Token> userSequence;
    private String userName;
    private int n;
    private int points;

    /*construnctor
     * */
    Player(String nUser, Bag b, int nr) {
        userName = nUser;
        bag = b;
        n = nr;
        points = 0;
        userSequence = new ArrayList<>();
    }

    /*verificam daca avem closed sequence*/
    private boolean isClosedSequence() {
        if (userSequence.size() < 2) {
            return false;
        }
        Token lastToken = userSequence.get(userSequence.size() - 1);
        Token firstToken = userSequence.get(0);
        return lastToken.second == firstToken.first;
    }

    /*metoda pentru a afisa in main cate puncte are fiecare jucator
     * dupa ce s-au terminat thread-urile de executat*/
    public int getPoints(){
        return points;
    }

    public void run() {
        int ok = 1;
        while (ok == 1) {
            try {
                Token token = bag.extractToken();
                /*dupa ce am extras un token din punga, ne asiguram daca punga
                 * mai avea tokeni sau era goala*/
                if (token == null || userSequence.size() == n) {
                    ok = 0;
                    break;
                }
                System.out.println(userName + " got the token " + token);
                /*adaugam tokenul extras in lista de tokeni a jucatorului respectiv*/
                userSequence.add(token);
                if (isClosedSequence())
                {
                    points = Math.max(points, userSequence.size());
                    userSequence.clear();
                }
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
}

