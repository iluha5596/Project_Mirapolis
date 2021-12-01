package mirapolis.com.pages;

import mirapolis.com.dto.ActualValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class MainPage extends BasePage {


    public MainPage(WebDriver driver) {
        super(driver);
    }
    private By divMain = By.xpath("(//div[@class=\"mira-vertical-portal-menu-item-title   level-1\"])[1]");
    private By spanMainPage = By.xpath(" (//span[@class=\"mira-label-text mira_label_text \"])[1]");



    @Test
    public ActualValues mainPage () {
        wait.until(ExpectedConditions.elementToBeClickable(divMain));
        String actualTextMainPage = driver.findElement(spanMainPage).getText();
        ActualValues actualValues = new ActualValues();
        actualValues.setTextMainPage(actualTextMainPage);

        return actualValues;
    }

}
