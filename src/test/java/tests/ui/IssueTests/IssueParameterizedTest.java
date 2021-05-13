package tests.ui.IssueTests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import tests.ui.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static helpers.ExcelHelper.readExcelIssueTest;
import static helpers.FileHelper.readFile;

@RunWith(Parameterized.class)
public class IssueParameterizedTest extends BaseTest {
    private LoginPage loginPage;
    private String title;
    private String body;
    private List<String> labels;

    public IssueParameterizedTest(String title, String body, List<String> labels) {
        this.title = title;
        this.body = body;
        this.labels = labels;
    }

    @Before
    public void start() {
        loginPage = new LoginPage(driver);
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        String inputFile = System.getProperty("input.file", "excel");
        switch (inputFile) {
            case "file":
                List<Object[]> resultFile = new ArrayList<>();
                List<String> dataFromFile = readFile(
                        System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\issueCreationData");
                for (String line : dataFromFile) {
                    String[] temp = line.split(", ");
                    resultFile.add(new Object[]{temp[0], temp[1], Arrays.asList(temp[2].split("/ "))});
                }
                return resultFile;
            default:
                List<Object[]> resultExcel = readExcelIssueTest(
                        System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\IssueCreationData.xls",
                        "Лист1");
                return resultExcel;
        }
    }

    @Owner("Galchinskij")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("GH-4")
    @Description("Check issue creation Parameterized")
    @Stories({
            @Story("GitHub"),
            @Story("G48Automation")
    })
    @Feature("Issues creation Parameterized")
    @Issues({
            @Issue(""),
            @Issue("")
    })
    @DisplayName("")
    @Test
    public void checkIssueCreation() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .search("G48Automation")
                .openProjectG48FromSearch()
                .openIssueTab()
                .openCreationPage()
                .createNewIssue(this.title, this.body, this.labels)
                .validateIssue(this.title, this.body, this.labels)
                .logOut()
                .checkLogOut();
    }
}
