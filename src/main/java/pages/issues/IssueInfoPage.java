package pages.issues;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BaseProjectPage;

import java.util.ArrayList;
import java.util.List;

public class IssueInfoPage extends BaseProjectPage {

    private static final String title = "Страница задачи";

    public IssueInfoPage(WebDriver driver) {
        super(driver, title);
    }

    private By titleOnPage = By.xpath("//span[@class = 'js-issue-title markdown-title']");
    private By body = By.xpath("//td[@class = 'd-block comment-body markdown-body  js-comment-body']");

    private By labels = By.xpath("//a[@class = 'IssueLabel hx_IssueLabel d-inline-block v-align-middle']");

    public IssueInfoPage validateIssue(String expectedTitle, String expectedBody, List<String> expectedLabels) {
        log.info("Проверяем успешность создания задачи и соответствие её полей");
        log.debug("Проверяем соответствие поля 'Title'");
        Assert.assertEquals(expectedTitle, waitFor10.until(ExpectedConditions
                .visibilityOf(driver.findElement(titleOnPage))).getText());
        log.debug("Соответствие поля 'Title' проверено. Успешно");
        log.debug("Проверяем соответствие комментария");
        Assert.assertEquals(expectedBody, driver.findElement(body).getText());
        log.debug("Соответствие комментария проверено. Успешно");

        log.debug("Проверяем соответствие лейбл");
        List<WebElement> labelsOnPage = driver.findElements(labels);
        List<String> labelsTitle = new ArrayList<>();
        labelsOnPage.forEach(label -> {
            Assert.assertTrue(expectedLabels.contains(label.getText()));
            labelsTitle.add(label.getText());
        });
        Assert.assertEquals(expectedLabels, labelsTitle);
        log.debug("Соответствие лейбл проверено. Успешно");

        log.debug("Успешность создания задачи и соответствие ее полей проверено. Успешно");
        return this;
    }

}
