package org.agoncal.fascicle.quarkus.data.jta;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@MappedSuperclass
public class Item {

  @Id
  @GeneratedValue
  protected Long id;
  protected String title;
  protected String description;
  protected Float price;

  // Getters, setters
}
// end::adocSnippet[]
