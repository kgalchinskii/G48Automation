package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private By searchField = By.name("q");
    private By searchButton = By.id("jump-to-suggestion-search-global");
    private By repository = By.xpath("//a[contains(text(), 'BKuso')]");

    public void search(String repTitle) {
        driver.findElement(searchField).sendKeys(repTitle);
        driver.findElement(searchButton).click();
        driver.findElement(repository).click();
    }

}