// tag::adocSnippet[]
package org.agoncal.fascicle;

// end::adocSnippet[]
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

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
  @Inject @ConfigProperty(defaultValue = "10")
  Float vatRate;
  Float vatAmount;
  Float total;
  @Inject @ConfigProperty(defaultValue = "true")
  Boolean allowsDiscount;
  @Inject @ConfigProperty(defaultValue = "2.5")
  Float discountRate;
  @Inject @ConfigProperty
  String terms;
  @Inject @ConfigProperty
  String penalties;
}
// end::adocSnippet[]
