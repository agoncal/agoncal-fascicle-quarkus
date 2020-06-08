package org.agoncal.fascicle.quarkus.core.configuration.properties;

import io.quarkus.arc.config.ConfigProperties;
import io.quarkus.arc.config.ConfigProperties.NamingStrategy;

// tag::adocSnippet[]
@ConfigProperties(prefix = "inv", namingStrategy = NamingStrategy.VERBATIM)
public class InvoiceConfiguration {

  public Float vatRate;
  public Boolean allowsDiscount;
  public Float discountRate;
  public String terms;
  public String penalties;
}
// end::adocSnippet[]
