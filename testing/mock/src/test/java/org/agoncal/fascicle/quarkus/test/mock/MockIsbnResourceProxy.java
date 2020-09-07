// tag::adocTest[]
package org.agoncal.fascicle.quarkus.test.mock;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

// tag::adocSnippet[]
@Mock
@ApplicationScoped
@RestClient
public class MockIsbnResourceProxy implements IsbnResourceProxy {

  @Override
  public IsbnNumbers generateIsbnNumbers() {
    IsbnNumbers isbnNumbers = new IsbnNumbers();
    isbnNumbers.setIsbn13("@Mock isbn 13");
    isbnNumbers.setIsbn10("@Mock isbn 10");
    return isbnNumbers;
  }
}
// end::adocSnippet[]
