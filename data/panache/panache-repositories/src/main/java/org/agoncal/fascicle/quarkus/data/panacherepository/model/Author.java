package org.agoncal.fascicle.quarkus.data.panacherepository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;

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
