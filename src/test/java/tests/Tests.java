package tests;

import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class Tests extends BaseTest {

    private LoginPage loginPage;

    @Before
    public void start(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void checkSeleniumVersion() {
        loginPage.login("", "")
        .search("G48Automation")
        .openProjectG48Search()
        .openPomFile()
        .displaySeleniumVersion()
        .logOut()
        .checkLogOut();
    }

    @Test
    public void displayTabs(){
        loginPage.login("", "")
                .search("G48Automation")
                .openProjectG48Search()
                .displayTabs()
                .logOut()
                .checkLogOut();
    }

}
