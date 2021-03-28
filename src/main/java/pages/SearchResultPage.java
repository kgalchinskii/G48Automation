package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BaseAuthorizedPage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    private By repositoryLinkSearch = By.xpath("//a[@href = '/kgalchinskii/G48Automation']");

    public ProjectPage openProjectG48Search() {
        driver.findElement(repositoryLinkSearch).click();
        return new ProjectPage(driver);
    }

}