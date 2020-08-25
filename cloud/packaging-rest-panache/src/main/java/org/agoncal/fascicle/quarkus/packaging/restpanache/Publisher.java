package org.agoncal.fascicle.quarkus.packaging.restpanache;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
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
