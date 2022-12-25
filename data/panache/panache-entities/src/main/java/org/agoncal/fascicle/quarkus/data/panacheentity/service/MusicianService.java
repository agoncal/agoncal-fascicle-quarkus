package org.agoncal.fascicle.quarkus.data.panacheentity.service;

import io.quarkus.hibernate.orm.panache.Panache;
import org.agoncal.fascicle.quarkus.data.panacheentity.model.Musician;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class MusicianService {

  @Transactional(REQUIRED)
  public Musician persist(Musician musician) {
    Musician.persist(musician);
    return musician;
  }

  public List<Musician> findAll() {
    return Musician.listAll();
  }

  public Optional<Musician> findByIdOptional(Long id) {
    return Musician.findByIdOptional(id);
  }

  @Transactional(REQUIRED)
  public Musician update(Musician musician) {
    return Panache.getEntityManager().merge(musician);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    Musician.deleteById(id);
  }
}
