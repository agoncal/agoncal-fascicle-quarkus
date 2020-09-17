package org.agoncal.fascicle.quarkus.reactive.messages.model;

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

  public Long id;
  public LocalDate date;
  @JsonbProperty("purchase_order_content")
  public List<OrderLine> orderLines;
  @JsonbProperty("credit_card")
  public CreditCard creditCard;
  public Customer customer;
  public Status status;

  public PurchaseOrder() {
  }

  public PurchaseOrder(Long id, LocalDate date) {
    this.id = id;
    this.date = date;
  }

  public void addOrderLine(OrderLine orderLine) {
    if (this.orderLines == null) {
      this.orderLines = new ArrayList<>();
    }
    this.orderLines.add(orderLine);
  }
}
