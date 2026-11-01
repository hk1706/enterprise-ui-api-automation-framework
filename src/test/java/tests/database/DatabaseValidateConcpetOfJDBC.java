package tests.database;

import org.testng.annotations.Test;

import database.DatabaseUser;
import database.UserDatabaseHelper;
import org.testng.Assert;

public class DatabaseValidateConcpetOfJDBC {
    
    @Test
    public void verifyUserExistsInDatabase() throws Exception {
        Assert.assertTrue(UserDatabaseHelper.isUserPresent("Harsh"));
    }

    @Test
    public void verifyUserJob()
            throws Exception {

        Assert.assertEquals(
                UserDatabaseHelper
                        .getUserJob("Harsh"),
                "QA Engineer");
    }
    
    @Test
    public void verifyUserByPojo()
            throws Exception {

        DatabaseUser user =
                UserDatabaseHelper
                        .getUserByName("Harsh");

        Assert.assertEquals(
                user.getName(),
                "Harsh");

        Assert.assertEquals(
                user.getJob(),
                "QA Engineer");
    }
}
