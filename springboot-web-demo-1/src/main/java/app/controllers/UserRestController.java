
package app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.models.User;
import app.models.dto.UserDto;

/** Controlador del usuario */
@RestController
@RequestMapping("/api")
public class UserRestController {

  /**
   * Método de mapeo en peticiones HTTP Get
   * @return userDto DTO del usuario que contiene un título personalizado para dicho usuario y el usuario en sí mismo
   */
  @GetMapping("/details-rest")
  public UserDto details() {

    UserDto userDto = new UserDto();
    User user = new User("Juan", "García", 31);

    userDto.setUser(user);
    userDto.setUserTitle("Hola " + user.getName() + " usando Spring Boot");

    return userDto;
  }

  /**
   * Método que lista todos los usuarios almacenados
   * @return List(User)
   */
  @GetMapping("/list-rest")
  public List<User> list() {

    List<User> users = new ArrayList<>();
    users.add(new User("Juan", "García", 31));
    users.add(new User("Sara", "Jiménez", 29));
    users.add(new User("Rosa", "Sánchez", 42));

    return users;
  }

}
