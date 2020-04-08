package org.agoncal.fascicle.quarkus.core.configuration.firststep;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

// tag::adocSnippet[]
@ApplicationScoped
public class NumberService {

  @ConfigProperty(name = "country.code", defaultValue = "us")
  String countryCode;

  @ConfigProperty(name = "book.prefix")
  int bookPrefix;

  public String generateBookNumber() {
    return bookPrefix + generateNumber() + countryCode;
  }

  public String generateCDNumber() {
    return generateNumber() + countryCode;
  }
  // tag::adocSkip[]

  private String generateNumber() {
    return Math.random() + "-";
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
