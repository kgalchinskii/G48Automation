package tests.ui;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

@Owner("Galchinskij")
@Severity(SeverityLevel.CRITICAL)
public class Tests extends BaseTest {

    private LoginPage loginPage;

    @Before
    public void start() {
        loginPage = new LoginPage(driver);
    }

    @TmsLink("GH-1")
    @Description("Check that selenium Version equals 3.141.59")
    @Stories({
            @Story("GitHub"),
            @Story("G48Automation")
    })
    @Feature("Selenium version")
    @Issues({
            @Issue(""),
            @Issue("")
    })
    @DisplayName("")
    @Test
    public void checkSeleniumVersion() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .search("G48Automation")
                .openProjectG48FromSearch()
                .openCodeTab()
                .openPomFile()
                .displaySeleniumVersion()
                .logOut()
                .checkLogOut();
    }

    @TmsLink("GH-2")
    @Description("Show project tabs")
    @Stories({
            @Story("GitHub"),
            @Story("G48Automation")
    })
    @Feature("Project tabs")
    @Issues({
            @Issue(""),
            @Issue("")
    })
    @DisplayName("")
    @Test
    public void displayTabs() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .search("G48Automation")
                .openProjectG48FromSearch()
                .displayTabs()
                .logOut()
                .checkLogOut();
    }

}
