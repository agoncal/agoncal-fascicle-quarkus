package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Book;
import org.agoncal.fascicle.quarkus.data.jpa.model.Publisher;
import org.agoncal.fascicle.quarkus.data.jpa.repository.StatisticsRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

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

  // tag::adocSkip[]
  @Transactional
  public void addNew(Book book) {
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
