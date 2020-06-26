package org.agoncal.fascicle.quarkus.data.panacherepository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Entity
public class Author extends Artist {

  @Column(name = "preferred_Language")
  @Enumerated
  public Language preferredLanguage;
}
