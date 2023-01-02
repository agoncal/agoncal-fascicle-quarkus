package org.agoncal.fascicle.quarkus.data.panacheentity.service;

import io.quarkus.hibernate.orm.panache.Panache;
import org.agoncal.fascicle.quarkus.data.panacheentity.model.Publisher;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

// tag::adocSnippet[]
@ApplicationScoped
@Transactional(SUPPORTS)
public class PublisherService {

  @Transactional(REQUIRED)
  public Publisher persist(Publisher publisher) {
    Publisher.persist(publisher);
    return publisher;
  }

  public List<Publisher> findAll() {
    return Publisher.listAll();
  }

  public Optional<Publisher> findByIdOptional(Long id) {
    return Publisher.findByIdOptional(id);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    Publisher.deleteById(id);
  }
  // tag::adocSkip[]

  @Transactional(REQUIRED)
  public Publisher update(Publisher publisher) {
    return Panache.getEntityManager().merge(publisher);
  }

  public Optional<Publisher> findByName(String name) {
    return Publisher.findByName(name);
  }

  @Transactional(REQUIRED)
  public long deleteByName(String name) {
    return Publisher.deleteByName(name);
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
