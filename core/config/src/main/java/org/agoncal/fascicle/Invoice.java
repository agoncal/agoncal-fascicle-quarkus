package org.agoncal.fascicle;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Singleton
// tag::adocSnippet[]
public class Invoice {

  Float subtotal;
  @Inject
  @ConfigProperty(defaultValue = "10")
  Float vatRate;
  Float vatAmount;
  Float total;
  @Inject
  @ConfigProperty(defaultValue = "true")
  Boolean allowsDiscount;
  @Inject
  @ConfigProperty(defaultValue = "2.5")
  Float discountRate;
  @Inject
  @ConfigProperty
  String terms;
  @Inject
  @ConfigProperty
  String penalties;
}
// end::adocSnippet[]
