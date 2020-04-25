package org.agoncal.fascicle.quarkus.data.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
public class Musician extends Artist {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Column(name = "preferred_instrument")
  private String preferredInstrument;

  @ManyToMany
  @JoinTable(name = "musician_cd", joinColumns = @JoinColumn(name = "musician_fk"), inverseJoinColumns = @JoinColumn(name = "cd_fk"))
  private Set<CD> cds = new HashSet<>();

  public String getPreferredInstrument() {
    return preferredInstrument;
  }

  public void setPreferredInstrument(String preferredInstrument) {
    this.preferredInstrument = preferredInstrument;
  }

  public Set<CD> getCds() {
    return cds;
  }

  public void setCds(Set<CD> cds) {
    this.cds = cds;
  }
}
