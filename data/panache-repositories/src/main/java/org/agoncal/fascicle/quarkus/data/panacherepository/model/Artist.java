package org.agoncal.fascicle.quarkus.data.panacherepository.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@MappedSuperclass
public class Artist extends PanacheEntity {

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
