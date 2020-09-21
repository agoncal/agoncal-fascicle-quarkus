package org.agoncal.fascicle.quarkus.test.restassured;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */

public class Customer {

  // ======================================
  // =             Attributes             =
  // ======================================

  private Long id;
  @JsonbProperty("first-name")
  private String firstName;
  @JsonbProperty("last-name")
  private String lastName;
  private String email;
  @JsonbProperty("phone-number")
  private String phoneNumber;
  @JsonbProperty("date-of-birth")
  private LocalDate dateOfBirth;
  private Integer age;
  @JsonbTransient
  private LocalDateTime creationDate;

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Customer id(Long id) {
    this.id = id;
    return this;
  }

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

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Customer dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Customer age(Integer age) {
    this.age = age;
    return this;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public Customer creationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    return "Customer{" +
      "id='" + id + '\'' +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", email='" + email + '\'' +
      ", phoneNumber='" + phoneNumber + '\'' +
      ", dateOfBirth=" + dateOfBirth +
      ", age=" + age +
      ", creationDate=" + creationDate +
      '}';
  }
}
