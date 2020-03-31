package org.agoncal.fascicle.quarkus.core.configuration.yaml;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@ApplicationScoped
// tag::adocSnippet[]
public class Invoice {

  LocalDate invoiceDate;
  Float subtotal;
  @ConfigProperty(name = "invoice.vatRate", defaultValue = "10")
  Float vatRate;
  Float total;
  @ConfigProperty(name = "invoice.allowsDiscount", defaultValue = "false")
  Boolean allowsDiscount;
  @ConfigProperty(name = "invoice.discountRate")
  Float discountRate;
  @ConfigProperty(name = "invoice.terms")
  String terms;
  @ConfigProperty(name = "invoice.penalties")
  String penalties;

  @Override
  public String toString() {
    return "Invoice{" +
      "invoiceDate=" + invoiceDate +
      ", subtotal=" + subtotal +
      ", vatRate=" + vatRate +
      ", total=" + total +
      ", allowsDiscount=" + allowsDiscount +
      ", discountRate=" + discountRate +
      ", terms='" + terms + '\'' +
      ", penalties='" + penalties + '\'' +
      '}';
  }
}
