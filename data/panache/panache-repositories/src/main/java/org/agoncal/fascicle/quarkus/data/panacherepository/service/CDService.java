package org.agoncal.fascicle.quarkus.data.panacherepository.service;

import io.quarkus.hibernate.orm.panache.Panache;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.CD;
import org.agoncal.fascicle.quarkus.data.panacherepository.repository.CDRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class CDService {

  @Inject
  CDRepository repository;

  @Transactional(REQUIRED)
  public CD persist(CD cd) {
    repository.persist(cd);
    return cd;
  }

  public List<CD> findAll() {
    return repository.listAll();
  }

  public Optional<CD> findByIdOptional(Long id) {
    return repository.findByIdOptional(id);
  }

  @Transactional(REQUIRED)
  public CD update(CD cd) {
    return Panache.getEntityManager().merge(cd);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  public List<CD> findLikeGenre(String genre){
    return repository.findLikeGenre(genre);
  }
}
