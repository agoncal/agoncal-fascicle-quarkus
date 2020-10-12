package org.agoncal.fascicle.quarkus.data.bv.ex01;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.Instant;
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

  @NotNull @Pattern(regexp = "[CDM][0-9]+")
  public String orderId;
  @NotNull @Min(1)
  public BigDecimal totalAmount;
  @PastOrPresent
  public Instant creationDate;
  @Future
  public LocalDate deliveryDate;

  @NotNull
  public List<OrderLine> orderLines;

  public Order(@PastOrPresent Instant creationDate) {
    this.creationDate = creationDate;
  }

  @NotNull
  public Double calculateTotalAmount(@Positive Double changeRate) {
    return complexCalculation();
  }

  // tag::adocSkip[]
  public Order() {
  }

  private Double complexCalculation() {
    return 1d;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public void addOrderLine(OrderLine orderLine) {
    if (this.orderLines == null)
      this.orderLines = new ArrayList<>();

    this.orderLines.add(orderLine);
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
