package org.agoncal.fascicle.quarkus.puttingtogether.catalog.client;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

@Mock
@ApplicationScoped
@RestClient
public class MockNumberGeneratorService implements NumberGeneratorService {

  @Override
  public String generateBookNumber() {
    return "Dummy";
  }
}
