
package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Usuario */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  /** Nombre */
  private String name;

  /** Apellidos */
  private String lastname;

  /** Email */
  private String email;

  /** Edad */
  private int age;

  /**
   * Constructor con nombre, apellidos y edad
   * @param name     Nombre
   * @param lastname Apellidos
   * @param age      Edad
   */
  public User(String name, String lastname, int age) {
    super();
    this.name = name;
    this.lastname = lastname;
    this.age = age;
  }

}
