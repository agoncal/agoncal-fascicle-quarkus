package org.agoncal.fascicle.quarkus.data.jpa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
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
