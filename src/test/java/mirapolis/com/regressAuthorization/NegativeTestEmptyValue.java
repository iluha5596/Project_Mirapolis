package mirapolis.com.regressAuthorization;

import config.ExpectedValues;
import config.ServerConfig;
import mirapolis.com.BaseTest;
import mirapolis.com.dto.ActualValues;
import mirapolis.com.pages.Authorization;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class NegativeTestEmptyValue extends BaseTest {

    @Test
    public void negativeTestLogin() {
        Authorization authorization = new Authorization(driver);
        ExpectedValues expectedValues = ConfigFactory.create(ExpectedValues.class);
        authorization.openMirapolis();
        authorization.auth("", "");
        ActualValues actualValues = authorization.alert();
        assertEquals(expectedValues.expectedAlertEmptyValue(), actualValues.getActualAlert());
        logger.info("Сообщение при пустых значениях верное");

    }
}
