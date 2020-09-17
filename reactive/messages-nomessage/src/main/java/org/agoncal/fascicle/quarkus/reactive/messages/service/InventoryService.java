package org.agoncal.fascicle.quarkus.reactive.messages.service;

import org.agoncal.fascicle.quarkus.reactive.messages.model.OrderLine;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class InventoryService {
  public void prepareItems(List<OrderLine> orderLines) {

  }
}
