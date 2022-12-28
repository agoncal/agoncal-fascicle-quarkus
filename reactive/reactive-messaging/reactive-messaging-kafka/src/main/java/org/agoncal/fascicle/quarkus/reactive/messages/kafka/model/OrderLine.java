package org.agoncal.fascicle.quarkus.reactive.messages.kafka.model;

import jakarta.json.bind.annotation.JsonbProperty;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class OrderLine {

  public String item;
  @JsonbProperty("unit_price")
  public Double unitPrice;
  public Integer quantity;
  public Status status;

  public OrderLine() {
  }

  public OrderLine(String item, Double unitPrice, Integer quantity) {
    this.item = item;
    this.unitPrice = unitPrice;
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "OrderLine{" +
      "item='" + item + '\'' +
      ", unitPrice=" + unitPrice +
      ", quantity=" + quantity +
      ", status=" + status +
      '}';
  }
}
