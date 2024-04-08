package org.example;

public class Token {
    public int first;
    public int second;

    Token(int f, int s)
    {
        first=f;
        second=s;
    }

    public String toString()
    {
        return "("+first+", "+second+")";
    }

    public int getFirst() {
        return first;
    }

    public int getSecond()
    {
        return second;
    }
}



