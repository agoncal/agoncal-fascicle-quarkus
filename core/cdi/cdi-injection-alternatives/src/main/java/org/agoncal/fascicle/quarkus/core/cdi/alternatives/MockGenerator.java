package org.agoncal.fascicle.quarkus.core.cdi.alternatives;


import jakarta.enterprise.context.ApplicationScoped;
// @formatter:off
// tag::adocSnippet[]
import jakarta.enterprise.inject.Alternative;

// end::adocSnippet[]
import jakarta.enterprise.inject.Default;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
@ApplicationScoped
// tag::adocSnippet[]
@Alternative
// tag::adocSkip[]
@Default
// end::adocSkip[]
public class MockGenerator implements NumberGenerator {

  public String generateNumber() {
    return "MOCK";
  }
}
// end::adocSnippet[]
