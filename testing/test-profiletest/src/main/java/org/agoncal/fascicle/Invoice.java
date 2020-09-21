package org.agoncal.fascicle;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Singleton;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Singleton
public class Invoice {

  Float subtotal;
  @ConfigProperty(defaultValue = "10")
  Float vatRate;
  @ConfigProperty(defaultValue = "true")
  Boolean discount;
  @ConfigProperty(defaultValue = "2.5")
  Float discountRate;

  public Float caclculateVatAmount() {
    return subtotal * (vatRate / 100);
  }

  public Float caclculateTotal() {
    Float total = subtotal + caclculateVatAmount();
    if (discount) {
      total = total - (subtotal * (discountRate / 100));
    }
    return total;
  }
}
// end::adocSnippet[]
