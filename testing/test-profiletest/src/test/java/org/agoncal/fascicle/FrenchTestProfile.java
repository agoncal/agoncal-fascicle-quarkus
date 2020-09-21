package org.agoncal.fascicle;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.HashMap;
import java.util.Map;

// tag::adocSnippet[]
public class FrenchTestProfile implements QuarkusTestProfile {
  @Override
  public Map<String, String> getConfigOverrides() {
    Map<String, String> config = new HashMap();
    config.put("org.agoncal.fascicle.Invoice.vatRate", "20");
    config.put("org.agoncal.fascicle.Invoice.discount", "true");
    return config;
  }
}
// end::adocSnippet[]
