package org.agoncal.fascicle.quarkus.gettingstarted;

import java.util.Objects;
import java.util.UUID;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class Artist {

  private UUID id;
  private String firstName;
  private String lastName;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on
  public Artist() {
  }

  public Artist(UUID id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Artist(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Artist(UUID id) {
    this.id = id;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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
