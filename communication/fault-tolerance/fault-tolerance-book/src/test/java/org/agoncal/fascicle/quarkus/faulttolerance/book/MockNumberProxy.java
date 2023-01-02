// tag::adocTest[]
package org.agoncal.fascicle.quarkus.faulttolerance.book;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.JsonObject;

// tag::adocSnippet[]
@Mock
@ApplicationScoped
@RestClient
public class MockNumberProxy implements NumberProxy {

  @Override
  public JsonObject generateIssn() {
    return Json.createObjectBuilder()
      .add("isbn10", "dummy isbn 10")
      .build();
  }

  @Override
  public IsbnNumber generateIsbn(boolean separator) {
    IsbnNumber isbnNumber = new IsbnNumber();
    isbnNumber.isbn13 = "dummy isbn 13";
    isbnNumber.gs1 = "dummy gs1";
    return isbnNumber;
  }
}
// end::adocSnippet[]
