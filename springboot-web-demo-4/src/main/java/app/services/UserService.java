
package app.services;

import java.util.List;

import app.models.domain.User;

/** Servicio de gestión de usuarios */
public interface UserService {

  /**
   * Busca un usuario dado su ID
   * @param id ID del usuario
   * @return User
   */
  User findById(Long id);

  /**
   * Devuelve una lista con todos los usuarios del sistema
   * @return List(User)
   */
  List<User> findAll();

}
