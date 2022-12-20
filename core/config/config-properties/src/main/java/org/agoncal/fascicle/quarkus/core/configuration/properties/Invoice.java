package org.agoncal.fascicle.quarkus.core.configuration.properties;

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
  Float vatRate;
  Float vatAmount;
  Float total;
  Boolean allowsDiscount;
  Float discountRate;
  String terms;
  String penalties;
}
// end::adocSnippet[]
