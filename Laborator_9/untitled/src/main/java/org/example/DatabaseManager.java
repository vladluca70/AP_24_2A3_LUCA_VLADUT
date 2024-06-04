package org.example;

import java.sql.*;

public class DatabaseManager
{
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/book_schema";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Iasi*2024";

    private static Connection connection;

    private DatabaseManager() {
    }

    public static Connection getConnection() {
        if (connection == null)
        {
            try
            {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection()
    {
        if (connection != null) {
            try
            {
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}

