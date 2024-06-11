
package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.models.Product;
import app.services.IProductService;

/** Controlador de productos */
@RestController
@RequestMapping("/api")
public class ProductController {

  /** Servicio de productos */
  private IProductService service;

  /**
   * Constructor
   * @param service Servicio de productos
   */
  @Autowired
  public ProductController(IProductService service) {
    this.service = service;
  }

  /**
   * Obtiene una lista con todos los productos almacenados
   * @return List(Product)
   */
  @GetMapping
  public List<Product> list() {

    return service.findAll();
  }

  /**
   * Obtiene un producto dado su ID
   * @param id ID del producto
   * @return Product
   */
  @GetMapping("/{id}")
  public Product showProduct(@PathVariable Long id) {

    return service.findById(id);
  }

}
