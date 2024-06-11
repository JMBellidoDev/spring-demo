
package app.repositories;

import java.util.List;

import app.models.Product;

/** Interfaz de repositorio de productos */
public interface IProductRepository {

  /**
   * Obtiene todos los productos almacenados
   * @return List(Product)
   */
  List<Product> findAll();

  /**
   * Obtiene un producto dado su ID
   * @param id ID del producto
   * @return Product - Será null si no se encuentra
   */
  Product findById(Long id);

}
