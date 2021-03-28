package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By loginField = By.name("login");
    private By passwordField = By.name("password");
    private By submitButton = By.name("commit");

    public MainPage login(String username, String password) {
        driver.findElement(loginField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        return new MainPage(driver);
    }

}