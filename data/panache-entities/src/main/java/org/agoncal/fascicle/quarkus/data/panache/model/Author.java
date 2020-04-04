package org.agoncal.fascicle.quarkus.data.panache.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
public class Author extends Artist {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Column(name = "preferred_Language")
  @Enumerated
  private Language preferredLanguage;

  public Author() {
  }

  public Author(String firstName, String lastName, String bio, Date dateOfBirth, Language language) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.bio = bio;
    this.dateOfBirth = dateOfBirth;
    this.preferredLanguage = language;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Language getPreferredLanguage() {
    return preferredLanguage;
  }

  public void setPreferredLanguage(Language preferredLanguage) {
    this.preferredLanguage = preferredLanguage;
  }

  // ======================================
  // =    hashcode, equals & toString     =
  // ======================================

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Author author = (Author) o;

    if (preferredLanguage != author.preferredLanguage) return false;

    return true;
  }
}
