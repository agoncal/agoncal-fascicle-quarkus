package org.agoncal.fascicle.quarkus.test.restassured;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Customers extends ArrayList<Customer> {

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public List<Customer> getCustomers() {
    return this;
  }
}
