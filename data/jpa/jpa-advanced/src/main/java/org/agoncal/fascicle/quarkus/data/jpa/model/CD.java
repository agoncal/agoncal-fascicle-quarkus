package org.agoncal.fascicle.quarkus.data.jpa.model;

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
@Entity
public class CD extends Item {

  @Column(name = "total_duration")
  private Float totalDuration;

  @Column(name = "music_company")
  private String musicCompany;

  private String genre;

  @ManyToMany
  @JoinTable(name = "cd_musician", joinColumns = @JoinColumn(name = "cd_fk"), inverseJoinColumns = @JoinColumn(name = "musician_fk"))
  private Set<Musician> musicians = new HashSet<>();

  public Float getTotalDuration() {
    return totalDuration;
  }

  public void setTotalDuration(Float totalDuration) {
    this.totalDuration = totalDuration;
  }

  public String getMusicCompany() {
    return musicCompany;
  }

  public void setMusicCompany(String musicCompany) {
    this.musicCompany = musicCompany;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public Set<Musician> getMusicians() {
    return musicians;
  }

  public void setMusicians(Set<Musician> musicians) {
    this.musicians = musicians;
  }
}
