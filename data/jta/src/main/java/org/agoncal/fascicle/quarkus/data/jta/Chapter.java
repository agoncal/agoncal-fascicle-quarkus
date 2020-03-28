package org.agoncal.fascicle.quarkus.data.jta;

import javax.persistence.Embeddable;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
@Embeddable
public class Chapter {

  private String title;
  private String description;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on

  // ======================================
  // =            Constructors            =
  // ======================================

  public Chapter(String title) {
    this.title = title;
  }

  public Chapter() {
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Chapter title(String title) {
    this.title = title;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Chapter description(String description) {
    this.description = description;
    return this;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    return "Chapter{" +
      "title='" + title + '\'' +
      ", description='" + description + '\'' +
      '}';
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
