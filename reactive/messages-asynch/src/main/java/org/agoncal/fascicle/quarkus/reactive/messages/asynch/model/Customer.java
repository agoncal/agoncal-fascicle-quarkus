package org.agoncal.fascicle.quarkus.reactive.messages.asynch.model;

import jakarta.json.bind.annotation.JsonbProperty;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class Customer extends Person {

  public String email;
  @JsonbProperty("phone_number")
  public String phoneNumber;

  public Customer() {
  }

  public Customer(String firstName, String lastName, String email, String phoneNumber, Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.shippingAddress = address;
  }

  @Override
  public String toString() {
    return "Customer{" +
      "email='" + email + '\'' +
      ", phoneNumber='" + phoneNumber + '\'' +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", shippingAddress=" + shippingAddress +
      '}';
  }
}
