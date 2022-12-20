package org.agoncal.fascicle.quarkus.core.configuration.yaml;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.inject.Singleton;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Singleton
// tag::adocSnippet[]
public class Invoice {

  Float subtotal;
  @ConfigProperty(name = "app.invoice.vatRate", defaultValue = "10")
  Float vatRate;
  Float vatAmount;
  Float total;
  @ConfigProperty(name = "app.invoice.allowsDiscount", defaultValue = "true")
  Boolean allowsDiscount;
  @ConfigProperty(name = "app.invoice.discountRate", defaultValue = "2.5")
  Float discountRate;
  @ConfigProperty(name = "app.invoice.terms")
  String terms;
  @ConfigProperty(name = "app.invoice.penalties")
  String penalties;
}
// end::adocSnippet[]
