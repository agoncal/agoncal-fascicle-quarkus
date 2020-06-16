package org.agoncal.fascicle.quarkus.data.bv.ex11;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class OrderLine {

  private String item;
  @NotNull @PositiveOrZero
  private Double unitPrice;
  @NotNull @Positive
  private Integer quantity;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on

  public OrderLine() {
  }

  public OrderLine(String item, Double unitPrice, Integer quantity) {
    this.item = item;
    this.unitPrice = unitPrice;
    this.quantity = quantity;
  }

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
  // end::adocSkip[]
}
// end::adocSnippet[]
