package org.agoncal.fascicle.quarkus.data.bv.ex11;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class Order {

  @NotNull
  private Long id;
  private Double totalAmount;
  @NotNull @Valid
  private Address deliveryAddress;
  private List<@Valid OrderLine> orderLines;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on

  public Order() {
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Order id(Long id) {
    this.id = id;
    return this;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Order totalAmount(Double itotalAmountd) {
    this.totalAmount = totalAmount;
    return this;
  }

  public List<OrderLine> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
  }

  public void add(OrderLine orderLine) {
    if (this.orderLines == null)
      this.orderLines = new ArrayList<>();
    orderLines.add(orderLine);
  }

  public Address getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(Address deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  // end::adocSkip[]
}
// end::adocSnippet[]
