package org.agoncal.fascicle.quarkus.core.configuration;

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
  // tag::adocSkip[]
  @Inject
  // end::adocSkip[]
  @ConfigProperty(name = "invoice.vatRate", defaultValue = "10")
  Float vatRate;
  Float vatAmount;
  Float total;
  // tag::adocSkip[]
  @Inject
  // end::adocSkip[]
  @ConfigProperty(name = "invoice.allowsDiscount", defaultValue = "true")
  Boolean allowsDiscount;
  // tag::adocSkip[]
  @Inject
  // end::adocSkip[]
  @ConfigProperty(name = "invoice.discountRate", defaultValue = "2.5")
  Float discountRate;
  // tag::adocSkip[]
  @Inject
  // end::adocSkip[]
  @ConfigProperty(name = "invoice.terms")
  String terms;
  // tag::adocSkip[]
  @Inject
  // end::adocSkip[]
  @ConfigProperty(name = "invoice.penalties")
  String penalties;
}
// end::adocSnippet[]
