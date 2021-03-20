package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.ProjectPage;
import pages.SearchPage;

public class SeleniumVersionTest extends BaseTest {

    private LoginPage loginPage;
    private SearchPage searchPage;
    private ProjectPage projectPage;

    @Before
    public void start(){
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        projectPage = new ProjectPage(driver);
    }

    @Test
    public void checkSeleniumVersion() {
        loginPage.login("kgalchinskii", "1993kostyan4ik");
        searchPage.search("G48Automation");
        projectPage.displaySeleniumVersion();
    }

}
