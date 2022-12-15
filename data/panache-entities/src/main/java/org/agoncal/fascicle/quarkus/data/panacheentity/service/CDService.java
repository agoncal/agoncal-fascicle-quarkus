package org.agoncal.fascicle.quarkus.data.panacheentity.service;

import io.quarkus.hibernate.orm.panache.Panache;
import org.agoncal.fascicle.quarkus.data.panacheentity.model.CD;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static jakarta.transaction.Transactional.TxType.REQUIRED;
import static jakarta.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class CDService {

  @Transactional(REQUIRED)
  public CD persist(CD cd) {
    CD.persist(cd);
    return cd;
  }

  public List<CD> findAll() {
    return CD.listAll();
  }

  public Optional<CD> findByIdOptional(Long id) {
    return CD.findByIdOptional(id);
  }

  @Transactional(REQUIRED)
  public CD update(CD cd) {
    return Panache.getEntityManager().merge(cd);
  }

  @Transactional(REQUIRED)
  public void deleteById(Long id) {
    CD.deleteById(id);
  }

  public List<CD> findLikeGenre(String genre){
    return CD.findLikeGenre(genre);
  }
}
