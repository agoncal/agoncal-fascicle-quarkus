package org.agoncal.fascicle.quarkus.core.configuration.properties;

// @formatter:off
// tag::adocSnippet[]
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.ConfigMapping.NamingStrategy;

@ConfigMapping(prefix = "inv", namingStrategy = NamingStrategy.VERBATIM)
public interface InvoiceConfiguration {

  Float vatRate();
  Boolean allowsDiscount();
  Float discountRate();
  String terms();
  String penalties();
}
// end::adocSnippet[]
