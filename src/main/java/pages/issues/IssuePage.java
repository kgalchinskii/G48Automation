package pages.issues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseProjectPage;

public class IssuePage extends BaseProjectPage {

    private static final String title = "Список задач проекта";

    public IssuePage(WebDriver driver) {
        super(driver, title);
    }

    private By newIssueButton = By.xpath("//span[text() = 'New issue']");

    public IssueCreationPage openCreationPage(){
        log.debug("Нажимаем на кнопку 'New issue'");
        driver.findElement(newIssueButton).click();
        log.debug("Кнопка нажата. Успешно");
        return new IssueCreationPage(driver);
    }

}
