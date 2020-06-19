package org.agoncal.fascicle.quarkus.data.panacheentity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class CD extends Item {
  // tag::adocSkip[]
  // ======================================
  // =             Attributes             =
  // ======================================
  // end::adocSkip[]

  @Column(name = "total_duration")
  public Float totalDuration;

  @Column(name = "music_company")
  public String musicCompany;

  public String genre;

  @ManyToMany
  @JoinTable(name = "cd_musician",
    joinColumns = @JoinColumn(name = "cd_fk"),
    inverseJoinColumns = @JoinColumn(name = "musician_fk")
  )
  public Set<Musician> musicians = new HashSet<>();

  // tag::adocSkip[]
  // ======================================
  // =              Methods               =
  // ======================================
  // end::adocSkip[]
  // tag::adocQuery[]
  public static List<CD> findLikeGenre(String genre) {
    List<CD> cds = list("genre like ?1", "%" + genre + "%");
    return cds;
  }
  // end::adocQuery[]
}
// end::adocSnippet[]
