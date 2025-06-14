package com.digitalbank.automation.utils;

import com.digitalbank.automation.config.ConfigsReader;

import java.sql.*;

public class DBUtils {

    private static Connection connection;

    /**
     * Establishes a database connection using values from general-configs.yaml.
     */
    public static void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            var db = ConfigsReader.getConfig().dbUrl;
            connection = DriverManager.getConnection(db.url, db.username, db.password);
        }
    }

    /**
     * Executes a SELECT query and returns a ResultSet.
     *
     * @param query SQL SELECT query
     * @return ResultSet containing query results
     * @throws SQLException on DB error
     */
    public static ResultSet executeQuery(String query) throws SQLException {
        connect();
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    /**
     * Executes an INSERT, UPDATE, or DELETE query.
     *
     * @param query SQL update query
     * @return number of affected rows
     * @throws SQLException on DB error
     */
    public static int executeUpdate(String query) throws SQLException {
        connect();
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    /**
     * Closes the database connection, if open.
     */
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
