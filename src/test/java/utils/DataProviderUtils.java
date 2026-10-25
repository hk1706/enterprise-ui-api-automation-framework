package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        
        String filePath = 
            "src/test/resources/testdata/LoginData.xlsx";
            
        // The current LoginData.xlsx workbook names its populated worksheet "Sheet1".
        String sheetName = "Sheet1";
        
        return ExcelReader.getExecutableData(filePath, sheetName);
    }
}