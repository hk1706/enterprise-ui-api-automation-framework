package tests.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.testng.Assert;
import org.testng.annotations.Test;

import database.DatabaseConnection;

public class DatabasePreparedStatementTest {

    @Test
    public void verifyPreparedStatement() throws Exception {

        Connection connection =
                DatabaseConnection.getConnection();

        String query =
                "SELECT * FROM users WHERE name = ?";

        PreparedStatement ps =
                connection.prepareStatement(query);

        ps.setString(1, "Harsh");

        ResultSet rs =
                ps.executeQuery();

        Assert.assertTrue(rs.next());

        Assert.assertEquals(
                rs.getString("name"),
                "Harsh");

        Assert.assertEquals(
                rs.getString("job"),
                "QA Engineer");

        connection.close();
    }
}