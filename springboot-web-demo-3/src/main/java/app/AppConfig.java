
package app;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import app.models.Item;
import app.models.Product;

/** Clase de configuración del proyecto */
@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {

  /** Items de la factura */
  @Bean
  List<Item> itemsInvoice() {
    Product p1 = new Product();
    p1.setName("Camara Sony");
    p1.setPrice(849.00);

    Product p2 = new Product();
    p2.setName("Bicicleta");
    p2.setPrice(1220.19);

    return List.of(new Item(p1, 2), new Item(p2, 4));
  }

  /** Items de la factura de la oficina */
  @Bean
  @Primary
  List<Item> itemsInvoiceOffice() {
    Product p1 = new Product();
    p1.setName("Monitor ASUS 24'");
    p1.setPrice(700.99);

    Product p2 = new Product();
    p2.setName("Notebook Razer");
    p2.setPrice(20019.70);

    return List.of(new Item(p1, 2), new Item(p2, 4));
  }

}
