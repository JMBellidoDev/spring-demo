
package app.services;

import java.util.List;

import app.models.Product;

/** Interfaz del servicio de gestión de productos */
public interface IProductService {

  /**
   * Obtiene una lista con todos los productos almacenados
   * @return List(Product)
   */
  public List<Product> findAll();

  /**
   * Obtiene un producto dado su ID
   * @param id ID del producto a buscar
   * @return Product - Será null si no existe dicho producto
   */
  public Product findById(Long id);

}
