package org.agoncal.fascicle.quarkus.http.jsonb.custom;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbNumberFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import java.time.LocalDate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Book {

  @JsonbProperty(value = "book_title", nillable = false)
  private String title;
  @JsonbNumberFormat("#0.00")
  private Float price;
  private String isbn;
  @JsonbProperty(value = "nb_of_pages", nillable = true)
  private Integer nbOfPages;
  private Boolean illustrations;
  @JsonbTransient
  private String description;
  @JsonbDateFormat("dd/MM/yyyy")
  private LocalDate publicationDate;

  // Constructors, getters, setters
  // tag::adocSkip[]

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Book title(String title) {
    this.title = title;
    return this;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Book price(Float price) {
    this.price = price;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Book description(String description) {
    this.description = description;
    return this;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Book isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  public Integer getNbOfPages() {
    return nbOfPages;
  }

  public void setNbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
  }

  public Book nbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
    return this;
  }

  public Boolean getIllustrations() {
    return illustrations;
  }

  public void setIllustrations(Boolean illustrations) {
    this.illustrations = illustrations;
  }

  public Book illustrations(Boolean illustrations) {
    this.illustrations = illustrations;
    return this;
  }

  public LocalDate getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(LocalDate publicationDate) {
    this.publicationDate = publicationDate;
  }

  public Book publicationDate(LocalDate publicationDate) {
    this.publicationDate = publicationDate;
    return this;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
