
package app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.models.domain.User;

/** Implementación del servicio de gestión de usuarios */
@Service
public class UserServiceImpl implements UserService {

  /** Lista de usuarios */
  private List<User> users;

  /** Constructor */
  public UserServiceImpl() {
    this.users = new ArrayList<>();

    users.add(new User(1L, "Pablo", "Ruíz"));
    users.add(new User(2L, "Rosa", "González"));
    users.add(new User(3L, "Diana", "Blanco"));
  }

  @Override
  public User findById(Long id) {
    return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
  }

  @Override
  public List<User> findAll() {
    return users;
  }

}
