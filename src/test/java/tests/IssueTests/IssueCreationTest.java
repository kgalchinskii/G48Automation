package tests.IssueTests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import tests.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class IssueCreationTest extends BaseTest {

    private LoginPage loginPage;
    private List<String> labels = new ArrayList<>();

    @Before
    public void start() {
        loginPage = new LoginPage(driver);
        labels.add("bug");
        labels.add("invalid");
    }

    @Test
    public void checkIssueCreation() {
        loginPage.login("kgalchinskii", "1993kostyan4ik")
                .search("G48Automation")
                .openProjectG48FromSearch()
                .openIssueTab()
                .openCreationPage()
                .createNewIssue("testTitle1", "testBody1", labels)
                .validateIssue("testTitle1", "testBody1", labels)
                .logOut()
                .checkLogOut();
    }

}
