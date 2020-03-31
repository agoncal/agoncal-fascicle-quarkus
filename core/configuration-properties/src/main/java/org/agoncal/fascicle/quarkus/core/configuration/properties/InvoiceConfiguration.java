package org.agoncal.fascicle.quarkus.core.configuration.properties;

import io.quarkus.arc.config.ConfigProperties;

import javax.inject.Singleton;

@Singleton
// tag::adocSnippet[]
@ConfigProperties(prefix = "invoice")
public class InvoiceConfiguration {

  Float vatRate;
  Boolean allowsDiscount;
  Float discountRate;
  String terms;
  String penalties;
}
// end::adocSnippet[]
