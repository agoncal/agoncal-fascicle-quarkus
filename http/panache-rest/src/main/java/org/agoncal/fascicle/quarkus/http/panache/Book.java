package org.agoncal.fascicle.quarkus.http.panache;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Entity
public class Book extends PanacheEntity {

  public String title;
  public Float price;
  public String description;
  public String isbn;
  public Integer nbOfPage;
  public Boolean illustrations;

}
