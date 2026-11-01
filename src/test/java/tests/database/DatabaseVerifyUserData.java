package tests.database;

import org.testng.annotations.Test;

import database.DatabaseUser;
import database.UserDatabaseHelper;
import org.testng.Assert;

public class DatabaseVerifyUserData {
    
    @Test
    public void verifyUserData()
            throws Exception {

        DatabaseUser user = UserDatabaseHelper.getUserByName("Harsh");
        
        System.out.println(user.getId());
        System.out.println(user.getJob());
        System.out.println(user.getName());

        Assert.assertNotNull(user);

        Assert.assertEquals(
                user.getName(),
                "Harsh");

        Assert.assertEquals(
                user.getJob(),
                "QA Engineer");
    }

}
