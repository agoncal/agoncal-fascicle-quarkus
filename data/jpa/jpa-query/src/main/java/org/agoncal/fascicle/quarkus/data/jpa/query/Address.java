package org.agoncal.fascicle.quarkus.data.jpa.query;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import static jakarta.persistence.CascadeType.PERSIST;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
public class Address {

  @Id
  @GeneratedValue
  private Long id;
  private String street1;
  private String city;
  private String zipcode;
  @OneToOne(cascade = {PERSIST})
  private Country country;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public Address() {
  }

  public Address(String street1, String city, String zipcode) {
    this.street1 = street1;
    this.city = city;
    this.zipcode = zipcode;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

// end::adocSkip[]
}
// end::adocSnippet[]
