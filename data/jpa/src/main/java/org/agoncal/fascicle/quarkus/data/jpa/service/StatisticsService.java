package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class StatisticsService {

  @Transactional
  public void addNew(Publisher publisher) throws StatisticsException {
    // throw new StatisticsException();
    // Nothing, just for test purpose
  }
}
