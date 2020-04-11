package org.agoncal.fascicle.quarkus.core.cdi.qualifiers;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class Book {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String title;
  private Float price;
  private String description;
  private String isbn;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Book() {
  }

  public Book(String title, Float price, String description) {
    this.title = title;
    this.price = price;
    this.description = description;
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

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
}
