package org.agoncal.fascicle.quarkus.transactionsorm;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class Author extends PanacheEntity {

  @Column(name = "first_name", length = 50)
  public String firstName;
  @Column(name = "last_name", nullable = false)
  public String lastName;
  @Column(length = 2000)
  public  String bio;
  @Email
  public  String email;

  @ManyToMany(mappedBy = "authors")
  public List<Book> books = new ArrayList<>();

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Author firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Author lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Author bio(String bio) {
    this.bio = bio;
    return this;
  }

  public Author email(String email) {
    this.email = email;
    return this;
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
