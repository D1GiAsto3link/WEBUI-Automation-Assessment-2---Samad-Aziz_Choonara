package org.Magneto.utils;

import org.Magneto.Data.TestData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private static final String TEST_DATA_FILE = "src/test/resources/TestData.xlsx";
    private static final String TEST_CASES_SHEET = "Luma Test Cases";
    private static final String TEST_DATA_SHEET = "Luma Test Data";

    public static List<TestData> readTestData() throws IOException {
        List<TestData> testDataList = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(TEST_DATA_FILE);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet(TEST_DATA_SHEET);

        // Iterate over the rows and create TestData objects
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String productName = row.getCell(0).getStringCellValue();
            String firstName = row.getCell(1).getStringCellValue();
            String lastName = row.getCell(2).getStringCellValue();
            String email = row.getCell(3).getStringCellValue();

            TestData testData = new TestData(productName, firstName, lastName, email);
            testDataList.add(testData);
        }

        workbook.close();
        fileInputStream.close();
        return testDataList;
    }
}
