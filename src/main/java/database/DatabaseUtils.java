package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtils {

    public static ResultSet executeSelect(String query) throws Exception {

        Connection connection = DatabaseConnection.getConnection();

        Statement statement = connection.createStatement();

        return statement.executeQuery(query);
    }

    public static int executeUpdate(String query) throws Exception {

        Connection connection = DatabaseConnection.getConnection();

        Statement statement = connection.createStatement();

        return statement.executeUpdate(query);
    }
}