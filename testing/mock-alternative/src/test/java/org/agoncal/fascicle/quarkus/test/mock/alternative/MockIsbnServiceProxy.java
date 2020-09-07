// tag::adocTest[]
package org.agoncal.fascicle.quarkus.test.mock.alternative;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

// tag::adocSnippet[]
@Alternative
@Priority(1)
@ApplicationScoped
@RestClient
public class MockIsbnServiceProxy implements IsbnServiceProxy {
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
