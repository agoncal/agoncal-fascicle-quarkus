package org.agoncal.fascicle.quarkus.data.bv.ex01;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class OrderLine {

  // ======================================
  // =             Attributes             =
  // ======================================

  public String item;
  public Double unitPrice;
  public Integer quantity;

  // ======================================
  // =            Constructors            =
  // ======================================

  public OrderLine() {
  }

  public OrderLine(String item, Double unitPrice, Integer quantity) {
    this.item = item;
    this.unitPrice = unitPrice;
    this.quantity = quantity;
  }

}
