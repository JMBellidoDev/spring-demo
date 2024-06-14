
package app.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Controlador */
@RestController
@RequestMapping("/app")
public class AppController {

  /**
   * Mapeado principal
   * @return Map(String, Object)
   */
  @GetMapping("/main")
  public Map<String, Object> mainMapping() {

    return Collections.singletonMap("message", "handler principal del controlador");

  }

  /**
   * Mapeado secundario
   * @return Map(String, Object)
   */
  @GetMapping("/sec")
  public Map<String, Object> secondaryMapping() {

    return Collections.singletonMap("message", "handler secundario controlador");

  }

  /**
   * Mapeado terciario
   * @return Map(String, Object)
   */
  @GetMapping("/third")
  public Map<String, Object> thirdMapping() {

    return Collections.singletonMap("message", "handler terciario del controlador");

  }
}
