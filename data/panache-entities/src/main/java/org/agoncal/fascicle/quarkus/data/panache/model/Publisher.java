package org.agoncal.fascicle.quarkus.data.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Entity
public class Publisher extends PanacheEntity {

  @Column(length = 30)
  public String name;

  public static Publisher findByName(String name) {
    Publisher publisher = find("name", name).firstResult();
    return publisher;
  }

  public static void deleteAPress() {
    delete("name", "APress");
  }
}
