package pages.issues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseProjectPage;

import java.util.List;

public class IssueCreationPage extends BaseProjectPage {

    private static final String title = "Страница создания новой задачи";

    public IssueCreationPage(WebDriver driver) {
        super(driver, title);
    }

    private By titleField = By.id("issue_title");
    private By bodyField = By.id("issue_body");
    private By submitButton = By.xpath("//button[contains(text(), 'Submit new issue')]");

    private By labelsButton = By.id("labels-select-menu");
    private By labelsList = By.xpath("//div[@class = 'css-truncate']/span");

    public IssueInfoPage createNewIssue(String title, String body, List<String> labels) {
        log.debug(String.format("Создаем задачу \"%s\" с комментарием \"%s\" и лейблами \"%s\"", title, body, labels));
        log.debug("Заполняем поле 'Title'");
        driver.findElement(titleField).sendKeys(title);
        log.debug("Поле заполнено. Успешно");
        log.debug("Пишем комментарий");
        driver.findElement(bodyField).sendKeys(body);
        log.debug("Комментарий оставлен. Успешно");

        log.debug("Нажимаем на кнопку 'Labels'");
        driver.findElement(labelsButton).click();
        log.debug("Кнопка нажата. Успешно");

        log.debug("Получаем список доступных лейбл");
        List<WebElement> labelsOnPage = driver.findElements(labelsList);
        log.debug("Список получен. Успешно");

        log.debug("Задаем необходимые лейблы");
        labelsOnPage.stream()
                .filter(labelOnPage -> labels.contains(labelOnPage.getText()))
                .forEach(filteredLabelOnPage -> filteredLabelOnPage.click());
        log.debug("Лейблы заданы. Успешно");

        log.debug("Нажимаем на кнопку 'Labels'");
        driver.findElement(labelsButton).click();
        log.debug("Кнопка нажата. Успешно");
        log.debug("Нажимаем на кнопку 'Submit new issue'");
        driver.findElements(submitButton).get(0).click();
        log.debug("Кнопка нажата. Успешно");

        log.debug("Новая задача создана. Успешно");
        return new IssueInfoPage(driver);
    }

}
