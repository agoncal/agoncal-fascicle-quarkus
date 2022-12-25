package org.agoncal.fascicle.quarkus.data.panacherepository.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class Publisher extends PanacheEntity {

  @Column(length = 30)
  public String name;
}
// end::adocSnippet[]
