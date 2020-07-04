// tag::adocTest[]
package org.agoncal.fascicle.quarkus.restclient.numbers;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;

// tag::adocSnippet[]
@Mock
@ApplicationScoped
@RestClient
public class MockIssnService implements IssnService {

  @Override
  public JsonObject generateIssn() {
    return Json.createObjectBuilder()
      .add("issn", "dummy isbn 10")
      .build();
  }
}
// end::adocSnippet[]
