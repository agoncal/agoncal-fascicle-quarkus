package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Publisher;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRED)
public class PublisherService {

  private static final Logger LOGGER = Logger.getLogger(PublisherService.class);

  public Publisher persistPublisher(Publisher publisher) {
    Publisher.persist(publisher);
    return publisher;
  }

  @Transactional(SUPPORTS)
  public List<Publisher> findAllPublishers() {
    return Publisher.listAll();
  }

  @Transactional(SUPPORTS)
  public Optional<Publisher> findPublisherById(Long id) {
    return Publisher.findByIdOptional(id);
  }

  public Publisher updatePublisher(Publisher publisher) {
    Publisher entity = Publisher.findById(publisher.id);
    entity.name = publisher.name;
    return entity;
  }

  public void deletePublisher(Long id) {
    Publisher publisher = Publisher.findById(id);
    publisher.delete();
  }

  public Publisher findByName(String name) {
    return Publisher.findByName(name);
  }

  public void deleteAPress() {
    Publisher.deleteAPress();
  }
}
