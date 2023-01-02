// tag::adocTest[]
package org.agoncal.fascicle.quarkus.restclient.book;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;

// tag::adocSnippet[]
@Mock
@ApplicationScoped
@RestClient
public class MockIsbnProxy implements IsbnProxy {

  @Override
  public IsbnNumber generateIsbn(boolean separator) {
    IsbnNumber isbnNumber = new IsbnNumber();
    isbnNumber.isbn13 = "dummy isbn 13";
    isbnNumber.gs1 = "dummy gs1";
    return isbnNumber;
  }
}
// end::adocSnippet[]
