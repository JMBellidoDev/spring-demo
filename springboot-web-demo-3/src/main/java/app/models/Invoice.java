
package app.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Factura */
@Data
@NoArgsConstructor
@Component
@RequestScope
public class Invoice {

  /** Cliente de la factura */
  @Autowired
  private Client client;

  /** Descripción de la factura */
  @Value("${invoice.description}")
  private String description;

  /** Items de la factura */
  @Autowired
  private List<Item> items;

  /** Informa del inicio de la aplicación */
  @PostConstruct
  public void init() {
    System.out.println("Creando el componente de la factura");
  }

  /** Calcula el precio final de la factura */
  public double getInvoiceTotal() {
    return items.stream().map(Item::getTotalPrice).reduce(0.0, (sum, p2) -> sum + p2);

  }

}
