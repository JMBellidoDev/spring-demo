
package app.models;

import lombok.Data;
import lombok.NoArgsConstructor;

/** Producto */
@Data
@NoArgsConstructor
public class Product {

  /** Nombre del producto */
  private String name;

  /** Precio del producto */
  private double price;

}
