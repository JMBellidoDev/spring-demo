
package app.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;
import lombok.NoArgsConstructor;

/** Cliente */
@Data
@NoArgsConstructor
@Component
@SessionScope
public class Client {

  /** Nombre */
  @Value("${client.name}")
  private String name;

  /** Apellidos */
  @Value("${client.lastname}")
  private String lastname;

}
