package org.agoncal.fascicle.quarkus.test.hamcrest;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Objects;

public class Book {

  private String title;
  private String isbn13;
  private String isbn10;
  private String author;
  private Integer yearOfPublication;
  private Integer nbOfPages;
  private Integer rank;
  private BigDecimal price;
  private URL smallImageUrl;
  private URL mediumImageUrl;
  private String description;

  public Book(String title) {
    this.title = title;
  }

  public Book(String title, Integer yearOfPublication, Integer nbOfPages) {
    this.title = title;
    this.yearOfPublication = yearOfPublication;
    this.nbOfPages = nbOfPages;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn13() {
    return isbn13;
  }

  public void setIsbn13(String isbn13) {
    this.isbn13 = isbn13;
  }

  public String getIsbn10() {
    return isbn10;
  }

  public void setIsbn10(String isbn10) {
    this.isbn10 = isbn10;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Integer getYearOfPublication() {
    return yearOfPublication;
  }

  public void setYearOfPublication(Integer yearOfPublication) {
    this.yearOfPublication = yearOfPublication;
  }

  public Integer getNbOfPages() {
    return nbOfPages;
  }

  public void setNbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
  }

  public Integer getRank() {
    return rank;
  }

  public void setRank(Integer rank) {
    this.rank = rank;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public URL getSmallImageUrl() {
    return smallImageUrl;
  }

  public void setSmallImageUrl(URL smallImageUrl) {
    this.smallImageUrl = smallImageUrl;
  }

  public URL getMediumImageUrl() {
    return mediumImageUrl;
  }

  public void setMediumImageUrl(URL mediumImageUrl) {
    this.mediumImageUrl = mediumImageUrl;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return Objects.equals(title, book.title) &&
      Objects.equals(isbn13, book.isbn13) &&
      Objects.equals(isbn10, book.isbn10) &&
      Objects.equals(author, book.author) &&
      Objects.equals(yearOfPublication, book.yearOfPublication) &&
      Objects.equals(nbOfPages, book.nbOfPages) &&
      Objects.equals(rank, book.rank) &&
      Objects.equals(price, book.price) &&
      Objects.equals(smallImageUrl, book.smallImageUrl) &&
      Objects.equals(mediumImageUrl, book.mediumImageUrl) &&
      Objects.equals(description, book.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, isbn13, isbn10, author, yearOfPublication, nbOfPages, rank, price, smallImageUrl, mediumImageUrl, description);
  }

  @Override
  public String toString() {
    return "Book{" +
      "title='" + title + '\'' +
      ", isbn13='" + isbn13 + '\'' +
      ", isbn10='" + isbn10 + '\'' +
      ", author='" + author + '\'' +
      ", yearOfPublication=" + yearOfPublication +
      ", nbOfPages=" + nbOfPages +
      ", rank=" + rank +
      ", price=" + price +
      ", smallImageUrl=" + smallImageUrl +
      ", mediumImageUrl=" + mediumImageUrl +
      ", description='" + description + '\'' +
      '}';
  }
}
