package org.agoncal.fascicle.quarkus.reactive.messages.model;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class Address {

  public String street;
  public String city;
  public String zipcode;

  public Address() {
  }

  public Address(String street, String city, String zipcode) {
    this.street = street;
    this.city = city;
    this.zipcode = zipcode;
  }

  @Override
  public String toString() {
    return "Address{" +
      "street='" + street + '\'' +
      ", city='" + city + '\'' +
      ", zipcode='" + zipcode + '\'' +
      '}';
  }
}
