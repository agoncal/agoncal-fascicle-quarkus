package org.agoncal.fascicle.quarkus.core.configuration.properties;

import io.quarkus.arc.config.ConfigProperties;

// tag::adocSnippet[]
@ConfigProperties(prefix = "invoice")
public class InvoiceConfiguration {

  public Float vatRate;
  public Boolean allowsDiscount;
  public Float discountRate;
  public String terms;
  public String penalties;
}
// end::adocSnippet[]
