package org.agoncal.fascicle.quarkus.http.panache;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;

public interface BookResource extends PanacheRepositoryResource<BookRepository, Book, Long> {
}
