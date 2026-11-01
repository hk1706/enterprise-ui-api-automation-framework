package tests.database;

import java.sql.Connection;

import org.testng.Assert;
import org.testng.annotations.Test;

import database.DatabaseConnection;

public class DatabaseConnectionTest {

    @Test
    public void verifyDatabaseConnection() {

        try {

            Connection connection = DatabaseConnection.getConnection();

            Assert.assertNotNull(connection);

            System.out.println("Database Connection Successful");
        } catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException(
                    "Database connection failed", e);
        }

    }
}