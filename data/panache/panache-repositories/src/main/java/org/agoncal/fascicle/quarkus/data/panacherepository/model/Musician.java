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
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
public class Musician extends Artist {

  @Column(name = "preferred_instrument")
  public String preferredInstrument;

  @ManyToMany
  @JoinTable(name = "musician_cd", joinColumns = @JoinColumn(name = "musician_fk"), inverseJoinColumns = @JoinColumn(name = "cd_fk"))
  public Set<CD> cds = new HashSet<>();
}
