package org.agoncal.fascicle.quarkus.core.configuration.verbatim;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.ConfigMapping.NamingStrategy;

// tag::adocSnippet[]
@ConfigMapping(prefix = "inv", namingStrategy = NamingStrategy.KEBAB_CASE)
// end::adocSnippet[]
public interface InvoiceConfiguration {

  Float vatRate();
  Boolean allowsDiscount();
  Float discountRate();
  String terms();
  String penalties();
}
