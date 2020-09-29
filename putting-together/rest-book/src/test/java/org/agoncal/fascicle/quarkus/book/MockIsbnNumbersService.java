// tag::adocTest[]
package org.agoncal.fascicle.quarkus.book;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

// tag::adocSnippet[]
@Mock
@ApplicationScoped
@RestClient
public class MockIsbnNumbersService implements NumberResourceProxy {

  @Override
  public IsbnNumbers generateIsbnNumbers() {
    IsbnNumbers isbnNumbers = new IsbnNumbers();
    isbnNumbers.setIsbn13("dummy isbn 13");
    isbnNumbers.setIsbn10("dummy isbn 10");
    return isbnNumbers;
  }
}
// end::adocSnippet[]
