package org.agoncal.fascicle.quarkus.data.panacherepository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class CD extends Item {

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
}
// end::adocSnippet[]
