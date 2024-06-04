package org.example;

import java.sql.*;

public class AuthorDAO
{
    private final Connection connection;

    public AuthorDAO()
    {
        this.connection = DatabaseManager.getConnection();
    }

    public void addAuthor(String name)
    {
        String query = "INSERT INTO books (title, author) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setString(1, "");
            statement.setString(2, name);
            statement.executeUpdate();
            System.out.println("Author added successfully.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteAuthor(int id)
    {
        String query = "DELETE FROM author WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Author deleted successfully.");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}


