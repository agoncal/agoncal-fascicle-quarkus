package org.agoncal.fascicle.quarkus.core.configuration;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.inject.Singleton;
import java.util.Optional;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Singleton
public class OptionalInvoice {

  Float subtotal;
  @ConfigProperty(name = "invoice.vatRate", defaultValue = "10")
  Float vatRate;
  Float vatAmount;
  Float total;
  @ConfigProperty(name = "invoice.allowsDiscount", defaultValue = "true")
  Boolean allowsDiscount;
  @ConfigProperty(name = "invoice.discountRate", defaultValue = "2.5")
  Float discountRate;
  @ConfigProperty(name = "invoice.terms")
  Optional<String> terms;
  @ConfigProperty(name = "invoice.penalties")
  Optional<String> penalties;
}
