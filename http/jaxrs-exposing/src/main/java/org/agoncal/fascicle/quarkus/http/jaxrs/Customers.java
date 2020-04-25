package org.agoncal.fascicle.quarkus.http.jaxrs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class Customers extends ArrayList<Customer> {

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public List<Customer> getCustomers() {
    return this;
  }
}
