package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DatabaseManager.getConnection();
            Statement statement = connection.createStatement();

            createBooksTable(statement);


            DataImporter dataImporter = new DataImporter();
            dataImporter.importBooks("D://books.csv");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection);
        }
    }

    private static void createBooksTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS books (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "title VARCHAR(255) NOT NULL," +
                "author VARCHAR(255) NOT NULL," +
                "language VARCHAR(50)," +
                "publication_date DATE," +
                "number_of_pages INT" +
                ")";
        statement.executeUpdate(createTableQuery);
        System.out.println("Table 'books' created successfully.");
    }
}


