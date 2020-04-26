package org.agoncal.fascicle.quarkus.data.panache.repository;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.agoncal.fascicle.quarkus.data.panache.model.Musician;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
public class MusicianRepository implements PanacheRepository<Musician> {

  @Transactional(REQUIRED)
  public Musician update(Musician musician) {
    return Panache.getEntityManager().merge(musician);
  }
}
