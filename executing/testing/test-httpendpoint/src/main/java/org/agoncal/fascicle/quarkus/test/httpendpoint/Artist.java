package org.agoncal.fascicle.quarkus.test.httpendpoint;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.json.bind.annotation.JsonbProperty;

import java.util.Objects;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@RegisterForReflection
public class Artist {

  private Integer id;
  @JsonbProperty("first_name")
  private String firstName;
  @JsonbProperty("last_name")
  private String lastName;

  // Constructors, getters, setters
  // tag::adocSkip[]

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Artist id(Integer id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Artist firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Artist lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Artist artist = (Artist) o;
    return id.equals(artist.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Artist{" +
      "id='" + id + '\'' +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      '}';
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
