
package app.models.dto;

import app.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/** DTO del usuario */
@Data
@NoArgsConstructor
public class UserDto {

  /** Título del usuario */
  private String userTitle;

  /** Nombre del Usuario */
  private User user;

}
