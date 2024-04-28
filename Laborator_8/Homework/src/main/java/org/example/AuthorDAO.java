package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDAO {
    private final Connection connection;


    public AuthorDAO() throws SQLException {
        try {
            this.connection = DatabaseManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // sau tratați aici, în funcție de nevoile dvs.
        }
    }


    public void addAuthor(String name) {
        String query = "INSERT INTO books (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Author added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAuthor(int id) {
        String query = "DELETE FROM authors WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Author deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



