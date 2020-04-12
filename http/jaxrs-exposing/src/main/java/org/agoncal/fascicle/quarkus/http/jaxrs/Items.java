package org.agoncal.fascicle.quarkus.http.jaxrs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Items extends ArrayList<Item> {

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public List<Item> getItems() {
    return this;
  }
}
