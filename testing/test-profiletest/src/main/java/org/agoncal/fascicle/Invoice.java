package org.agoncal.fascicle;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Singleton;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Singleton
// @formatter:off
// tag::adocSnippet[]
public class Invoice {

  Float subtotal;
  @ConfigProperty(defaultValue = "10")
  Float vatRate;
  Float total;
  @ConfigProperty(defaultValue = "true")
  Boolean allowsDiscount;
  @ConfigProperty(defaultValue = "2.5")
  Float discountRate;
  @ConfigProperty
  String terms;
  @ConfigProperty
  String penalties;

  public Float caclculateVatAmount() {
    return subtotal * (vatRate / 100);
  }

  public Float caclculateTotal() {
    return subtotal + caclculateVatAmount();
  }
}
// end::adocSnippet[]
