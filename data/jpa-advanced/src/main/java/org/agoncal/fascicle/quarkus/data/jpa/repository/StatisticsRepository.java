package org.agoncal.fascicle.quarkus.data.jpa.repository;

import org.agoncal.fascicle.quarkus.data.jpa.model.Publisher;
import org.agoncal.fascicle.quarkus.data.jpa.service.StatisticsException;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StatisticsRepository {
  public void add(Publisher publisher) {
  }

  public void computeNewStatistics() throws StatisticsException {
  }
}
