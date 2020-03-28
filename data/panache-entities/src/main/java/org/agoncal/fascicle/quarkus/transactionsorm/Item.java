package org.agoncal.fascicle.quarkus.transactionsorm;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@MappedSuperclass
public class Item extends PanacheEntity {

  @NotNull
  public String title;
  @Size(max = 512)
  public String description;
  public Float price;

}
// end::adocSnippet[]
