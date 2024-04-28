package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DataImporter {
    public void importBooks(String csvFilePath) throws SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String title = data[0];
                String author = data[1];
                String language = data[2];
                String publicationDate = data[3];
                int numberOfPages = Integer.parseInt(data[4]);

                BookDAO bookDAO = new BookDAO();
                bookDAO.addBook(title, author, language, publicationDate, numberOfPages);
            }
            System.out.println("Data imported successfully.");
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

}


