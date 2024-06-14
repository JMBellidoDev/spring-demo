
package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.controllers.exceptions.UserNotFoundException;
import app.models.domain.User;
import app.services.UserService;

/** Controlador API REST */
@RestController
@RequestMapping("/app")
public class AppController {

  /** Servicio de gestión de usuarios */
  private UserService service;

  /**
   * Constructor
   * @param service Servicio de usuarios
   */
  @Autowired
  public AppController(UserService service) {
    this.service = service;
  }

  /** Método test para manejo de errores */
  @GetMapping("/")
  public String index() {

    return "OK 200";
  }

  /**
   * Muestra la información de un usuario
   * @param id ID
   * @return User
   * @throws UserNotFoundException Si User es null
   */
  @GetMapping("/show/{id}")
  public User show(@PathVariable(name = "id") Long id) throws UserNotFoundException {

    User user = service.findById(id);

    if (user == null) {
      throw new UserNotFoundException("El usuario no existe.");
    }

    return user;
  }

}
