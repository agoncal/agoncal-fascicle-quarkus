package org.agoncal.fascicle.quarkus.data.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agoncal.fascicle.quarkus.data.panache.model.Musician;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
@Transactional(REQUIRED)
public class MusicianRepository implements PanacheRepository<Musician> {

  private static final Logger LOGGER = Logger.getLogger(MusicianRepository.class);

  public Musician updateMusician(Musician musician) {
    Musician entity = Musician.findById(musician.id);
    entity.firstName = musician.firstName;
    entity.lastName = musician.lastName;
    entity.bio = musician.bio;
    entity.dateOfBirth = musician.dateOfBirth;
    entity.preferredInstrument = musician.preferredInstrument;
    return entity;
  }
}
