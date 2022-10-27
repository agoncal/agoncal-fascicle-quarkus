package org.agoncal.fascicle.quarkus.data.panacheentity.model;

import io.quarkus.panache.common.Sort;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import java.util.List;
import java.util.Optional;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Entity
public class Author extends Artist {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Column(name = "preferred_Language")
  @Enumerated
  public Language preferredLanguage;

  // ======================================
  // =              Methods               =
  // ======================================

  public static Optional<Author> findByName(String name) {
    return find("lastName", name).firstResultOptional();
  }

  public static List<Author> findAllOrderByName() {
    return listAll(Sort.by("firstName").and("lastName"));
  }
}
