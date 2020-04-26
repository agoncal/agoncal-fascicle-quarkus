package org.agoncal.fascicle.quarkus.data.panache.service;

import io.quarkus.hibernate.orm.panache.Panache;
import org.agoncal.fascicle.quarkus.data.panache.model.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

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
  public Publisher update(Publisher publisher) {
    return Panache.getEntityManager().merge(publisher);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    Publisher.deleteById(id);
  }

  public Optional<Publisher> findByName(String name) {
    return Publisher.findByName(name);
  }

  @Transactional(REQUIRED)
  public long deleteByName(String name) {
    return Publisher.deleteByName(name);
  }
}
