package org.agoncal.fascicle.quarkus.data.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Optional;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class Publisher extends PanacheEntity {
  // tag::adocSkip[]
  // ======================================
  // =             Attributes             =
  // ======================================
  // end::adocSkip[]

  @Column(length = 30)
  public String name;

  // tag::adocSkip[]
  // ======================================
  // =              Methods               =
  // ======================================
  // end::adocSkip[]
  // tag::adocQuery[]
  public static Optional<Publisher> findByName(String name) {
    return find("name", name).firstResultOptional();
  }

  public static long deleteByName(String name) {
    return delete("name", name);
  }
  // end::adocQuery[]
}
// end::adocSnippet[]
