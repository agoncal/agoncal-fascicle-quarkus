package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Musician;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRED)
public class MusicianService {

  private static final Logger LOGGER = Logger.getLogger(MusicianService.class);

  public Musician persistMusician(Musician musician) {
    Musician.persist(musician);
    return musician;
  }

  @Transactional(SUPPORTS)
  public List<Musician> findAllMusicians() {
    return Musician.listAll();
  }

  @Transactional(SUPPORTS)
  public Optional<Musician> findMusicianById(Long id) {
    return Musician.findByIdOptional(id);
  }

  public Musician updateMusician(Musician musician) {
    Musician entity = Musician.findById(musician.id);
    entity.firstName = musician.firstName;
    entity.lastName = musician.lastName;
    entity.bio = musician.bio;
    entity.dateOfBirth = musician.dateOfBirth;
    entity.preferredInstrument = musician.preferredInstrument;
    return entity;
  }

  public void deleteMusician(Long id) {
    Musician musician = Musician.findById(id);
    musician.delete();
  }
}
