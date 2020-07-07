// tag::adocTest[]
package org.agoncal.fascicle.quarkus.faulttolerance.book;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

// tag::adocSnippet[]
@Mock
@ApplicationScoped
@RestClient
public class MockNumberService implements NumberService {

  @Override
  public IsbnNumber generateIsbn(boolean separator) {
    IsbnNumber isbnNumber = new IsbnNumber();
    isbnNumber.isbn13 = "dummy isbn 13";
    isbnNumber.gs1 = "dummy gs1";
    return isbnNumber;
  }
}
// end::adocSnippet[]
