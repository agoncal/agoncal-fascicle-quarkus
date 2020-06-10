package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Musician;

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
public class MusicianService {

  @Inject
  EntityManager em;

  @Transactional(REQUIRED)
  public Musician persist(Musician musician) {
    em.persist(musician);
    return musician;
  }

  public List<Musician> findAll() {
    return em.createQuery("select m from Musician m", Musician.class).getResultList();
  }

  public Optional<Musician> findByIdOptional(Long id) {
    Musician musician = em.find(Musician.class, id);
    return musician != null ? Optional.of(musician) : Optional.empty();
  }
  // tag::adocSkip[]

  @Transactional(REQUIRED)
  public Musician update(Musician musician) {
    return em.merge(musician);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    em.remove(em.find(Musician.class, id));
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
