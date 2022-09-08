package ExcelReadData;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    private static Workbook workbook;
    private static Sheet sheet;
    private static Row row;

    public static boolean openTheExcelFile(String path) {
        try {


            File excelFile = new File(path);
            FileInputStream inputStream = new FileInputStream(excelFile);
            workbook = new HSSFWorkbook(inputStream);

        } catch (Exception e) {
            System.out.println("The path provided for excel file is not valid.");
            return false;
        }
        return true;
    }

    public static String getData(int sheetNumber, int lineNumber, String columnName) {
        sheet = workbook.getSheetAt(sheetNumber);
        List<Map<String, String>> excelTable = new ArrayList();
        for (int i = sheet.getFirstRowNum() + 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Row firstRow = sheet.getRow(0);
            Map<String, String> rowData = new HashMap<>();
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                Cell cell1 = row.getCell(j);
                Cell fromFirstRow = firstRow.getCell(j);

                rowData.put(fromFirstRow.toString(), cell1.toString());
            }
            excelTable.add(rowData);
        }
        System.out.println("---- From The List Of Map ----");
        System.out.println(excelTable.get(lineNumber).get(columnName));
        return excelTable.get(lineNumber).get(columnName);
    }

    public static Map<String, String> getRow(String sheetName, int lineNumber) {
        sheet = workbook.getSheet(sheetName);
        List<Map<String, String>> excelTable = new ArrayList();
        for (int i = sheet.getFirstRowNum() + 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Row firstRow = sheet.getRow(0);
            Map<String, String> rowData = new HashMap<>();
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                Cell cell1 = row.getCell(j);
                Cell fromFirstRow = firstRow.getCell(j);

                rowData.put(fromFirstRow.toString(), cell1.toString());
            }
            excelTable.add(rowData);
        }
        System.out.println("---- From The List Of Map ----");

        return excelTable.get(lineNumber);
    }

    public static String getData(String sheetName, int lineNumber, String columnName) {
        sheet = workbook.getSheet(sheetName);
        List<Map<String, String>> excelTable = new ArrayList();
        for (int i = sheet.getFirstRowNum() + 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Row firstRow = sheet.getRow(0);
            Map<String, String> rowData = new HashMap<>();
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                Cell cell1 = row.getCell(j);
                Cell fromFirstRow = firstRow.getCell(j);

                rowData.put(fromFirstRow.toString(), cell1.toString());
            }
            excelTable.add(rowData);
        }
        System.out.println("---- From The List Of Map ----");
        System.out.println(excelTable.get(lineNumber).get(columnName));
        return excelTable.get(lineNumber).get(columnName);
    }
}
