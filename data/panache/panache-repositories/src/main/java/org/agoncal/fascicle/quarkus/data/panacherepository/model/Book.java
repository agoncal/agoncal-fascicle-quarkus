package org.agoncal.fascicle.quarkus.data.panacherepository.model;

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
}
// end::adocSnippet[]
