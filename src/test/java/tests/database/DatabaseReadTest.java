package tests.database;


import java.sql.ResultSet;
import org.testng.Assert;
import org.testng.annotations.Test;
import database.DatabaseUtils;

public class DatabaseReadTest {

    @Test
    public void verifyReadData() throws Exception {

        ResultSet resultSet = DatabaseUtils.executeSelect("SELECT * FROM users");

        while (resultSet.next()) {

            int id =
                    resultSet.getInt("id");

            String name =
                    resultSet.getString("name");

            String job =
                    resultSet.getString("job");

            System.out.println(
                    id + " | " +
                    name + " | " +
                    job);

            Assert.assertNotNull(name);
            Assert.assertNotNull(job);
        }
    }
}