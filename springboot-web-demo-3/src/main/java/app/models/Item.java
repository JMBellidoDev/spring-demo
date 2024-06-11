
package app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Item de la factura */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

  /** Producto */
  private Product product;

  /** Cantidad del producto */
  private Integer quantity;

  /** Obtiene el precio total del item */
  public double getTotalPrice() {
    return product.getPrice() * quantity;
  }
}
