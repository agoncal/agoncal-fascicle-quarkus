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
  private String street;
  @NotNull
  private String city;
  @NotNull @Size(max = 5)
  private String zipcode;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Address street(String street) {
    this.street = street;
    return this;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Address city(String city) {
    this.city = city;
    return this;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public Address zipcode(String zipcode) {
    this.zipcode = zipcode;
    return this;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
