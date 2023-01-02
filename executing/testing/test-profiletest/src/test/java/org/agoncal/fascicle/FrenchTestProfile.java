package org.agoncal.fascicle;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Map;

// tag::adocSnippet[]
public class FrenchTestProfile implements QuarkusTestProfile {
  @Override
  public Map<String, String> getConfigOverrides() {
    return Map.of(
      "org.agoncal.fascicle.Invoice.vatRate", "20",
      "org.agoncal.fascicle.Invoice.discount", "true"
    );
  }
}
// end::adocSnippet[]
