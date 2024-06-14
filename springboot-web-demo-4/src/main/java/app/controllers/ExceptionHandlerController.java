
package app.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import app.controllers.exceptions.UserNotFoundException;
import app.models.SpringError;

/** Controlador manejador de errores */
@RestControllerAdvice
public class ExceptionHandlerController {

  /**
   * Manejador de excepciones para ArithmeticException
   * @param exception Excepción
   * @return ResponseEntity(SpringError)
   */
  @ExceptionHandler(ArithmeticException.class)
  public ResponseEntity<SpringError> divisionByZero(Exception exception) {

    SpringError error = new SpringError();
    error.setDate(LocalDate.now());
    error.setErrorType("División por cero");
    error.setMessage(exception.getMessage());
    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

    return ResponseEntity.internalServerError().body(error);
  }

  /**
   * Manejador de excepciones NumberFormatException
   * @param exception Excepción
   * @return Map(String, String)
   */
  @ExceptionHandler(NumberFormatException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Map<String, Object> numberFormatException(Exception exception) {

    Map<String, Object> error = new HashMap<>();
    error.put("date", LocalDate.now());
    error.put("errorType", "Número no válido. El formato del número es incorrecto.");
    error.put("message", exception.getMessage());
    error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

    return error;
  }

  /**
   * Manejador de excepciones UserNotFoundException
   * @param exception Excepción
   * @return Map(String, String)
   */
  @ExceptionHandler({ UserNotFoundException.class })
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Map<String, Object> userNotFoundException(Exception exception) {

    Map<String, Object> error = new HashMap<>();
    error.put("date", LocalDate.now());
    error.put("errorType", "El usuario o su Role no existe.");
    error.put("message", exception.getMessage());
    error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

    return error;
  }

  /**
   * Manejador de excepciones para 404 - NotFoundException
   * @param exception Excepción
   * @return ResponseEntity(SpringError)
   */
  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<SpringError> notFoundException(Exception exception) {

    SpringError error = new SpringError();
    error.setDate(LocalDate.now());
    error.setErrorType("API REST no encontrado");
    error.setMessage(exception.getMessage());
    error.setStatus(HttpStatus.NOT_FOUND.value());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

}
