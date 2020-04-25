package org.agoncal.fascicle.quarkus.data.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agoncal.fascicle.quarkus.data.panache.model.CD;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
@Transactional(REQUIRED)
public class CDRepository implements PanacheRepository<CD>  {

  private static final Logger LOGGER = Logger.getLogger(CDRepository.class);

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

  public List<CD> findLikeGenre(String genre){
    return CD.findLikeGenre(genre);
  }
}
