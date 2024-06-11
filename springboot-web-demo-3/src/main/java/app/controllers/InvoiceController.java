
package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.models.Client;
import app.models.Invoice;

/** Controlador de facturas */
@RestController
@RequestMapping("/invoices")
public class InvoiceController {

  /** Factura */
  @Autowired
  private Invoice invoice;

  /**
   * Muestra la factura
   * @return Invoice
   */
  @GetMapping("/show")
  public Invoice show() {

    Invoice i = new Invoice();
    Client c = new Client();

    c.setLastname(invoice.getClient().getLastname());
    c.setName(invoice.getClient().getName());

    i.setClient(invoice.getClient());
    i.setDescription(invoice.getDescription());
    i.setItems(invoice.getItems());

    return i;
  }

}
