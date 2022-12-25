package org.agoncal.fascicle.quarkus.data.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Artist {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Long id;

  @Column(name = "first_name", length = 50)
  protected String firstName;

  @Column(name = "last_name", length = 50)
  protected String lastName;

  @Column(length = 5000)
  protected String bio;

  @Column(name = "date_of_birth")
  protected LocalDate dateOfBirth;

  @Transient
  protected Integer age;

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
