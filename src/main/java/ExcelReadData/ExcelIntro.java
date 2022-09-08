package ExcelReadData;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelIntro {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/LargeTestData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);

        //get whole excel structure
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        //get the sheet object using workbook
        Sheet sheet = workbook.getSheet("Sheet1");
        //get sheet using index number
        //Sheet sheet1 = workbook.getSheetAt(0);

        //Get the first row
        Row row1 = sheet.getRow(0);

        //get first cell object in the row
        row1.getCell(0);
        System.out.println(row1.getCell(0).toString());

        Assert.assertEquals(row1.getCell(0).toString(), "Policy");
        //get the last cell
        Cell cell = row1.getCell(row1.getLastCellNum());
        System.out.println(cell.toString());

        // Get all the rows
        for (int i =sheet.getFirstRowNum() ; i < sheet.getLastRowNum(); i++) {

            Row tempRow = sheet.getRow(i);
            // Validate none of the business fields are empty
            Cell tempCell = tempRow.getCell(7);
            System.out.println(tempCell);
            Assert.assertTrue(!tempCell.toString().equals("null"));
        }
// Get all the cells for a specific row
        Row row3 = sheet.getRow(2);
        for (int i = 0; i < row3.getLastCellNum(); i++) {
            Cell cell3 = row3.getCell(i);
            System.out.println(cell3);
        }

        List<Map<String,String>> excelTable = new ArrayList();
        for (int i =sheet.getFirstRowNum()+1; i < sheet.getLastRowNum() ; i++) {
            Row row = sheet.getRow(i);
            Row firstRow = sheet.getRow(0);
            Map<String,String> rowData = new HashMap<>();
            for (int j = row.getFirstCellNum(); j <row.getLastCellNum() ; j++) {
                Cell cell1= row.getCell(j);
                Cell fromFirstRow = firstRow.getCell(j);

                rowData.put(fromFirstRow.toString(),cell1.toString());
            }
            excelTable.add(rowData);
        }
        System.out.println("---- From The List Of Map ----");
        System.out.println(excelTable.get(35).get("Expiry"));

    }
}