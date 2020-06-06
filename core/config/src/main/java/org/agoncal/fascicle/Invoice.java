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
  // tag::adocSkip[]
  @Inject
  // end::adocSkip[]
  @ConfigProperty(defaultValue = "10")
  Float vatRate;
  Float vatAmount;
  Float total;
  // tag::adocSkip[]
  @Inject
  // end::adocSkip[]
  @ConfigProperty(defaultValue = "true")
  Boolean allowsDiscount;
  // tag::adocSkip[]
  @Inject
  // end::adocSkip[]
  @ConfigProperty(defaultValue = "2.5")
  Float discountRate;
  // tag::adocSkip[]
  @Inject
  // end::adocSkip[]
  @ConfigProperty
  String terms;
  // tag::adocSkip[]
  @Inject
  // end::adocSkip[]
  @ConfigProperty
  String penalties;
}
// end::adocSnippet[]
