package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DPQTrip {

    @DataProvider(name = "excelDataProvider")
    public Object[][] getData(int sheetIndex) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/test/resources/TestDataForQTrip.xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        int rows = sheet.getLastRowNum() + 1;
        int cols = sheet.getRow(0).getLastCellNum();

        List<Object[]> dataList = new ArrayList<>();

        for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);
            if (row != null) { // Check for null rows
                Object[] rowData = new Object[cols];
                boolean isEmptyRow = true;
                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) { // Check for null cells
                        DataFormatter formatter = new DataFormatter();
                        rowData[j] = formatter.formatCellValue(cell);
                        if (!rowData[j].toString().isEmpty()) {
                            isEmptyRow = false;
                        }
                    } else {
                        rowData[j] = ""; // Set empty string for null cells
                    }
                }
                if (!isEmptyRow) {
                    dataList.add(rowData);
                }
            }
        }
        return dataList.toArray(new Object[dataList.size()][]);
    }
}
