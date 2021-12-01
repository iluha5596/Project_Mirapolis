package mirapolis.com.regressAuthorization;

import config.ExpectedValues;
import config.ServerConfig;
import mirapolis.com.BaseTest;
import mirapolis.com.dto.ActualValues;
import mirapolis.com.pages.Authorization;
import mirapolis.com.pages.MainPage;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ValidLoginPass extends BaseTest {
    @Test
    public void negativeTestPass() {
        Authorization authorization = new Authorization(driver);
        ServerConfig serverConfig = ConfigFactory.create(ServerConfig.class);
        ExpectedValues expectedValues = ConfigFactory.create(ExpectedValues.class);
        authorization.openMirapolis();
        authorization.auth(serverConfig.loginValid(), serverConfig.passwordValid());
        MainPage mainPage = new MainPage(driver);
        ActualValues actualValues = mainPage.mainPage();
        assertEquals(expectedValues.expectedTextMainPage(), actualValues.getTextMainPage());
        logger.info("Открыта главная страница");

    }
}
