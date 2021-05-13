package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelHelper {

    private static final Logger log = LogManager.getLogger("Обработчик Excel");

    public static List<List<String>> readDataFromExcelFile(String path, String sheetName) {
        List<List<String>> result = new ArrayList<>();
        try {
            HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(path));
            Sheet sheet = book.getSheet(sheetName);
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                List<String> rowData = new ArrayList<>();
                for (int a = 0; a < row.getLastCellNum(); a++) {
                    Cell cell = row.getCell(a);
                    rowData.add(
                            cellIsString(cell)
                                    ? cell.getStringCellValue()
                                    : String.valueOf(cell.getNumericCellValue()));
                }
                result.add(rowData);
            }
        } catch (IOException e) {
            log.error(e);
        }
        return result;
    }

    public static List<Object[]> readExcelIssueTest(String path, String sheetName) {
        List<Object[]> result = new ArrayList<>();
        try {
            HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(path));
            Sheet sheet = book.getSheet(sheetName);
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String[] temp = new String[2];
                List<String> labels = new ArrayList<>();
                for (int a = 0; a < row.getLastCellNum(); a++) {
                    Cell cell = row.getCell(a);
                    switch (a) {
                        case 0:
                        case 1:
                            temp[a] = cellIsString(cell)
                                    ? cell.getStringCellValue()
                                    : String.valueOf(cell.getNumericCellValue());
                            break;
                        default:
                            labels.add(cellIsString(cell)
                                    ? cell.getStringCellValue()
                                    : String.valueOf(cell.getNumericCellValue()));
                    }
                }
                result.add(new Object[]{temp[0], temp[1], labels});
            }
        } catch (IOException e) {
            log.error(e);
        }
        return result;
    }

    public static File writeToExcelFileAndGet(String path, List<List<String>> data) {
        File input = new File(path);
        File parent = input.getParentFile();
        try {

            Workbook file = new XSSFWorkbook(path);
            Sheet sheet = file.createSheet("Automated Sheet");
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i);
                for (int a = 0; a < data.get(i).size(); a++) {
                    Cell cell = row.createCell(a);
                    cell.setCellValue(data.get(i).get(a));
                }
            }
            FileOutputStream stream = new FileOutputStream(new File(parent, "output.xlsx"));
            stream.flush();
            file.write(stream);
            file.close();
        } catch (IOException e) {
            log.error(e);
        }
        return input;
    }

    private static boolean cellIsString(Cell cell) {
        return cell.getCellType() == CellType.STRING;
    }

}