package org.example;

import java.sql.*;

public class Main
{
    public static void main(String[] args)
    {
        try {
            Connection connection = DatabaseManager.getConnection();
            Statement statement = connection.createStatement();

            createBooksTable(statement);

            AuthorDAO authorDAO= new AuthorDAO();
            authorDAO.addAuthor("Mihai Eminescu");

            BookDAO book1= new BookDAO();
            book1.addBook("Plumb", "George Bacovia", "Limba Romana", "1920-02-20", 1);

            statement.close();
            DatabaseManager.closeConnection();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
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

