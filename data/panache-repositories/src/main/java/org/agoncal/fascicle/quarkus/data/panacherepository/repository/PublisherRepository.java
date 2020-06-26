package org.agoncal.fascicle.quarkus.data.panacherepository.repository;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Publisher;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

// tag::adocSnippet[]
@ApplicationScoped
public class PublisherRepository implements PanacheRepository<Publisher> {

  // tag::adocSkip[]
  public Publisher update(Publisher publisher) {
    return Panache.getEntityManager().merge(publisher);
  }

  // end::adocSkip[]
  public Optional<Publisher> findByName(String name) {
    return find("name", name).firstResultOptional();
  }

  public long deleteByName(String name) {
    return delete("name", name);
  }
}
// end::adocSnippet[]
