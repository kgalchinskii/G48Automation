package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PomPage extends BaseAuthorizedPage {

    public PomPage(WebDriver driver) {
        super(driver);
    }

    private By seleniumVersion = By.xpath("//td[@id='LC49']");

    public PomPage displaySeleniumVersion() {
        Assert.assertEquals("3.141.59", driver.findElement(seleniumVersion).getText().replaceAll("[ <></>]+[a-zA-Z]+[</>]", ""));
        log.info("Selenium version: " + driver.findElement(seleniumVersion).getText().replaceAll("[ <></>]+[a-zA-Z]+[</>]", ""));
        return this;
    }

}
