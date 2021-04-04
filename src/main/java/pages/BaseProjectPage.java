package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.code.CodePage;
import pages.issues.IssuePage;

public class BaseProjectPage extends BaseAuthorizedPage {

    public BaseProjectPage(WebDriver driver, String title) {
        super(driver, title);
    }

    private By codeTab = By.xpath("//span[@data-content = 'Code']");
    private By issueTab = By.xpath("//span[@data-content = 'Issues']");
    private By pullRequestsTab = By.xpath("//span[@data-content = 'Pull requests']");
    private By actionsTab = By.xpath("//span[@data-content = 'Actions']");
    private By projectsTab = By.xpath("//span[@data-content = 'Projects']");
    private By wikiTab = By.xpath("//span[@data-content = 'Wiki']");
    private By securityTab = By.xpath("//span[@data-content = 'Security']");
    private By insightsTab = By.xpath("//span[@data-content = 'Insights']");
    private By settingsTab = By.xpath("//span[@data-content = 'Settings']");

    public BaseProjectPage displayTabs() {
        log.debug("Отображаем все вкладки проекта");
        log.info(driver.findElement(codeTab).getText());
        log.info(driver.findElement(issueTab).getText());
        log.info(driver.findElement(pullRequestsTab).getText());
        log.info(driver.findElement(actionsTab).getText());
        log.info(driver.findElement(projectsTab).getText());
        log.info(driver.findElement(wikiTab).getText());
        log.info(driver.findElement(securityTab).getText());
        log.info(driver.findElement(insightsTab).getText());
        log.info(driver.findElement(settingsTab).getText());
        log.debug("Вкладки проекта отображены. Успешно");
        return this;
    }

    public CodePage openCodeTab() {
        log.debug("Открываем вкладку проекта с исходным кодом");
        driver.findElement(codeTab).click();
        log.debug("Вкладка открыта. Успешно");
        return new CodePage(driver);
    }

    public IssuePage openIssueTab() {
        log.debug("Открываем вкладку с задачами проекта");
        driver.findElement(issueTab).click();
        log.debug("Вкладка открыта. Успешно");
        return new IssuePage(driver);
    }

}
