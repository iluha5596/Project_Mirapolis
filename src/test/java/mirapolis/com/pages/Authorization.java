package mirapolis.com.pages;

import mirapolis.com.dto.ActualValues;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Authorization extends BasePage {

    public Authorization(WebDriver driver) {
        super(driver);
    }
    private final String MIRAPOLIS_URL = "https://lmslite47vr.demo.mirapolis.ru/mira";
    private By buttonLogin = By.xpath("//button[@type=\"submit\"]");
    private By inputUser = By.xpath("//input[@name=\"user\"]");
    private By inputPassword = By.xpath("//input[@name=\"password\"]");

    public void openMirapolis() {
        driver.get(MIRAPOLIS_URL);
        logger.info("Сайт открыт");
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogin));
    }

    public void auth (String login, String password) {
        driver.findElement(inputUser).sendKeys(login);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonLogin).click();

    }

    public ActualValues alert() {
        ActualValues actualValues = new ActualValues();
        wait.until(ExpectedConditions.alertIsPresent());
        logger.info("Появился alert");
        Alert alert = driver.switchTo().alert();
        String actualAlert = alert.getText();
        alert.accept();
        actualValues.setActualAlert(actualAlert);

        return actualValues;
    }


}
