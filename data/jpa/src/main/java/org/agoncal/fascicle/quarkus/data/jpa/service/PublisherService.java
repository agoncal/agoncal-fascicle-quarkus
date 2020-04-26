package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Publisher;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class PublisherService {

  private static final Logger LOGGER = Logger.getLogger(PublisherService.class);

  @Inject
  EntityManager em;

  @Transactional(REQUIRED)
  public Publisher persistPublisher(Publisher publisher) {
    em.persist(publisher);
    return publisher;
  }

  public List<Publisher> findAllPublishers() {
    return em.createQuery("select p from Publisher p", Publisher.class).getResultList();
  }

  public Optional<Publisher> findPublisherById(Long id) {
    Publisher publisher = em.find(Publisher.class, id);
    return publisher != null ? Optional.of(publisher) : Optional.empty();
  }

  @Transactional(REQUIRED)
  public Publisher updatePublisher(Publisher publisher) {
    return em.merge(publisher);
  }

  @Transactional(REQUIRED)
  public void deletePublisher(Long id) {
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
}
