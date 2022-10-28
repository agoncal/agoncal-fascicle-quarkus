package org.agoncal.fascicle.quarkus.test.profile;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@Entity
public class Publisher extends PanacheEntity {

  @JsonbProperty(value = "publisher_name", nillable = false)
  @Column(length = 30)
  @NotNull
  public String name;

  // ======================================
  // =              Methods               =
  // ======================================

  public static Optional<Publisher> findByName(String name) {
    return find("name", name).firstResultOptional();
  }

  public static long deleteByName(String name) {
    return delete("name", name);
  }
}
