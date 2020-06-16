package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

// tag::adocSnippet[]
@ApplicationScoped
@Transactional(SUPPORTS)
public class PublisherService {

  @Inject
  EntityManager em;

  // tag::adocException[]
  @Inject
  StatisticsService statistics;

  @Transactional(value = REQUIRED, rollbackOn = StatisticsException.class)
  public Publisher persist(Publisher publisher) throws Exception {
    em.persist(publisher);
    statistics.addNew(publisher);
    return publisher;
  }
  // end::adocException[]
  // tag::adocTransaction[]
  public List<Publisher> findAll() {
    return em.createQuery("SELECT p FROM Publisher p", Publisher.class).getResultList();
  }

  public Optional<Publisher> findByIdOptional(Long id) {
    Publisher publisher = em.find(Publisher.class, id);
    return publisher != null ? Optional.of(publisher) : Optional.empty();
  }

  @Transactional(REQUIRED)
  public Publisher update(Publisher publisher) {
    return em.merge(publisher);
  }
  // end::adocTransaction[]
  // tag::adocSkip[]
  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    em.remove(em.find(Publisher.class, id));
  }

  public Optional<Publisher> findByName(String name) {
    Publisher publisher = em.createQuery("SELECT p FROM Publisher p WHERE p.name = :name", Publisher.class)
      .setParameter("name", name)
      .getSingleResult();
    return publisher != null ? Optional.of(publisher) : Optional.empty();
  }

  @Transactional(REQUIRED)
  public int deleteByName(String name) {
    int rowsDeleted = em.createQuery("DELETE FROM Publisher p WHERE p.name = :name ")
      .setParameter("name", name)
      .executeUpdate();
    return rowsDeleted;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
