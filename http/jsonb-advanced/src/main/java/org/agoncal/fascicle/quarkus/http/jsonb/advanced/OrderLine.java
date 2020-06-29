package org.agoncal.fascicle.quarkus.http.jsonb.advanced;

import javax.json.bind.annotation.JsonbProperty;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class OrderLine {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String item;
  @JsonbProperty("unit_price")
  private Double unitPrice;
  private Integer quantity;

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public OrderLine item(String item) {
    this.item = item;
    return this;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public OrderLine unitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public OrderLine quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }
}
