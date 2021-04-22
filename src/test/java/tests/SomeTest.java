package tests;

import org.junit.Test;

import static helpers.ExcelHelper.readDataFromExcelFile;
import static helpers.ExcelHelper.writeToExcelFileAndGet;

public class SomeTest {

    @Test
    public void someExcel(){
        writeToExcelFileAndGet("D:\\QAlight\\G48_Automation_Galchinskij\\src\\test\\resources\\testData\\Лист Microsoft Excel.xlsx",
                readDataFromExcelFile("D:\\QAlight\\G48_Automation_Galchinskij\\src\\test\\resources\\testData\\IssueCreationData.xls", "Лист1"));
    }

}