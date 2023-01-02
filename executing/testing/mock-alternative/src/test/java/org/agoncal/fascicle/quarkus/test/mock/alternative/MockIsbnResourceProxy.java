// tag::adocTest[]
package org.agoncal.fascicle.quarkus.test.mock.alternative;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

// tag::adocSnippet[]
@Alternative
@Priority(1)
@ApplicationScoped
@RestClient
public class MockIsbnResourceProxy implements IsbnResourceProxy {
  // ...
  // tag::adocSkip[]
  @Override
  public IsbnNumbers generateIsbnNumbers() {
    IsbnNumbers isbnNumbers = new IsbnNumbers();
    isbnNumbers.setIsbn13("@Alternative isbn 13");
    isbnNumbers.setIsbn10("@Alternative isbn 10");
    return isbnNumbers;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
