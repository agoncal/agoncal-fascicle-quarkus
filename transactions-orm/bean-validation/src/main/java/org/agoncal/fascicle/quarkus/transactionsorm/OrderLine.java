package org.agoncal.fascicle.quarkus.transactionsorm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

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
  private BigDecimal unitPrice;
  @NotNull @Positive
  private Integer quantity;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on

  public OrderLine() {
  }

  public OrderLine(String item, BigDecimal unitPrice, Integer quantity) {
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

  public BigDecimal getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }

  public OrderLine unitPrice(BigDecimal unitPrice) {
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
