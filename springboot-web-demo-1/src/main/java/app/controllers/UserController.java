
package app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import app.models.User;

/** Controlador del usuario */
@Controller
public class UserController {

  /**
   * Método de mapeo en peticiones HTTP Get para obtener detalles de un usuario
   * @param model Modelo de Spring Framework
   * @return String - Nombre de la vista HTML sobre la que se mapea
   */
  @GetMapping("/details")
  public String details(Model model) {

    User user = new User("Juan", "García", 31);

    // Atributos
    model.addAttribute("title", "Hola mundo usando Spring Boot");
    model.addAttribute("user", user);

    return "details";
  }

  /**
   * Método de mapeo en peticiones HTTP Get para obtener una lista de todos los usuarios
   * @param model Modelo de Spring Framework
   * @return String - Nombre de la vista HTML sobre la que se mapea
   */
  @GetMapping("/list")
  public String list(Model model) {
    model.addAttribute("Listado de usuarios");

    return "list";
  }

  /**
   * Genera una lista de usuarios que serán atributo para la vista
   * @return List(User)
   */
  @ModelAttribute(name = "users")
  public List<User> usersModel() {
    return List.of(new User("Juan", "García", "JuanGarcia@gmail.com", 31), new User("Sara", "Jiménez", 29),
        new User("Rosa", "Sánchez", 42));
  }

}
