package tests.ui;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static helpers.PropertyLoader.loadProperty;
import static java.lang.Integer.parseInt;

public abstract class BaseTest {

    protected WebDriver driver;

    @Before
    public void init() {
        String browserName = System.getProperty("browser", "chrome");
        switch (browserName) {
            case "firefox":
                this.driver = new FirefoxDriver();
                break;
            default:
                this.driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(
                parseInt(loadProperty("timeout.implicit")),
                TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(loadProperty("app.url"));
    }

    @After
    public void exit() {
        driver.quit();
    }

}
