package org.agoncal.fascicle.quarkus.reactive.messages.service;

import org.agoncal.fascicle.quarkus.reactive.messages.model.Address;
import org.agoncal.fascicle.quarkus.reactive.messages.model.OrderLine;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ShippingService {
  public void shipItems(List<OrderLine> orderLines, Address shippingAddress) {

  }
}
