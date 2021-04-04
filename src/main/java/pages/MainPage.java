package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BaseAuthorizedPage {

    private static final String title = "Основная страница приложения";

    public MainPage(WebDriver driver) {
        super(driver, title);
    }

    private By repositoryLinkHistory = By.xpath("//span[@title = 'G48Automation_galchinskii']");

    public BaseProjectPage openProjectG48FromHistory() {
        log.debug("Открываем проект по ссылке в истории");
        driver.findElements(repositoryLinkHistory).get(0).click();
        log.debug("Проект открыт. Успешно");
        return new BaseProjectPage(driver, "Основная страница проекта");
    }

}
