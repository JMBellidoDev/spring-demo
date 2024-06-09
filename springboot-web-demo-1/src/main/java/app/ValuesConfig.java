
package app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/** Clase de configuración de Spring Boot */
@Configuration
@PropertySource(value = "classpath:values.properties", encoding = "UTF-8")
public class ValuesConfig {

}
