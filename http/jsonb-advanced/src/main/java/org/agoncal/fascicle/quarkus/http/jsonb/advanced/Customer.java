package org.agoncal.fascicle.quarkus.http.jsonb.advanced;

import javax.json.bind.annotation.JsonbProperty;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class Customer {

  @JsonbProperty("first_name")
  private String firstName;
  @JsonbProperty("last_name")
  private String lastName;
  private String email;
  @JsonbProperty("phone_number")
  private String phoneNumber;

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Customer firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Customer lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Customer email(String email) {
    this.email = email;
    return this;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Customer phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }
}
