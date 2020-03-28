package org.agoncal.fascicle.quarkus.data.panacherepositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class Author {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "first_name", length = 50)
  private String firstName;
  @Column(name = "last_name", nullable = false)
  private String lastName;
  @Column(length = 2000)
  private String bio;
  private String email;

  @ManyToMany(mappedBy = "authors")
  private List<Book> books = new ArrayList<>();

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on

  // ======================================
  // =          Getters & Setters         =
  // ======================================

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

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  public Author book(Book book) {
    this.books.add(book);
    return this;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    return "Author{" +
      "id=" + id +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", bio='" + bio + '\'' +
      ", email='" + email + '\'' +
      '}';
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
