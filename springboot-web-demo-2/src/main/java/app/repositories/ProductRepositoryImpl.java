
package app.repositories;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import app.models.Product;

/** Repositorio de Productos */
@Repository
@Primary
public class ProductRepositoryImpl implements IProductRepository {

  /** Lista de productos con la que trabajar */
  private List<Product> products;

  /** Constructor */
  public ProductRepositoryImpl() {
    products = List.of(new Product(1L, "Teclado mecanico", 74.2), new Product(2L, "Raton Razer", 109.10),
        new Product(3L, "Monitor Samsung OLED", 329.99));
  }

  @Override
  public List<Product> findAll() {
    return products;
  }

  @Override
  public Product findById(Long id) {

    return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
  }

}
