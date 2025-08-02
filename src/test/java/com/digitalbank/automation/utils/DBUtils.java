package com.digitalbank.automation.utils;

import com.digitalbank.automation.config.ConfigsReader;

import java.sql.*;

public class DBUtils {

    private static Connection connection;

    public static void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            var db = ConfigsReader.getConfig().dbUrl;
            connection = DriverManager.getConnection(db.url, db.username, db.password);
        }
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        connect();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public static int executeUpdate(String query) throws SQLException {
        connect();
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // or use logger
        }
    }
}
