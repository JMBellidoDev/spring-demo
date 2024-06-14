
package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Clase de configuración de web MVC */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

  /** Interceptor */
  @Autowired
  @Qualifier("loadingTimeInterceptor")
  private HandlerInterceptor timeInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(timeInterceptor);
  }

}
