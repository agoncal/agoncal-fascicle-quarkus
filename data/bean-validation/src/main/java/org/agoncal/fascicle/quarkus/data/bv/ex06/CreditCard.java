package org.agoncal.fascicle.quarkus.data.bv.ex06;

import jakarta.validation.constraints.NotNull;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CreditCard {

  // ======================================
  // =             Attributes             =
  // ======================================

  @NotNull
  private String number;
  @NotNull
  private String expiryDate;
  @NotNull
  private Integer controlNumber;
  private String type;

  // ======================================
  // =            Constructors            =
  // ======================================

  public CreditCard() {
  }

  public CreditCard(String number, String expiryDate, Integer controlNumber, String type) {
    this.number = number;
    this.expiryDate = expiryDate;
    this.controlNumber = controlNumber;
    this.type = type;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public Integer getControlNumber() {
    return controlNumber;
  }

  public void setControlNumber(Integer controlNumber) {
    this.controlNumber = controlNumber;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
