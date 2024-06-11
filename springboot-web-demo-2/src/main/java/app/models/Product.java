
package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Producto */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  /** ID */
  private Long id;

  /** Nombre */
  private String name;

  /** Precio */
  private Double price;

}
