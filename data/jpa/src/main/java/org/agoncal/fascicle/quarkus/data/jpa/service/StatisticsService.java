package org.agoncal.fascicle.quarkus.data.jpa.service;

import org.agoncal.fascicle.quarkus.data.jpa.model.Publisher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

// tag::adocSnippet[]
@ApplicationScoped
public class StatisticsService {

  @Inject
  UserTransaction tx;

  @Inject
  StatisticsRepository repository;

  @Transactional
  public void addNew(Publisher publisher) throws Exception {
    try {
      tx.begin();
      repository.add(publisher);
      repository.computeNewStatistics();
      tx.commit();
    } catch (StatisticsException e) {
      tx.rollback();
    }
  }
  // tag::adocSkip[]

  private class StatisticsRepository {
    public void add(Publisher publisher) {
    }

    public void computeNewStatistics() throws StatisticsException {
      throw new StatisticsException();
    }
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
