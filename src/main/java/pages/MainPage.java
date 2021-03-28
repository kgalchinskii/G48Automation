package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BaseAuthorizedPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By repositoryLinkHistory = By.xpath("//span[@title = 'G48Automation_galchinskii']");

    public ProjectPage openProjectG48FromHistory() {
        driver.findElements(repositoryLinkHistory).get(0).click();
        return new ProjectPage(driver);
    }

}
