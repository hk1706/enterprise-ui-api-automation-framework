package tests.database;


import java.sql.ResultSet;
import org.testng.Assert;
import org.testng.annotations.Test;
import database.DatabaseUtils;

public class DatabaseUpdateTest {

    @Test
    public void verifyUpdateOperation() throws Exception {

        int rowsAffected = DatabaseUtils.executeUpdate(  "UPDATE users " +
                        "SET job='Senior QA Engineer' " +
                        "WHERE name='Vanya'");

        Assert.assertEquals(rowsAffected, 1);

        ResultSet resultSet = DatabaseUtils.executeSelect("SELECT * FROM users " +
                        "WHERE name='Vanya'");

        Assert.assertTrue(resultSet.next());

        Assert.assertEquals(
                resultSet.getString("job"),
                "Senior QA Engineer");

    }
}