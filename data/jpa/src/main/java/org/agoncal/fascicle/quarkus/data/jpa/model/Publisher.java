package org.agoncal.fascicle.quarkus.data.jpa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Long id;

  @Column(length = 30)
  private String name;

//  public static Publisher findByName(String name) {
//    Publisher publisher = find("name", name).firstResult();
//    return publisher;
//  }
//
//  public static void deleteAPress() {
//    delete("name", "APress");
//  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
// end::adocSnippet[]
