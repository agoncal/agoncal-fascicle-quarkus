package org.agoncal.fascicle.quarkus.data.panacherepository.repository;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agoncal.fascicle.quarkus.data.panacherepository.model.CD;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CDRepository implements PanacheRepository<CD>  {

  public CD update(CD cd) {
    return Panache.getEntityManager().merge(cd);
  }

  public List<CD> findLikeGenre(String genre){
    return list("genre like ?1", "%" + genre + "%");
  }
}
