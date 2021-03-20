package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage{

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    private By pomXml = By.xpath("//a[@title='pom.xml']");
    private By seleniumVersion = By.xpath("//td[@id='LC44']");

    public void displaySeleniumVersion() {
        driver.findElement(pomXml).click();
        Assert.assertEquals("3.141.59", driver.findElement(seleniumVersion).getText().replaceAll("[ <></>]+[a-zA-Z]+[</>]", ""));
        log.info("Selenium version: " + driver.findElement(seleniumVersion).getText().replaceAll("[ <></>]+[a-zA-Z]+[</>]", ""));
    }

}