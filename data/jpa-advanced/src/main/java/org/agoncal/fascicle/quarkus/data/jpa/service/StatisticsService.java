package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Publisher;
import org.agoncal.fascicle.quarkus.data.jpa.repository.StatisticsRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

// tag::adocSnippet[]
@ApplicationScoped
public class StatisticsService {

  @Inject
  StatisticsRepository repository;

  @Transactional
  public void addNew(Publisher publisher) throws Exception {
    repository.add(publisher);
    repository.computeNewStatistics();
  }
}
// end::adocSnippet[]
