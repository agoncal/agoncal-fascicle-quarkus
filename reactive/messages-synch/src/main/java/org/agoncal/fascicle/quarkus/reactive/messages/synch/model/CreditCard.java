package org.agoncal.fascicle.quarkus.reactive.messages.synch.model;

import javax.json.bind.annotation.JsonbProperty;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CreditCard {

  public String number;
  @JsonbProperty("expiry_date")
  public String expiryDate;
  @JsonbProperty("control_number")
  public Integer controlNumber;
  @JsonbProperty("type")
  public CreditCardType creditCardType;
  public Status status;

  public CreditCard() {
  }

  public CreditCard(String number, String expiryDate, Integer controlNumber, CreditCardType creditCardType) {
    this.number = number;
    this.expiryDate = expiryDate;
    this.controlNumber = controlNumber;
    this.creditCardType = creditCardType;
  }

  @Override
  public String toString() {
    return "CreditCard{" +
      "number='" + number + '\'' +
      ", expiryDate='" + expiryDate + '\'' +
      ", controlNumber=" + controlNumber +
      ", creditCardType=" + creditCardType +
      ", status=" + status +
      '}';
  }
}
