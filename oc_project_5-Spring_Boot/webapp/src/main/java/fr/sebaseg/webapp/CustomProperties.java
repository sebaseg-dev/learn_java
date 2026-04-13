package fr.sebaseg.webapp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "fr.sebaseg.webapp")
public class CustomProperties {

    private String apiUrl;

}
