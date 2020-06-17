package org.agoncal.fascicle.quarkus.data.panache.model;

import io.quarkus.panache.common.Parameters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
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
  public String isbn;

  @Column(name = "nb_of_pages")
  public Integer nbOfPage;

  @Column(name = "publication_date")
  public Instant publicationDate;

  @Enumerated(EnumType.STRING)
  public Language language;

  @OneToMany
  @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_fk"), inverseJoinColumns = @JoinColumn(name = "author_fk"))
  public Set<Author> authors = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "publisher_pk")
  public Publisher publisher;

  // ======================================
  // =              Methods               =
  // ======================================

  public static List<Book> findEnglishBooks(){
    List<Book> books = list("language", Language.ENGLISH);
    return books;
  }

  public static long countEnglishBooks(){
    long nbBooks = count("language", Language.ENGLISH);
    return nbBooks;
  }

  public static List<Book> findBetweenPrices(Float min, Float max) {
    List<Book> books = list("unitCost between :min and :max",
      Parameters.with("min", min).and("max", max));
    return books;
  }
}
