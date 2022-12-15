package org.agoncal.fascicle.quarkus.data.bv.ex11;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class OrderLine {

  public  String item;
  @NotNull @PositiveOrZero
  public  Double unitPrice;
  @NotNull @Positive
  public  Integer quantity;

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

  public OrderLine item(String item) {
    this.item = item;
    return this;
  }

  public OrderLine unitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

  public OrderLine quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
