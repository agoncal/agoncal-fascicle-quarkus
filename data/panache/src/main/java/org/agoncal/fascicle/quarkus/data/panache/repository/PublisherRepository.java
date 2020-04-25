package org.agoncal.fascicle.quarkus.data.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agoncal.fascicle.quarkus.data.panache.model.Publisher;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
@Transactional(REQUIRED)
public class PublisherRepository implements PanacheRepository<Publisher> {

  private static final Logger LOGGER = Logger.getLogger(PublisherRepository.class);

  public Publisher updatePublisher(Publisher publisher) {
    Publisher entity = Publisher.findById(publisher.id);
    entity.name = publisher.name;
    return entity;
  }

  public Publisher findByName(String name) {
    return Publisher.findByName(name);
  }

  public void deleteAPress() {
    Publisher.deleteAPress();
  }
}
