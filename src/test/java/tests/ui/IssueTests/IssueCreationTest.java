package tests.ui.IssueTests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import tests.ui.BaseTest;

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

    @Owner("Galchinskij")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("GH-3")
    @Description("Check issue creation")
    @Stories({
            @Story("GitHub"),
            @Story("G48Automation")
    })
    @Feature("Issues creation")
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
                .createNewIssue("testTitle1", "testBody1", labels)
                .validateIssue("testTitle1", "testBody1", labels)
                .logOut()
                .checkLogOut();
    }

}
