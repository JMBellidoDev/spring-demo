
package app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/** DTO de Person */
@Data
@AllArgsConstructor
public class PersonDto {

  /** Nombre */
  private String name;

  /** Apellidos */
  private String lastname;

}
