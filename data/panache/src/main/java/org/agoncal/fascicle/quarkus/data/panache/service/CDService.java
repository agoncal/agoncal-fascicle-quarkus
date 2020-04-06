package org.agoncal.fascicle.quarkus.data.panache.service;

import org.agoncal.fascicle.quarkus.data.panache.model.CD;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRED)
public class CDService {

  private static final Logger LOGGER = Logger.getLogger(CDService.class);

  public CD persistCD(CD cd) {
    CD.persist(cd);
    return cd;
  }

  @Transactional(SUPPORTS)
  public List<CD> findAllCDs() {
    return CD.listAll();
  }

  @Transactional(SUPPORTS)
  public Optional<CD> findCDById(Long id) {
    return CD.findByIdOptional(id);
  }

  public CD updateCD(CD cd) {
    CD entity = CD.findById(cd.id);
    entity.title = cd.title;
    entity.description = cd.description;
    entity.unitCost = cd.unitCost;
    entity.totalDuration = cd.totalDuration;
    entity.musicCompany = cd.musicCompany;
    entity.genre = cd.genre;
    return entity;
  }

  public void deleteCD(Long id) {
    CD cd = CD.findById(id);
    cd.delete();
  }

  public List<CD> findLikeGenre(String genre){
    return CD.findLikeGenre(genre);
  }
}
