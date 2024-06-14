
package app.controllers.exceptions;

/** Excepción por usuario o rol no encontrado */
public class UserNotFoundException extends Exception {

  /** SerialVersionUID */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor con mensaje
   * @param message Mensaje
   */
  public UserNotFoundException(String message) {
    super(message);
  }

}
