package org.agoncal.fascicle.quarkus.transactionsorm;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.MappedSuperclass;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@MappedSuperclass
public class Item extends PanacheEntity {

  String title;
  String description;
  Float price;

}
// end::adocSnippet[]
