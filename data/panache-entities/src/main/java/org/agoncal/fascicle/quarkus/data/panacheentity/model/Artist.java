package org.agoncal.fascicle.quarkus.data.panacheentity.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@MappedSuperclass
public class Artist extends PanacheEntity {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Column(name = "first_name", length = 50)
  public String firstName;

  @Column(name = "last_name", length = 50)
  public String lastName;

  @Column(length = 5000)
  public String bio;

  @Column(name = "date_of_birth")
  public LocalDate dateOfBirth;

  @Transient
  public Integer age;

  // ======================================
  // =     Lifecycle Callback Methods     =
  // ======================================

  @PostLoad
  @PostPersist
  @PostUpdate
  protected void calculateAge() {
    if (dateOfBirth == null) {
      age = null;
      return;
    }

    age = Period.between(dateOfBirth, LocalDate.now()).getYears();
  }
}
