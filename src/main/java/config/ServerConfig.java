package config;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:ServerConfig.properties")
public interface ServerConfig extends Config {

    String loginValid() ;
    String loginNegative();
    String passwordNegative();
    String passwordValid();


}
