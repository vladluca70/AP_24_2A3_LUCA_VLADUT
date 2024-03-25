package org.example;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner= new Scanner(System.in);
        String path;
        path=scanner.nextLine();
        //path="C:\\manager"

        Director repo = new Director(path);
        repo.displayComponents();

        scanner.close();
    }
}
