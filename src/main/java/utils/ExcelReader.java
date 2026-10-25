package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static Object[][] getExecutableData(String filePath, String sheetName) {

        List<Object[]> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException(
                        "Worksheet '" + sheetName + "' was not found in: " + filePath
                                + ". Available worksheets: " + workbook.getSheetName(0));
            }

            DataFormatter formatter = new DataFormatter();
            int totalRows = sheet.getPhysicalNumberOfRows();

            // Start from row 1 (skip header)
            for (int i = 1; i < totalRows; i++) {
                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                String executeFlag = formatter.formatCellValue(
                    row.getCell(2, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL));

                // Only execute rows where Execute = Y
                if ("Y".equalsIgnoreCase(executeFlag)) {
                        String username = formatter.formatCellValue(
                            row.getCell(0, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL));
                        String password = formatter.formatCellValue(
                            row.getCell(1, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL));

                    dataList.add(new Object[] { username, password });
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read worksheet '" + sheetName
                    + "' from Excel file: " + filePath, e);
        }

        return dataList.toArray(new Object[0][]);
    }
}