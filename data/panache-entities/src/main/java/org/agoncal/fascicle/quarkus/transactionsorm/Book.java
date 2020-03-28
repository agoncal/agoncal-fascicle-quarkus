package org.agoncal.fascicle.quarkus.transactionsorm;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.validation.constraints.Min;
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
public class Book extends Item {

  @Column(nullable = false, unique = true)
  public String isbn;
  @Column(name = "nb_Of_pages")
  @Min(10)
  public Integer nbOfPages;
  public Boolean illustrations;

  @ElementCollection
  @CollectionTable(name = "tags",
    joinColumns = {@JoinColumn(name = "book_fk")}
  )
  @Column(name = "value")
  public List<String> tags = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "book_chapters",
    joinColumns = {@JoinColumn(name = "book_fk")}
  )
  @MapKeyColumn(name = "position")
  public Map<Integer, Chapter> chapters = new HashMap<>();

  @ManyToMany(cascade = PERSIST)
  @JoinTable(name = "books_authors",
    joinColumns = {@JoinColumn(name = "book_fk")},
    inverseJoinColumns = {@JoinColumn(name = "author_fk")}
  )
  public List<Author> authors = new ArrayList<>();

  // Constructors, getters, setters
  // tag::adocSkip[]

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Book title(String title) {
    this.title = title;
    return this;
  }

  public Book price(Float price) {
    this.price = price;
    return this;
  }

  public Book description(String description) {
    this.description = description;
    return this;
  }

  public Book isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  public Book nbOfPages(Integer nbOfPages) {
    this.nbOfPages = nbOfPages;
    return this;
  }

  public Book illustrations(Boolean illustrations) {
    this.illustrations = illustrations;
    return this;
  }

  public Book tag(String tag) {
    this.tags.add(tag);
    return this;
  }

  public Book chapter(Integer position, Chapter chapter) {
    this.chapters.put(position, chapter);
    return this;
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
