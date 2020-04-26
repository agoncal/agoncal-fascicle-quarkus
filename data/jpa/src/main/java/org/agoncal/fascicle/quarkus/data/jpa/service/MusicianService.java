package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Musician;
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
public class MusicianService {

  private static final Logger LOGGER = Logger.getLogger(MusicianService.class);

  @Inject
  EntityManager em;

  @Transactional(REQUIRED)
  public Musician persistMusician(Musician musician) {
    em.persist(musician);
    return musician;
  }

  public List<Musician> findAllMusicians() {
    return em.createQuery("select m from Musician m", Musician.class).getResultList();
  }

  public Optional<Musician> findMusicianById(Long id) {
    Musician musician = em.find(Musician.class, id);
    return musician != null ? Optional.of(musician) : Optional.empty();
  }

  @Transactional(REQUIRED)
  public Musician updateMusician(Musician musician) {
    return em.merge(musician);
  }

  @Transactional(REQUIRED)
  public void deleteMusician(Long id) {
    em.remove(em.find(Musician.class, id));
  }
}
