package pages.code;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BaseAuthorizedPage;

public class PomPage extends BaseAuthorizedPage {

    private static final String title = "Страница файла pom.xml";

    public PomPage(WebDriver driver) {
        super(driver, title);
    }

    private By seleniumVersion = By.xpath("//*[@id=\"LC77\"]");

    public PomPage displaySeleniumVersion() {
        log.debug("Сравниваем версию selenium");
        Assert.assertEquals("3.141.59", driver.findElement(seleniumVersion).getText().replaceAll("[ <></>]+[a-zA-Z]+[</>]", ""));
        log.debug("Сравнение проведено. Успешно");
        log.info("Версия selenium: " + driver.findElement(seleniumVersion).getText().replaceAll("[ <></>]+[a-zA-Z]+[</>]", ""));
        return this;
    }

}
