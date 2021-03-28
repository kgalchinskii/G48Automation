package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BaseAuthorizedPage extends BasePage {

    public BaseAuthorizedPage(WebDriver driver) {
        super(driver);
    }

    private By searchField = By.name("q");
    private By searchButton = By.id("jump-to-suggestion-search-global");

    private By userProfileButton = By.xpath("//summary[@aria-label = 'View profile and more']");
    private By logOut = By.xpath("//button[@class = 'dropdown-item dropdown-signout']");

    public SearchResultPage search(String repTitle) {
        driver.findElement(searchField).sendKeys(repTitle);
        waitFor25.until(ExpectedConditions.visibilityOf(driver.findElement(searchButton))).click();
        return new SearchResultPage(driver);
    }

    public HomePage logOut() {
        driver.findElement(userProfileButton).click();
        waitFor25.until(ExpectedConditions.visibilityOf(driver.findElement(logOut))).click();
        return new HomePage(driver);
    }

}
