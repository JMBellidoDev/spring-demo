
package app.controllers.interceptors;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/** Interceptor de tiempo de carga */
@Component
public class LoadingTimeInterceptor implements HandlerInterceptor {

  /** Logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(app.controllers.interceptors.LoadingTimeInterceptor.class);

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
      throws Exception {

    LOGGER.info("LoadingTimeInterceptor: postHandle() saliendo...");
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    LOGGER.info("LoadingTimeInterceptor: preHandle() entrando...");

    Map<String, String> json = Collections.singletonMap("errormessage", "Acceso no válido");

    ObjectMapper mapper = new ObjectMapper();
    String jsonString = mapper.writeValueAsString(json);

    response.setContentType("application/json");
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    response.getWriter().write(jsonString);

    return false;
  }

}
