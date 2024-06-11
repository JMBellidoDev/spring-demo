
package app.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import app.models.Product;

/**
 * Otra implementación de la interfaz IProductRepository. Creada para las implementaciones de prioridades al usar anotaciones
 * Component
 */
@Repository
public class ProductRepositoryImpl2 implements IProductRepository {

  @Override
  public List<Product> findAll() {
    return List.of();
  }

  @Override
  public Product findById(Long id) {
    return null;
  }

}
