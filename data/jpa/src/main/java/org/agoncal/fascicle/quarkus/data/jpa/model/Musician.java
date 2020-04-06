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
  public String preferredInstrument;

  @ManyToMany
  @JoinTable(name = "musician_cd", joinColumns = @JoinColumn(name = "musician_fk"), inverseJoinColumns = @JoinColumn(name = "cd_fk"))
  public Set<CD> cds = new HashSet<>();
}
