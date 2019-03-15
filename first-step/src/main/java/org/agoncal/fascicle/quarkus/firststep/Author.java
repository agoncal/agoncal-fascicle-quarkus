package org.agoncal.fascicle.quarkus.firststep;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// @formatter:off
// tag::adocSnippet[]
@Entity
public class Author {

  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false, length = 50)
  private String firstName;
  private String lastName;
  @Column(length = 2000)
  private String bio;
  private String email;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on
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

  public Author firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Author lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public Author surnbioame(String bio) {
    this.bio = bio;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Author email(String email) {
    this.email = email;
    return this;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
