package utils;

import java.time.*;
import java.time.format.*;

public class DateUtils {
    
    public static String getTimeStamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
        LocalTime currentTime = LocalTime.now();
        return currentTime.format(formatter);
    }
}
