package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:ExpectedValues.properties")
public interface ExpectedValues extends Config {
    String expectedAlert();
    String expectedAlertEmptyValue();
    String expectedTextMainPage();
}