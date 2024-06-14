
package app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Clase persona */
@Entity
@Table(name = "people")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  /** ID */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre */
  @Column(name = "name")
  private String name;

  /** Apellidos */
  @Column(name = "lastname")
  private String lastname;

  /** Lenguaje de programación */
  @Column(name = "programming_language")
  private String programmingLanguage;

  @Override
  public String toString() {
    return String.format("ID: %d, Name: %s, Lastname: %s, Programming Language: %s", id, name, lastname,
        programmingLanguage);
  }

}
