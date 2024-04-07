package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int l = Integer.parseInt(JOptionPane.showInputDialog("Rows:"));
        int c = Integer.parseInt(JOptionPane.showInputDialog("Columns:"));

        JFrame frame = new JFrame("My game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100 * c, 100 * l);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawCircles(g);
                drawLines(g, l, c);
            }

            private void drawCircles(Graphics g) {
                int diameter = 50;
                for (int i = 0; i < l; i++) {
                    for (int j = 0; j < c; j++) {
                        int x = 50 + j * 100;
                        int y = 50 + i * 100;
                        g.setColor(Color.BLACK);
                        g.drawOval(x, y, diameter, diameter);
                    }
                }
            }

            private void drawLines(Graphics g, int rows, int columns) {
                int circleRadius = 50 / 2; // Radius of the circle
                Random random = new Random();

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        int x = 50 + j * 100 + circleRadius;
                        int y = 50 + i * 100 + circleRadius;

                        // Draw horizontal line
                        if (j < columns - 1) {
                            boolean thick = random.nextBoolean(); // Decide whether line should be thick or not
                            if (thick) {
                                Graphics2D g2d = (Graphics2D) g.create();
                                g2d.setStroke(new BasicStroke(3)); // Set thicker stroke
                                int nextX = 50 + (j + 1) * 100 + circleRadius;
                                g2d.drawLine(x, y, nextX, y);
                                g2d.dispose();
                            } else {
                                int nextX = 50 + (j + 1) * 100 + circleRadius;
                                g.drawLine(x, y, nextX, y);
                            }
                        }

                        // Draw vertical line
                        if (i < rows - 1) {
                            boolean thick = random.nextBoolean(); // Decide whether line should be thick or not
                            if (thick) {
                                Graphics2D g2d = (Graphics2D) g.create();
                                g2d.setStroke(new BasicStroke(3)); // Set thicker stroke
                                int nextY = 50 + (i + 1) * 100 + circleRadius;
                                g2d.drawLine(x, y, x, nextY);
                                g2d.dispose();
                            } else {
                                int nextY = 50 + (i + 1) * 100 + circleRadius;
                                g.drawLine(x, y, x, nextY);
                            }
                        }
                    }
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int mouseX = e.getX();
                int mouseY = e.getY();
                int diameter = 50;
                for (int i = 0; i < l; i++) {
                    for (int j = 0; j < c; j++) {
                        int x = 50 + j * 100;
                        int y = 50 + i * 100;
                        if (mouseX >= x && mouseX <= x + diameter && mouseY >= y && mouseY <= y + diameter) {
                            Graphics g = panel.getGraphics();
                            g.setColor(Color.BLACK);
                            g.fillOval(x, y, diameter, diameter);
                            g.dispose();
                            break;
                        }
                    }
                }
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
