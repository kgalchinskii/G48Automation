package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final String title = "Страница авторизации";

    public LoginPage(WebDriver driver) {
        super(driver, title);
    }

    private By loginField = By.name("login");
    private By passwordField = By.name("password");
    private By submitButton = By.name("commit");

    public MainPage login(String username, String password) {
        log.debug("Производится авторизация...");
        driver.findElement(loginField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        log.debug("Авторизация успешна");
        return new MainPage(driver);
    }

}