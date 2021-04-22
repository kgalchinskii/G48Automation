package tests.IssueTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import tests.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static helpers.FileHelper.readFile;

@RunWith(Parameterized.class)
public class IssueFileTest extends BaseTest {

    private LoginPage loginPage;
    private String title;
    private String body;
    private List<String> labels;

    public IssueFileTest(String title, String body, List<String> labels){
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
        List<Object[]> result = new ArrayList<>();
        List<String> dataFromFile = readFile(
                "D:\\QAlight\\G48_Automation_Galchinskij\\src\\test\\resources\\testData\\issueCreationData");
        for (String line : dataFromFile){
            String[] temp = line.split(", ");
            result.add(new Object[]{temp[0], temp[1], Arrays.asList(temp[2].split("/ "))});
        }
        return result;
    }

    @Test
    public void checkIssueCreation() {
        loginPage.login("kgalchinskii", "1993kostyan4ik")
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
