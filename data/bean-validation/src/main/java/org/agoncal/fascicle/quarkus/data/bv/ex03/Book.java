package org.agoncal.fascicle.quarkus.data.bv.ex03;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Book {

  private String title;
  private Float price;
  private String description;
  private Integer isbn;
  private Integer nbOfPages;
  private String authorEmail;

  @NotNull
  public String getTitle() {
    return title;
  }

  @Digits(integer = 4, fraction = 2)
  public Float getPrice() {
    return price;
  }

  @Size(max = 2000)
  public String getDescription() {
    return description;
  }

  public Integer getIsbn() {
    return isbn;
  }

  @Positive
  public Integer getNbOfPages() {
    return nbOfPages;
  }

  @Email
  public String getAuthorEmail() {
    return authorEmail;
  }

  // Setters
  // tag::adocSkip[]
  public void setTitle(String title) {
    this.title = title;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setIsbn(Integer isbn) {
    this.isbn = isbn;
  }

  public void setNbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
  }

  public void setAuthorEmail(String authorEmail) {
    this.authorEmail = authorEmail;
  }

  public Book() {
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
