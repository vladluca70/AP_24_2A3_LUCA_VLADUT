package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {
    private final Connection connection;

    public BookDAO() throws SQLException {
        try {
            this.connection = DatabaseManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // sau tratați aici, în funcție de nevoile dvs.
        }
    }


    public void addBook(String title, String author, String language, String publicationDate, int numberOfPages) {
        String query = "INSERT INTO books (title, author, language, publication_date, number_of_pages) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setString(3, language);
            statement.setString(4, publicationDate);
            statement.setInt(5, numberOfPages);
            statement.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId) {
        String query = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("No book found with the given id.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


