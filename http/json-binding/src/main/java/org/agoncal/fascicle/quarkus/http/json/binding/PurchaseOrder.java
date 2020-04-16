package org.agoncal.fascicle.quarkus.http.json.binding;

import javax.json.bind.annotation.JsonbProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class PurchaseOrder {

  private Long id;
  private LocalDate date;
  @JsonbProperty("content")
  private List<OrderLine> orderLines;
  @JsonbProperty("credit_card")
  private CreditCard creditCard;
  private Customer customer;

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PurchaseOrder id(Long id) {
    this.id = id;
    return this;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public PurchaseOrder date(LocalDate date) {
    this.date = date;
    return this;
  }

  public List<OrderLine> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
  }

  public void addOrderLine(OrderLine orderLine) {
    if (this.orderLines == null) {
      this.orderLines = new ArrayList<>();
    }
    this.orderLines.add(orderLine);
  }

  public CreditCard getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(CreditCard creditCard) {
    this.creditCard = creditCard;
  }

  public PurchaseOrder creditCard(CreditCard creditCard) {
    this.creditCard = creditCard;
    return this;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public PurchaseOrder customer(Customer customer) {
    this.customer = customer;
    return this;
  }
}
