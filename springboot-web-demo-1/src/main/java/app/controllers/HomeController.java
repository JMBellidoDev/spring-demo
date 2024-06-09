
package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/** Controlador Home para redirect / forward */
@Controller
public class HomeController {

  /**
   * Redirección de las rutas indicadas en GetMapping hacia /list
   * @return String - Redirección de ruta
   */
  @GetMapping({ "", "/", "/home" })
  public String home() {
    return "redirect:/list";
    // return "forward:/list";
  }

}
