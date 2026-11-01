package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UserDatabaseHelper {

    public static boolean isUserPresent(String name) throws SQLException {

        String query = "SELECT * FROM users WHERE name = ?";

        try (Connection connection =  DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, name);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public static String getUserJob(String name)  throws SQLException {

        String job = null;
        String query ="SELECT * FROM users WHERE name = ?";

        try (Connection connection =  DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                job = rs.getString("job");
            }
            return job;
        }
    }

    public static int getUserId(String name) throws SQLException {

        int id = -1;
        String query = "SELECT * FROM users WHERE name = ?";

        try (Connection connection =  DatabaseConnection.getConnection();
               
            PreparedStatement ps = connection.prepareStatement(query)) {
            
                ps.setString(1, name);

                ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                id = rs.getInt("id");
            }
            return id;
        }
    }

    public static DatabaseUser getUserByName(String name) throws SQLException {

        String query = "SELECT * FROM users WHERE name = ?";

        try (Connection connection =  DatabaseConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            DatabaseUser user = null;

            if (rs.next()) {

                user = new DatabaseUser();

                user.setId(rs.getInt("id"));

                user.setName(rs.getString("name"));

                user.setJob(rs.getString("job"));
            }
            return user;
        }
    
    }
}