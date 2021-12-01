package mirapolis.com.regressAuthorization;

import config.ExpectedValues;
import config.ServerConfig;
import mirapolis.com.BaseTest;
import mirapolis.com.dto.ActualValues;
import mirapolis.com.pages.Authorization;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class NegativeTestLoginPass extends BaseTest {

    @Test
    public void negativeTestLogin() {
        Authorization authorization = new Authorization(driver);
        ServerConfig serverConfig = ConfigFactory.create(ServerConfig.class);
        ExpectedValues expectedValues = ConfigFactory.create(ExpectedValues.class);
        authorization.openMirapolis();
        authorization.auth(serverConfig.loginNegative(), serverConfig.passwordNegative());
        ActualValues actualValues = authorization.alert();
        assertEquals(expectedValues.expectedAlert(), actualValues.getActualAlert());
        logger.info("Сообщение при невалидном пароле верное");

    }
}

