package org.agoncal.fascicle.quarkus.transactionsorm;

import javax.validation.constraints.NotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class Address {

  @NotNull
  private String street1;
  private String street2;
  @NotNull
  private String city;
  private String state;
  @NotNull @ZipCode
  private String zipcode;
  private String country;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on

  // ======================================
  // =            Constructors            =
  // ======================================

  public Address() {
  }

  public Address(String street1, String city, String state, String zipcode, String country) {
    this.street1 = street1;
    this.city = city;
    this.state = state;
    this.zipcode = zipcode;
    this.country = country;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public Address street1(String street1) {
    this.street1 = street1;
    return this;
  }

  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public Address street2(String street2) {
    this.street2 = street2;
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

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Address state(String state) {
    this.state = state;
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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Address country(String country) {
    this.country = country;
    return this;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
