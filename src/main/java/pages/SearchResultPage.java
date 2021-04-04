package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BaseAuthorizedPage {

    private static final String title = "Страница результатов поиска";

    public SearchResultPage(WebDriver driver) {
        super(driver, title);
    }

    private By repositoryLinkSearch = By.xpath("//a[@href = '/kgalchinskii/G48Automation']");

    public BaseProjectPage openProjectG48FromSearch() {
        log.debug("Открываем проект");
        driver.findElement(repositoryLinkSearch).click();
        log.debug("Проект открыт. Успешно");
        return new BaseProjectPage(driver, "Основная страница проекта");
    }

}