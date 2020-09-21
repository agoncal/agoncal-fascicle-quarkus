package org.agoncal.fascicle.quarkus.test.transactional;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
public class Musician extends PanacheEntity {

  @Column(name = "first_name", length = 50)
  public String firstName;

  @Column(name = "last_name", length = 50)
  public String lastName;

  @Column(length = 5000)
  public String bio;

  @Column(name = "date_of_birth")
  public LocalDate dateOfBirth;

  @Column(name = "preferred_instrument")
  public String preferredInstrument;
}
