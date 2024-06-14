
package app.models.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Usuario */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  /** ID */
  private Long id;

  /** Nombre */
  private String name;

  /** Apellidos */
  private String lastname;

  /** Rol */
  private Role role;

  /**
   * Constructor
   * @param id       ID
   * @param name     Nombre
   * @param lastname Apellidos
   */
  public User(Long id, String name, String lastname) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
  }

}
