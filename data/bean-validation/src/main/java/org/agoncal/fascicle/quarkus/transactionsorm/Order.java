package org.agoncal.fascicle.quarkus.transactionsorm;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;
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
  private BigDecimal totalAmount;
  @Past
  private LocalDate creationDate;
  @NotNull @Valid
  private Customer customer;
  @Valid
  private Address deliveryAddress;
  @NotNull
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

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Order totalAmount(BigDecimal itotalAmountd) {
    this.totalAmount = totalAmount;
    return this;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public Order creationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Address getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(Address deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
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
  // end::adocSkip[]
}
// end::adocSnippet[]
