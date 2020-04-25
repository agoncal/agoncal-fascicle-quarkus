package org.agoncal.fascicle.quarkus.core.configuration.verbatim;

import io.quarkus.arc.config.ConfigProperties;

import static io.quarkus.arc.config.ConfigProperties.NamingStrategy.KEBAB_CASE;

// tag::adocSnippet[]
@ConfigProperties(prefix = "inv", namingStrategy = KEBAB_CASE)
// end::adocSnippet[]
public class InvoiceConfiguration {

  public Float vatRate;
  public Boolean allowsDiscount;
  public Float discountRate;
  public String terms;
  public String penalties;
}
