
package app.models;

import java.time.LocalDate;

import lombok.Data;

/** Error */
@Data
public class SpringError {

  /** Mensaje */
  private String message;

  /** Tipo de error */
  private String errorType;

  /** Status del error */
  private int status;

  /** Fecha en la que se produce */
  private LocalDate date;

}
