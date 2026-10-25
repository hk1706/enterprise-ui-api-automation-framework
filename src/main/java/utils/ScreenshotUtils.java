package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
    
    public static String captureScreenshot(WebDriver driver, String testName) {
        
        String path = "screenshots/" + 
                      testName + 
                      ".png";
                      
        System.out.println("Screenshot size : " + driver.manage().window().getSize());
        
        try {
            System.out.println("Title: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());
            
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            System.out.println("Source Screenshot Size = " + source.length());
            
            File destination = new File(path);
            
            destination.getParentFile().mkdirs();
            
            Files.copy(
                source.toPath(), 
                destination.toPath(), 
                StandardCopyOption.REPLACE_EXISTING
            );
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return new File(path).getAbsolutePath();
    }
}