package org.agoncal.fascicle.quarkus.data.panache.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
public class Book extends Item {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Column(length = 15)
  private String isbn;

  @Column(name = "nb_of_pages")
  private Integer nbOfPage;

  @Column(name = "publication_date")
  @Temporal(TemporalType.DATE)
  private Date publicationDate;

  @Enumerated(EnumType.STRING)
  private Language language;

  @OneToMany
  @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_fk"), inverseJoinColumns = @JoinColumn(name = "author_fk"))
  private Set<Author> authors = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "publisher_pk")
  private Publisher publisher;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Book() {
  }

  public Book(String title, String description, Float unitCost, String isbn, Integer nbOfPage) {
    this.title = title;
    this.description = description;
    this.unitCost = unitCost;
    this.isbn = isbn;
    this.nbOfPage = nbOfPage;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Integer getNbOfPage() {
    return nbOfPage;
  }

  public void setNbOfPage(Integer nbOfPage) {
    this.nbOfPage = nbOfPage;
  }

  public Date getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(Date publicationDate) {
    this.publicationDate = publicationDate;
  }

  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  // ======================================
  // =    hashcode, equals & toString     =
  // ======================================

}
