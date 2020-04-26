package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.CD;
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
public class CDService {

  private static final Logger LOGGER = Logger.getLogger(CDService.class);

  @Inject
  EntityManager em;

  @Transactional(REQUIRED)
  public CD persistCD(CD cd) {
    em.persist(cd);
    return cd;
  }

  public List<CD> findAllCDs() {
    return em.createQuery("select c from CD c", CD.class).getResultList();
  }

  public Optional<CD> findCDById(Long id) {
    CD cd = em.find(CD.class, id);
    return cd != null ? Optional.of(cd) : Optional.empty();
  }

  @Transactional(REQUIRED)
  public CD updateCD(CD cd) {
    return em.merge(cd);
  }

  @Transactional(REQUIRED)
  public void deleteCD(Long id) {
    em.remove(em.find(CD.class, id));
  }

  public List<CD> findLikeGenre(String genre) {
    List<CD> cds = em.createQuery("SELECT c FROM CD c WHERE c.genre like :genre", CD.class)
      .setParameter("genre", "%" + genre + "%")
      .getResultList();
    return cds;
  }
}
