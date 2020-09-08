package org.agoncal.fascicle;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.HashMap;
import java.util.Map;

public class FrenchTestProfile implements QuarkusTestProfile {
  @Override
  public Map<String, String> getConfigOverrides() {
    Map<String, String> config = new HashMap();
    config.put("org.agoncal.fascicle.Invoice.vatRate", "20");
    config.put("org.agoncal.fascicle.Invoice.allowsDiscount", "true");
    return config;

//    org.agoncal.fascicle.Invoice.vatRate=10
//    org.agoncal.fascicle.Invoice.allowsDiscount=false
//    org.agoncal.fascicle.Invoice.terms=Payment upon receipt
//    org.agoncal.fascicle.Invoice.penalties=Penalty in case of late payment


  }

  @Override
  public String getConfigProfile() {
    return "france-profile";
  }
}
