package org.example;

import java.awt.*;
public class Main {
    public static void main ( String args []) {
        Frame f = new Frame("Grid Layout");
        f.setLayout (new GridLayout (3, 2));
        Button b1 = new Button (" Button 1");
        Button b2 = new Button ("2");
        Button b3 = new Button (" Button 3");
        Button b4 = new Button ("Long - Named Button 4");
        Button b5 = new Button (" Button 5");
        f.add(b1); f.add (b2); f. add(b3); f.add(b4); f.add(b5);
        f.pack ();
        f.setVisible(true);
    }
}