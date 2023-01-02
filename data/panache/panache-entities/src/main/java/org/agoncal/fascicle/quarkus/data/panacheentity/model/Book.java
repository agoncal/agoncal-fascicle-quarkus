package org.agoncal.fascicle.quarkus.data.panacheentity.model;

import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
@Entity
public class Book extends Item {

  // tag::adocSkip[]
  // ======================================
  // =             Attributes             =
  // ======================================
  // end::adocSkip[]
  @Column(length = 15)
  public String isbn;

  @Column(name = "nb_of_pages")
  public Integer nbOfPage;

  @Column(name = "publication_date")
  public Instant publicationDate;

  @Enumerated(EnumType.STRING)
  public Language language;

  @OneToMany
  @JoinTable(name = "book_author",
    joinColumns = @JoinColumn(name = "book_fk"),
    inverseJoinColumns = @JoinColumn(name = "author_fk")
  )
  public Set<Author> authors = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "publisher_pk")
  public Publisher publisher;

  // tag::adocSkip[]
  // ======================================
  // =              Methods               =
  // ======================================
  // end::adocSkip[]
  public static List<Book> findEnglishBooks() {
    return list("language", Language.ENGLISH);
  }

  public static long countEnglishBooks() {
    return count("language", Language.ENGLISH);
  }

  public static List<Book> findBetweenPrices(Float min, Float max) {
    return list("unitCost between :min and :max",
                Parameters.with("min", min).and("max", max));
  }

  public static List<Book> findAllOrderByTitle() {
    return listAll(Sort.by("title").and("publicationDate"));
  }
}
// end::adocSnippet[]
