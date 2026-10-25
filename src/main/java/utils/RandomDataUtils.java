package utils;

import java.util.Random;

public class RandomDataUtils {
    
    private static Random random = new Random();
    
    public static String getRandomEmail() {
        return "testuser" 
            + random.nextInt(10000) 
            + "@gmail.com";
    }
    
    public static String getRandomUsername() {
        return "user" 
            + random.nextInt(10000);
    }
    
    public static String getRandomMobileNumber() {
        return "9" + (100000000 + random.nextInt(900000000));
    }
}