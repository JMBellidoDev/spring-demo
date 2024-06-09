
package app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.models.dto.ParamDto;
import app.models.dto.ParamDtoCode;
import jakarta.servlet.http.HttpServletRequest;

/** Clase ejemplo para la anotación @RequestParam */
@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

  /**
   * Mapeo con la ruta /foo
   * @param message Mensaje requerido como parámetro en la ruta URL
   * @return ParamDto
   */
  @GetMapping("/foo")
  public ParamDto foo(@RequestParam(required = false, defaultValue = "No se estableció el mensaje") String message) {

    ParamDto param = new ParamDto();
    param.setMessage(message);

    return param;
  }

  /**
   * Mapeo con la ruta /bar
   * @param text Texto a escribir como parámetro en la ruta URL
   * @param code Código numérico a escribir como parámetro en la ruta URL
   * @return ParamDto
   */
  @GetMapping("/bar")
  public ParamDtoCode bar(@RequestParam String text, @RequestParam Integer code) {

    ParamDtoCode params = new ParamDtoCode();
    params.setMessage(text);
    params.setCode(code);

    return params;
  }

  /**
   * Mapeo hacia la ruta /request
   * @param request Petición HTTP
   * @return ParamDtoCode
   */
  @GetMapping("/request")
  public ParamDtoCode request(HttpServletRequest request) {

    ParamDtoCode params = new ParamDtoCode();

    try {
      params.setCode(Integer.parseInt(request.getParameter("code")));

    } catch (NumberFormatException e) {
      params.setCode(0);
    }

    params.setMessage(request.getParameter("message"));

    return params;
  }

}
