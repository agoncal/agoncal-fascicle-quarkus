package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.CD;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class CDService {

  @Inject
  EntityManager em;

  @Transactional(REQUIRED)
  public CD persist(CD cd) {
    em.persist(cd);
    return cd;
  }

  public List<CD> findAll() {
    return em.createQuery("select c from CD c", CD.class).getResultList();
  }

  public Optional<CD> findByIdOptional(Long id) {
    CD cd = em.find(CD.class, id);
    return cd != null ? Optional.of(cd) : Optional.empty();
  }

  @Transactional(REQUIRED)
  public CD update(CD cd) {
    return em.merge(cd);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    em.remove(em.find(CD.class, id));
  }

  public List<CD> findLikeGenre(String genre) {
    List<CD> cds = em.createQuery("SELECT c FROM CD c WHERE c.genre like :genre", CD.class)
      .setParameter("genre", "%" + genre + "%")
      .getResultList();
    return cds;
  }
}
