
package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import app.models.Product;
import app.repositories.IProductRepository;

/** Servicio de gestión de productos */
@Service
public class ProductServiceImpl implements IProductService {

  /** Entorno */
  private Environment environment;

  /** Repositorio de productos */
  private IProductRepository pRepository;

  /**
   * Constructor
   * @param pRespository Repositorio de productos
   */
  @Autowired
  public ProductServiceImpl(Environment environment, IProductRepository pRespository) {
    this.pRepository = pRespository;
  }

  @Override
  public List<Product> findAll() {

    // Se obtienen los datos del repositorio y comprueban/modifican en el servicio
    // Se añade un impuesto sobre el precio
    return pRepository.findAll().stream().map(p -> {

      Product newProduct = new Product();
      newProduct.setId(p.getId());
      newProduct.setName(p.getName());
      newProduct.setPrice(p.getPrice() * (1 + environment.getProperty("config.price.tax", Double.class)));

      return newProduct;
    }).toList();

  }

  @Override
  public Product findById(Long id) {
    return pRepository.findById(id);
  }

}
