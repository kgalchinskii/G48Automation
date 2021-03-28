package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BaseAuthorizedPage {

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    private By pomXml = By.xpath("//a[@title='pom.xml']");

    private By codeTab = By.xpath("//span[@data-content = 'Code']");
    private By issueTab = By.xpath("//span[@data-content = 'Issues']");
    private By pullRequestsTab = By.xpath("//span[@data-content = 'Pull requests']");
    private By actionsTab = By.xpath("//span[@data-content = 'Actions']");
    private By projectsTab = By.xpath("//span[@data-content = 'Projects']");
    private By wikiTab = By.xpath("//span[@data-content = 'Wiki']");
    private By securityTab = By.xpath("//span[@data-content = 'Security']");
    private By insightsTab = By.xpath("//span[@data-content = 'Insights']");
    private By settingsTab = By.xpath("//span[@data-content = 'Settings']");

    public PomPage openPomFile() {
        driver.findElement(pomXml).click();
        return new PomPage(driver);
    }

    public ProjectPage displayTabs (){
        log.info(driver.findElement(codeTab).getText());
        log.info(driver.findElement(issueTab).getText());
        log.info(driver.findElement(pullRequestsTab).getText());
        log.info(driver.findElement(actionsTab).getText());
        log.info(driver.findElement(projectsTab).getText());
        log.info(driver.findElement(wikiTab).getText());
        log.info(driver.findElement(securityTab).getText());
        log.info(driver.findElement(insightsTab).getText());
        log.info(driver.findElement(settingsTab).getText());
        return this;
    }

}