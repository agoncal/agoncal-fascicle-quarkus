package org.agoncal.fascicle.quarkus.data.bv.ex11;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class Address {

  @NotNull
  public String street;
  @NotNull
  public String city;
  @NotNull @Size(max = 5)
  public String zipcode;

  // tag::adocSkip[]
  // @formatter:on

  // ======================================
  // =          Getters & Setters         =
  // ======================================
  public Address street(String street) {
    this.street = street;
    return this;
  }

  public Address city(String city) {
    this.city = city;
    return this;
  }

  public Address zipcode(String zipcode) {
    this.zipcode = zipcode;
    return this;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
