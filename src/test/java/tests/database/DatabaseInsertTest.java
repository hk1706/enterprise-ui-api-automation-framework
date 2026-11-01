package tests.database;

import java.sql.ResultSet;
import org.testng.Assert;
import org.testng.annotations.Test;

import database.DatabaseUtils;

public class DatabaseInsertTest {

    @Test
    public void verifyInsertOperation() throws Exception {

        int rowsAffected = DatabaseUtils.executeUpdate("INSERT INTO users(name,job)" + "VALUES('Vanya', 'Student')");
        Assert.assertEquals(rowsAffected, 1);
        
        ResultSet rs =
            DatabaseUtils.executeSelect(
                    "SELECT * FROM users" +
                            " WHERE name='Vanya'");

        Assert.assertTrue(rs.next());

        Assert.assertEquals(
                rs.getString("name"),
                "Vanya");

        Assert.assertEquals(
                rs.getString("job"),
                "Student");

    }
}