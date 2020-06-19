package org.agoncal.fascicle.quarkus.data.panacherepository.service;

import io.quarkus.hibernate.orm.panache.Panache;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.Musician;
import org.agoncal.fascicle.quarkus.data.panacherepository.repository.MusicianRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class MusicianService {

  @Inject
  MusicianRepository repository;

  @Transactional(REQUIRED)
  public Musician persist(Musician musician) {
    repository.persist(musician);
    return musician;
  }

  public List<Musician> findAll() {
    return repository.listAll();
  }

  public Optional<Musician> findByIdOptional(Long id) {
    return repository.findByIdOptional(id);
  }

  @Transactional(REQUIRED)
  public Musician update(Musician musician) {
    return Panache.getEntityManager().merge(musician);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
