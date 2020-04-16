package org.agoncal.fascicle.quarkus.http.json.binding;

import javax.json.bind.annotation.JsonbProperty;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CreditCard {

  private String number;
  @JsonbProperty("expiry_date")
  private String expiryDate;
  @JsonbProperty("control_number")
  private Integer controlNumber;
  @JsonbProperty("type")
  private CreditCardType creditCardType;

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public CreditCard number(String number) {
    this.number = number;
    return this;
  }

  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public CreditCard expiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  public Integer getControlNumber() {
    return controlNumber;
  }

  public void setControlNumber(Integer controlNumber) {
    this.controlNumber = controlNumber;
  }

  public CreditCard controlNumber(Integer controlNumber) {
    this.controlNumber = controlNumber;
    return this;
  }

  public CreditCardType getType() {
    return creditCardType;
  }

  public void setType(CreditCardType creditCardType) {
    this.creditCardType = creditCardType;
  }

  public CreditCard creditCardType(CreditCardType creditCardType) {
    this.creditCardType = creditCardType;
    return this;
  }
}
