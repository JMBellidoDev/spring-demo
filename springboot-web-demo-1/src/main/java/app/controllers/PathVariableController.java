
package app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.models.User;
import app.models.dto.ParamDto;

/** Controlador que usa la anotación @ PathVariable */
@RestController
@RequestMapping("/api/var")
public class PathVariableController {

  /**
   * Mapeo hacia la ruta variable /baz/{message}
   * @param message Mensaje que será parte de la ruta de mapeo
   * @return ParamDto
   */
  @GetMapping("/baz/{message}")
  public ParamDto baz(@PathVariable String message) {

    ParamDto param = new ParamDto();
    param.setMessage(message);
    return param;
  }

  /**
   * Mapeo hacia la ruta variable /bazwithcode/{message}
   * @param product Nombre de producto
   * @param ID      del producto
   * @return ParamDto
   */
  @GetMapping("/bazwithmoreparameters/{product}/{id}")
  public Map<String, Object> bazWithCode(@PathVariable String product, @PathVariable Long id) {

    Map<String, Object> json = new HashMap<>();

    json.put("product", product);
    json.put("id", id);

    return json;
  }

  /**
   * Mapeo hacia la ruta /create con método POST. Convierte el nombre y apellidos del usuario de entrada a mayúsculas
   * @param user Usuario de entrada
   * @return User
   */
  @PostMapping("/create")
  public User create(@RequestBody User user) {

    // Conversión del nombre y apellidos a mayúscula
    user.setName(user.getName().toUpperCase());
    user.setLastname(user.getLastname().toUpperCase());

    return user;
  }

  /** Código inyectado desde values.properties */
  @Value("${config.code}")
  private Integer code;

  /** Username inyectado desde values.properties */
  @Value("${config.username}")
  private String username;

  /**
   * Método que mapea hacia la ruta /values, de forma que la información mostrada se inyecta desde ficheros de configuración
   * @return Map(String, Object)
   */
  @GetMapping("/values")
  public Map<String, Object> values(@Value("${config.message") String message) {

    Map<String, Object> json = new HashMap<>();
    json.put("code", code);
    json.put("username", username);
    json.put("message", message);

    return json;
  }

}
