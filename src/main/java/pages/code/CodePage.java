package pages.code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseProjectPage;

public class CodePage extends BaseProjectPage {

    private static final String title = "Вкладка проекта с исходным кодом";

    public CodePage(WebDriver driver) {
        super(driver, title);
    }

    private By pomXml = By.xpath("//a[@title='pom.xml']");

    public PomPage openPomFile() {
        log.debug("Открываем файл pom.xml");
        driver.findElement(pomXml).click();
        log.debug("Файл открыт. Успешно");
        return new PomPage(driver);
    }

}