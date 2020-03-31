package org.agoncal.fascicle.quarkus.data.jta;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.persistence.CascadeType.PERSIST;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
@NamedQuery(name = "findAllBooks", query = "SELECT b FROM Book b")
@NamedQuery(name = "findBookH2G2", query = "SELECT b FROM Book b WHERE b.title ='H2G2'")
public class Book extends Item {

  @Column(nullable = false, unique = true)
  private String isbn;
  @Column(name = "nb_Of_pages")
  private Integer nbOfPages;
  private Boolean illustrations;

  @ElementCollection
  @CollectionTable(name = "tags",
    joinColumns = {@JoinColumn(name = "book_fk")}
  )
  @Column(name = "value")
  private List<String> tags = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "book_chapters",
    joinColumns = {@JoinColumn(name = "book_fk")}
  )
  @MapKeyColumn(name = "position")
  private Map<Integer, Chapter> chapters = new HashMap<>();

  @ManyToMany(cascade = PERSIST)
  @JoinTable(name = "books_authors",
    joinColumns = {@JoinColumn(name = "book_fk")},
    inverseJoinColumns = {@JoinColumn(name = "author_fk")}
  )
  private List<Author> authors = new ArrayList<>();

  // Constructors, getters, setters
  // tag::adocSkip[]

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

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

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Book tag(String tag) {
    this.tags.add(tag);
    return this;
  }

  public Map<Integer, Chapter> getChapters() {
    return chapters;
  }

  public void setChapters(Map<Integer, Chapter> chapters) {
    this.chapters = chapters;
  }

  public Book chapter(Integer position, Chapter chapter) {
    this.chapters.put(position, chapter);
    return this;
  }

  public List<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(List<Author> authors) {
    this.authors = authors;
  }

  public Book author(Author author) {
    this.authors.add(author);
    return this;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    return "Book{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", description='" + description + '\'' +
      ", price=" + price +
      ", isbn='" + isbn + '\'' +
      ", nbOfPages=" + nbOfPages +
      ", illustrations=" + illustrations +
      ", tags=" + tags +
      ", chapters=" + chapters +
      ", authors=" + authors +
      '}';
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
