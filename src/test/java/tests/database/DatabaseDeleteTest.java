package tests.database;

import java.sql.ResultSet;
import org.testng.Assert;
import org.testng.annotations.Test;
import database.DatabaseUtils;

public class DatabaseDeleteTest {

    @Test
    public void verifyDeleteOperation() throws Exception {

        int rowsAffected = DatabaseUtils.executeUpdate( "DELETE FROM users " +
                        "WHERE name='Vanya'");

        Assert.assertEquals(rowsAffected, 1);

        ResultSet resultSet = DatabaseUtils.executeSelect("SELECT * FROM users " +
                        "WHERE name='Vanya'");


        Assert.assertFalse(resultSet.next());
    }
}